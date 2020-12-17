package com.yc.damai.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.biz.BizException;
import com.yc.damai.biz.OrdersBiz;
import com.yc.damai.po.Orders;
import com.yc.damai.po.Result;
import com.yc.damai.po.User;

@RestController
public class OrderAction {
	
	@Resource
	private OrdersBiz obiz;
	
	public Result pay(Orders orders, HttpSession session) {
		try {
			User user = (User) session.getAttribute("loginedUser");
			orders.setUid(user.getUid());
			obiz.pay(orders);
			return Result.success("下单成功!");
		} catch (BizException e) {
			e.printStackTrace();
			return Result.failure(e.getMessage());
		}
	}

}
