package com.yc.mvc.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.mvc.dao.CategoryMapper;
import com.yc.mvc.po.JsjCategory;

@Service
public class CategoryBiz {

	@Resource
	private CategoryMapper cm;
	
	@Transactional
	public void insert(JsjCategory category) throws BizException {
		if (cm.selectByName(category.getName())!=null) {
			throw new BizException("该分类已存在！");
		}
		cm.insert(category.getName());
	}
}
