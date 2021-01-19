package com.yc.mvc.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.mvc.biz.CartBiz;
import com.yc.mvc.po.JsjCart;
import com.yc.mvc.web.po.Result;

@RestController
public class CartAction {

	@Resource
	private CartBiz cb;

	@RequestMapping("addCart.do")
	public Result addCart(JsjCart cart) {
		cb.addCart(cart);
		return Result.success("添加购物车成功！", null);
	}

}
