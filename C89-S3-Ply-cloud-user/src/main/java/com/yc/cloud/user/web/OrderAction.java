package com.yc.cloud.user.web;

import org.springframework.stereotype.Component;

import com.yc.cloud.user.bean.Numbers;

/**
 * 	实现的方法是降级后执行的方法
 * @author oyt
 *
 */
@Component
public class OrderAction implements IOrderAction{

	@Override
	public String orderWay() {
		return "降级后的way： user's order way";
	}

	@Override
	public String add(Numbers numbers) {
		return "降级后的add：" + ( numbers.getA() + numbers.getB());
	}

	@Override
	public String show(Integer a) {
		return "降级后的show：" + a;
	}

}
