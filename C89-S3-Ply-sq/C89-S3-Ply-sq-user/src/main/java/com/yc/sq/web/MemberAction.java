package com.yc.sq.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.sq.bean.Result;
import com.yc.sq.bean.SqMember;
import com.yc.sq.biz.BizException;
import com.yc.sq.biz.MemberBiz;

@RestController
public class MemberAction {

	@Resource
	private MemberBiz mb;

	@RequestMapping("login")
	public Result login(SqMember sm, HttpSession session) {
		try {
			SqMember ret = mb.login(sm);
			session.setAttribute("loginedUser", ret);
			return Result.success("登录成功", null);
		} catch (BizException e) {
			e.printStackTrace();
			return Result.failure(e.getMessage(), null);
		}
	}

}
