package com.yc.C89S2Plyspringboot.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.C89S2Plyspringboot.dao.Account;
import com.yc.C89S2Plyspringboot.dao.AccountDao;

/**
 * SpringMVC 框架的控制器类  相当于 servlet
 * 
 */
@RestController // 控制器组件注解 ， 是 Controller 注解的 子注解
public class IndexAction {
	
	// SpringMVC 注解  控制器方法， 相当于 servlet doGet，doPost
	@RequestMapping("hello.action")
	public String hello() {
		return "hello world";
	}
	
	// SpringMVC 会自动转 json
	@Resource
	private AccountDao adao;
	
	@RequestMapping("alist.action")
	public List<Account> query(){
		return adao.selectAll();
	}

}
