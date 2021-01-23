package com.yc.mvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.google.gson.Gson;
import com.yc.mvc.web.po.Result;

public class AdminLoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("handler:"+handler); 
		if(request.getSession().getAttribute("loginedAdmin")==null) {
			//这种请求下，浏览器将会接收到什么信息？
			if(request.getHeader("Accept").contains("application/json")) {
				// 如果是AJAX请求， 那么要返回一个正确的json字符串，里面包含提示用户重新登录信息
				Result res = Result.failure("请先登录系统", null);
				String json = new Gson().toJson(res);
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().append(json);
			} else {
				// 如果是访问页面，那么要将访问重定向到登录页
				response.sendRedirect("/back/index.html");
			}
			return false;
		} else {
			return true;
		}
	}

}
