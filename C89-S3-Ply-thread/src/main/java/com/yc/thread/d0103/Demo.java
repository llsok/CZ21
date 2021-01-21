package com.yc.thread.d0103;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo {
	/**
	 * 请求报文的格式:
	 * 	1. 请求头行: 格式 : 请求方法  空格 资源地址 空格 协议版本
	 * 	2. 请求头域: 格式: 多行构成, 每行一对键值对  键: 值
	 * 		空行
	 * 	3. 请求实体: 格式变化很大
	 * 
	 * 响应报文的格式:
	 * 	1. 响应头行: 格式: 协议版本  空格 响应码 空格 响应码的描述文字(英文)   HTTP/1.1 200 OK
	 * 			结果码取值:
	 * 				1xx : 100~199 的编码 表示服务器接收请求,继续处理
	 * 				2xx : 服务器响应正确结果  200
	 * 				3xx : 响应重定向 要浏览器重新发送请求另一个资源  301,302,304
	 * 				4xx : 浏览器端错误, 404 服务器资源不存在, 405 请求的方法不对 , 400 请求参数错误
	 * 				5xx : 服务器端错误, 500服务器内部错误, 503 服务器暂时不可用(系统升级)
	 *	2. 响应头域: 格式参考请求头域
	 *		空行
	 *	3. 响应实体: 格式变化多端
	 *
	 *
	 *	HttpServletRequest a = null;
	 *	a.getServletPath(); // 请求地址
		a.getMethod();		// 请求方法  get post
		a.getParameter("参数名"); // 请求参数  底层==> map
		a.getParameterValues("数组型的参数名"); //请求参数  index.html?a=1&a=2&a=3  ==> String[] a = {1,2,3}
		a.getCookies();		// 获取cookie
		a.getContentType(); // 获取内容类型
		a.getHeader("头域字段名");  // 底层==> map
	 *
	 * 
	 * 动态请求的响应:
	 * 	Servlet ==> HttpServlet
	 */

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8080);
		System.out.println("web服务器启动成功:8080");
		boolean running = true;
		while (running) {
			Socket socket = server.accept();
			byte[] buffer = new byte[1024 * 4];
			int count;
			while ((count = socket.getInputStream().read(buffer)) > 0) {
				System.out.print(new String(buffer, 0, count));
			}
			System.out.println();
			System.out.println("=============================");
			socket.close();
		}
		server.close();
	}

}
