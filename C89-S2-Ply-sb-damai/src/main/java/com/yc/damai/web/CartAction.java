package com.yc.damai.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.dao.CartDao;

@RestController
public class CartAction {

	@Resource
	private CartDao cdao;
	
	@RequestMapping(path="cart.s" ,params = "op=deleteCart")
	public void deleteCart() {
		
	}
}
