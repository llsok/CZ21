package com.yc.mvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.google.gson.Gson;
import com.yc.mvc.web.po.Result;

/**
 * 	登录拦截器， 对访问指定的资源请求进行拦截
 * 	1. 实现 拦截器接口（SpringMVC提供）
 * 	2. 将拦截器配置到 主类 MvcApp
 * 
 * 	标记接口 （没有方法的接口，例如：序列化接口）？ 
 * 
 * HandlerInterceptor 燃鹅并不是，接口方法可以提供默认实现
 * 	preHandle		前置
 * 	postHandle		后置
 * 	afterCompletion	完成
 * 	
 * 	请求到达
 * 		try{
	 * 		preHandle
	 * 		控制器方法 （有可能异常）
	 * 		postHandle
	 * } finally {
	 * 		afterCompletion
	 * }
 * 
 * 
 * 
 */
public class LoginInterceptor implements HandlerInterceptor {

	/**
	 *  	拦截器的preHandle方法的返回值
	 *  		true： 允许访问目标资源
	 *  		false： 不允许。。。
	 *  	Object handler ： 控制器对象
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("handler:"+handler); 
		if(request.getSession().getAttribute("loginedUser")==null) {
			//这种请求下，浏览器将会接收到什么信息？
			if(request.getHeader("Accept").contains("application/json")) {
				// 如果是AJAX请求， 那么要返回一个正确的json字符串，里面包含提示用户重新登录信息
				Result res = Result.failure("请先登录系统", null);
				String json = new Gson().toJson(res);
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().append(json);
			} else {
				// 如果是访问页面，那么要将访问重定向到登录页
				response.sendRedirect("login.html");
			}
			return false;
		} else {
			return true;
		}
	}

}
