package com.yc.damai.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.damai.dao.ProductDao;
import com.yc.damai.po.Product;
import com.yc.damai.util.Utils;

@Service
public class ProductBiz {
	
	@Resource
	private ProductDao pdao;
	
	@Transactional
	public void create(Product p) throws BizException{
		// 验证输入
		Utils.checkNull(p.getPname(), "商品名称不能为空");
		// ...其他字段请自行扩展: 2价格,图片,说明
		
		// 添加到数据库
		pdao.insert(p);
	}

}
