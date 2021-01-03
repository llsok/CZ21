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
	private String webContent = "d:/tomcat";

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
						byte[] buffer = new byte[1024 * 4];
						int count;
						count = socket.getInputStream().read(buffer);
						String request = new String(buffer, 0, count);
						System.out.print(request);
						System.out.println();
						System.out.println("=============================");
						
						String path = request.split("\\s")[1];
						
						OutputStream out = socket.getOutputStream();
						PrintWriter pw = new PrintWriter(out);
						
						// 响应头行
						pw.println("HTTP/1.1 200 OK");
						// 响应头域
						if(path.endsWith(".css")) {
							pw.println("Content-Type: text/css; charset=utf-8");
						} else if(path.endsWith(".js")) {
							pw.println("Content-Type: application/javascript; charset=utf-8");
						} else {
							// 图片也可以写成 text/html
							pw.println("Content-Type: text/html; charset=utf-8");
						}
						// 空行
						pw.println();
						pw.flush();
						// 响应实体
						//pw.println("<h1>hello world!</h1>");
						/*BufferedReader br = new BufferedReader(new FileReader(webContent + path));
						String line;
						while((line = br.readLine())!=null) {
							pw.println(line);
						}*/
						FileInputStream fis = new FileInputStream(webContent + path);
						while((count = fis.read(buffer))>0) {
							out.write(buffer, 0, count);
						}
						fis.close();
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
