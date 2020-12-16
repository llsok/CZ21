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
	
	@RequestMapping(path="product.s",params = "op=queryHot")
	public List<Product> queryHot(){
		return pdao.selectHot();
	}
	
	@RequestMapping(path="product.s",params = "op=queryProductByCid")
	public List<Product> queryProductByCid(int cid){
		return pdao.queryProductByCid(cid);
	}
	@RequestMapping(path="product.s",params = "op=queryProductByCsid")
	public List<Product> queryProductByCsid(int csid){
		return pdao.queryProductByCsid(csid);
	}
	
	@RequestMapping(path="product.s",params = "op=queryNewProduct")
	public List<Product> queryNqueryNewProductew(){
		return pdao.queryNewProduct();
	}
	
	@RequestMapping(path="product.s",params = "op=queryProductById")
	public Product queryProductById(int pid){
		return pdao.queryProductById(pid);
	}
}
