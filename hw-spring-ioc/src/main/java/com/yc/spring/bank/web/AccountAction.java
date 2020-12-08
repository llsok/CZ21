package com.yc.spring.bank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.yc.spring.bank.biz.AccountBiz;

/**
 * 控制层
 */
@Controller
public class AccountAction {
	
	/**
	 * 自动装载其他组件
	 */
	@Autowired
	private AccountBiz ab;

	public AccountBiz getAb() {
		return ab;
	}

	
}
