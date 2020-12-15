<<<<<<< HEAD
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
	
	@RequestMapping("selectList")
	public List<?> selectList(int id){
		System.out.println(id+"------------csid");
		return pdao.selectList(id);
	}
}
=======
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
>>>>>>> branch 'main' of https://github.com/llsok/CZ21.git
