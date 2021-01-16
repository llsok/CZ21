package com.yc.mvc.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yc.mvc.biz.BizException;
import com.yc.mvc.biz.UserBiz;
import com.yc.mvc.po.JsjUser;
import com.yc.mvc.web.po.Result;

@RestController
public class UserAction {

	@Resource
	private UserBiz ubiz;

	@PostMapping("login.do")
	public Result login(JsjUser user, HttpSession session) {
		JsjUser dbuser;
		try {
			dbuser = ubiz.login(user);
			session.setAttribute("loginedUser", dbuser);
			return Result.success("登录成功！", dbuser);
		} catch (BizException e) {
			e.printStackTrace();
			return Result.failure(e.getMessage(), null);
		}
	}
	
	@RequestMapping("getLoginedUser.do")
	public Result getLoginedUser(@SessionAttribute JsjUser loginedUser) {
		return Result.success("获取用户对象成功", loginedUser);
	}

}
