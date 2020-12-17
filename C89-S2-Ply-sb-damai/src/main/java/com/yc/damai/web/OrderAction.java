package com.yc.damai.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.biz.BizException;
import com.yc.damai.biz.OrdersBiz;
import com.yc.damai.dao.OrdersDao;
import com.yc.damai.po.Orders;
import com.yc.damai.po.Result;
import com.yc.damai.po.User;

@RestController
public class OrderAction {
	
	@Resource
	private OrdersBiz obiz;
	
	@Resource
	private OrdersDao odao;
	
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
	
	@RequestMapping(path="olist.s" ,params = "op=queryOlist")
	public List<?> queryCart(HttpSession session){
		User user = (User) session.getAttribute("loginedUser");
		return odao.selectOrders(user.getUid());
	}
	

}
