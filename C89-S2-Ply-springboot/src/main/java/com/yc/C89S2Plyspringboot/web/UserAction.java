package com.yc.C89S2Plyspringboot.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.C89S2Plyspringboot.biz.BankBiz;

@RestController
public class UserAction {

	/**
	 * SpringMVC 接收请求参数的语法
	 * 
	 * HttpSession SpringMVC会自动的注入一个会话对象
	 * 
	 * @return
	 */
	@Resource
	private BankBiz bbiz;

	@RequestMapping("sendVcode")
	public String sendVcode(String name, HttpSession session) {
		// 根据用户名发送验证短信（业务逻辑， BankBiz.sendVcode）
		String vcode = bbiz.sendVcode(name);
		// 将验证码保存到会话
		session.setAttribute("vcode", vcode);
		// 通知浏览器发送成功
		return "验证码邮件发送成功！";
	}
	
	@RequestMapping("resetPwd")
	public String resetPwd(String name, String vcode, String pwd, HttpSession session) {
		return bbiz.resetPwd(name, vcode, pwd, (String) session.getAttribute("vcode"));
	}

}
