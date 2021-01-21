package com.yc.mvc.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.mvc.po.JsjOrder;
import com.yc.mvc.po.JsjOrderDetail;
import com.yc.mvc.po.JsjUser;
import com.yc.mvc.web.po.Result;

@RestController
public class OrderAction {

	@PostMapping("addOrder")
	public Result addOrder(JsjOrder order,JsjUser loginedUser) {
		System.out.println(order);
		return Result.success("订单提交成功", null);
	}
}
