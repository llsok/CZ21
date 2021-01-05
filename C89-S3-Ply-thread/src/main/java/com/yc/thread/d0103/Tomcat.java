package com.yc.thread.d0103;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Tomcat {

	private int port = 8080;
	private boolean running = true;
	public static String webContent = "d:/tomcat";
	
	private HashMap<String, HttpServlet> servletMap = new HashMap<String, HttpServlet>();
	
	// servlet.getServletContext().getContextPath ==> webContent
	// ServletContext 应用上下文对象 , 全局最大的对象: 作用域广, 生命周期长

	/**
	 * 启动服务
	 * 127.0.0.1:8080/submit.html ==> d:/tomcat/submit.html
	 */
	public void startup() throws IOException {
		
		/**
		 * 初始化Servlet容器, 省略了读取Servlet配置的过程
		 */
		servletMap.put("/hello.s", new HelloServlet());
		servletMap.put("/redirect.s", new RedirectServlet());
		// TODO

		ServerSocket server = new ServerSocket(port);
		System.out.println("web服务器启动成功: " + port);

		while (running) {
			Socket socket = server.accept();

			new Thread() {
				public void run() {
					try {
						
						HttpServletRequest req = new HttpServletRequest(socket);
						
						HttpServletResponse resp = new HttpServletResponse(socket, req);
						
						// 构建Servlet容器 ==> 将Servlet对象放入容器
						
						// 判断是静态请求还是动态请求
						// 1. 根据请求的地址, 在Servlet容器中查找Servlet对象
						HttpServlet servlet = null;
						for(  String path : servletMap.keySet() ) {
							if(path.equals(req.getServletPath())) {
								servlet = servletMap.get(path);
								break;
							}
						}
						// 2. 如果找到那么就是动态请求
						if(servlet != null) {
							servlet.service(req, resp);
						} else {
							// 3. 如果没有找到就是静态请求 ==> 静态文件没有,那就报出404错误
							// TODO
						}
						resp.flushBuffer();
						
					} catch (IOException e) {
						throw new RuntimeException("Socket操作失败!", e);
					} finally {
						try {
							socket.close();
						} catch (IOException e) {
							throw new RuntimeException("关闭Socket失败!", e);
						}
					}
				}
			}.start();

		}
		server.close();

	}

	/**
	 * 停止服务
	 */
	public void shutdown() {
		running = false;
	}

	
	public static void main(String[] args) throws IOException {
		new Tomcat().startup();
	}
}
