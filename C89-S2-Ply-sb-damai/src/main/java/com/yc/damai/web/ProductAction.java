package com.yc.damai.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.dao.ProductDao;
import com.yc.damai.po.Product;

@RestController
public class ProductAction {
	
	@Resource
	private ProductDao pdao;
	
	@RequestMapping(path="product.s",params="op=queryHot")
	public List<?> queryHot(){
		return pdao.selectHot();
	}
	
	@RequestMapping("queryProduct")
	public Product queryById(int id) {
		return pdao.selectById(id);
	}

}
