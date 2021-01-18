package com.yc.mvc.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.mvc.dao.CategoryMapper;
import com.yc.mvc.po.JsjCategory;

@RestController
public class CategoryAction {

	@Resource
	private CategoryMapper cm;
	
	@RequestMapping("selectByCateId.do")
	public JsjCategory selectById(int category ){
		return cm.selectById(category);
	}
	
	@RequestMapping("selectAllCate.do")
	public List<JsjCategory> selectAllCate(){
		return cm.selectAll();
	}
}
