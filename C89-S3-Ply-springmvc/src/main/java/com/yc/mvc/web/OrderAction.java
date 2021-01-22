package com.yc.mvc.web;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yc.mvc.biz.OrderBiz;
import com.yc.mvc.dao.OrderDetailMapper;
import com.yc.mvc.dao.OrderMapper;
import com.yc.mvc.po.JsjCart;
import com.yc.mvc.po.JsjOrder;
import com.yc.mvc.po.JsjOrderDetail;
import com.yc.mvc.po.JsjUser;
import com.yc.mvc.web.po.Result;

@RestController
public class OrderAction {
	
	@Resource
	private OrderBiz ob;
	@Resource
	private OrderMapper om;
	@Resource
	private OrderDetailMapper odm;

	@PostMapping("addOrder")
	public Result addOrder(@Valid JsjOrder order,Errors errors, @SessionAttribute JsjUser loginedUser) {
		if (errors.hasErrors()) {
			return Result.failure("字段验证错误！", errors.getAllErrors());
		}
		try {
			order.setUid((long) loginedUser.getId());
			ob.addOrder(order);
			return Result.success("订单提交成功！", null);
		} catch (Exception e) {
			e.printStackTrace(); //压抑异常
			return Result.failure("订单提交失败！", null);
		}
	}
	
	@RequestMapping("querySellOrder")
	public List<JsjOrderDetail> queryCartByUid(@SessionAttribute JsjUser loginedUser) {
		return odm.queryOrderByOwnId(loginedUser.getId());
	} 
	
	@RequestMapping("queryOrderList")
	public List<JsjOrder> queryOrderListByUid(@SessionAttribute JsjUser loginedUser) {
		return om.queryOrderListByUid(loginedUser.getId());
	}

}
