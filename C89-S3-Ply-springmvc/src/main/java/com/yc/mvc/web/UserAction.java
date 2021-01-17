package com.yc.mvc.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yc.mvc.biz.BizException;
import com.yc.mvc.biz.UserBiz;
import com.yc.mvc.dao.UserMapper;
import com.yc.mvc.po.JsjUser;
import com.yc.mvc.web.po.Result;

@RestController
public class UserAction {

	@Resource
	private UserBiz ubiz;
	
	@PostMapping("login.do")
	public Result login(JsjUser user, HttpSession session) throws BizException {
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
	
	/**
	 * 	注册用户， SpringMVC 验证功能
	 * 	第一步：pom依赖：添加验证依赖
	 *  <dependency>
			<groupId>javax.validation</groupId>
			<artifactId>validation-api</artifactId>
		</dependency>
		<dependency>
			<groupId>org.hibernate.validator</groupId>
			<artifactId>hibernate-validator</artifactId>
		</dependency>
		规范数据验证：JSR303规范
		
		第二步：在实体类属性上添加验证注解
		第三步： 在控制器方法中定义 错误对象
			1. 在被验证的对象前添加 Valid 注解
			2.在被验证的对象后添加 Errors 对象参数（必须是紧跟被验证的对象参数后）
		
	 * @param user
	 * @return
	 */
	@RequestMapping("regist.do")
	public Result regist(@Valid JsjUser user, Errors errors) {
		// 判断是否出现验证错误
		if(errors.hasErrors()) {
			return Result.failure("字段验证错误！", errors.getAllErrors());
		}
		// TODO 业务层代码， 未完待续
		try {
			ubiz.register(user);
			return Result.success("注册成功！", null);
		} catch (Exception e) {
			//e.printStackTrace();
			errors.rejectValue("account", "NotOne", e.getMessage());
			return Result.failure("字段验证错误", errors.getAllErrors());
		}
		
	}

}
