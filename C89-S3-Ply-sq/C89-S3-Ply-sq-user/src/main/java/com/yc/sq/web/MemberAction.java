package com.yc.sq.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
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

	/**
	 * Feign 接口方法参数要加 RequstBody 注解
	 */
	@RequestMapping("login")
	public Result login(@Valid @RequestBody SqMember sm,Errors errors,HttpSession session) {
		 try {
			 if(errors.hasFieldErrors("name")||errors.hasFieldErrors("pwd")) {
				 return Result.failure("字段验证错误", errors.getAllErrors());
			 }
			SqMember ret = mb.login(sm);
			session.setAttribute("loginedUser", ret);
			// 登录成功之后，将用户对象发送给调用中
			return Result.success("登录成功", ret);
		} catch (BizException e) {
			e.printStackTrace();
			return Result.failure(e.getMessage(), null);
		}
	}
	
	@RequestMapping("regist")
	public Result regist(@Valid @RequestBody SqMember sm, Errors errors) {
		
		if (errors.hasFieldErrors("phone") || errors.hasFieldErrors("name") 
				|| errors.hasFieldErrors("pwd")) {
			return Result.failure("字段验证错误！", errors.getAllErrors());
		}
		try {
			mb.register(sm);
			return Result.success("注册成功！", null);
		} catch (Exception e) {
			errors.rejectValue("name", "NotOne", e.getMessage());
			return Result.failure("字段验证错误", errors.getAllErrors());
		}

	}

}
