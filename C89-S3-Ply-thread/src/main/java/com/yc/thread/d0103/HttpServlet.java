package com.yc.thread.d0103;

import java.io.IOException;

public class HttpServlet {
	
	/**
	 * 定义Servlet三个步骤
	 * 1. 继承 HttpServlet
	 * 2. 重写 doGet doPost doDelete doOption doXXX...
	 * 3. 配置( xml , 注解)
	 * 	
	 * 	Servlet 生命周期方法:
	 * 	1. init() 初始化		执行 0~1 次
	 * 	2. destroy() 销毁		执行 0~1 次
	 * 	3. service() 服务		执行 0~N 次
	 * 		判断当前请求的 method 值, get ==> doGet, post ==> doPost
	 *		请求分发器 
	 * 
	 * 	Servlet 在默认情况下, 未接受到请求时, 不会被创建, 在接收到第一个请求时, 才会被创建
	 * 		创建之后, 会被 服务器保存在 Servlet 容器中
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// throw new ServletExcepton("405");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// throw new ServletExcepton("405");
	}
	
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO
	}
	
	public void init() {
		
	}
	
	public void destroy() {
		
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if("GET".equals(request.getMethod())){
			doGet(request, response);
		} else if("POST".equals(request.getMethod())){
			doPost(request, response);
		} else if("DELETE".equals(request.getMethod())){
			doDelete(request, response);
		} else {
			// TODO
		}
	}

}
