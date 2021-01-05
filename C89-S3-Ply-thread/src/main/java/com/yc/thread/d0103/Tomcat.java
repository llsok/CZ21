package com.yc.thread.d0103;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Tomcat {

	private int port = 8080;
	private boolean running = true;
	public static String webContent = "d:/tomcat";
	// servlet.getServletContext().getContextPath ==> webContent
	// ServletContext 应用上下文对象 , 全局最大的对象: 作用域广, 生命周期长

	/**
	 * 启动服务
	 * 127.0.0.1:8080/submit.html ==> d:/tomcat/submit.html
	 */
	public void startup() throws IOException {

		ServerSocket server = new ServerSocket(port);
		System.out.println("web服务器启动成功: " + port);

		while (running) {
			Socket socket = server.accept();

			new Thread() {
				public void run() {
					try {
						
						HttpServletRequest req = new HttpServletRequest(socket);
						
						HttpServletResponse resp = new HttpServletResponse(socket, req);
						
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
