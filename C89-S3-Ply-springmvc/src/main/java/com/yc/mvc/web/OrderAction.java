package com.yc.mvc.web;

import com.yc.mvc.po.JsjOrder;
import com.yc.mvc.po.JsjUser;
import com.yc.mvc.web.po.Result;

public class OrderAction {
	
	public Result addOrder(JsjOrder order, JsjUser loginedUser) {
		System.out.println(order);
		return Result.success("订单提交成功", null);
	}
}
