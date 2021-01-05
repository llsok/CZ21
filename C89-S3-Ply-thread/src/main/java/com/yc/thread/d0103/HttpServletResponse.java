package com.yc.thread.d0103;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

public class HttpServletResponse {
	
	private Socket socket;
	private HttpServletRequest req;
	
	private HashMap<String,String> headerMap = new HashMap<String, String>();
	private int code = 200;
	private String msg = "OK";
	
	public HttpServletResponse(Socket socket, HttpServletRequest req) {
		this.socket = socket;
		this.req = req;
	}

	// 设置头域参数
	public void setHeader(String name, String value) {
		headerMap.put(name, value);
	}

	// 设置头域参数 => Content-Type
	public void setContentType(String type) {
		setHeader("Content-Type", type);
	}

	// 设置结果码
	public void setStatus(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	// 获取字符流
	public void getWriter() {
		// TODO 未完待续 ==> Servlet
	}
	
	// 获取字节流
	public OutputStream getOutputStream() throws IOException {
		return socket.getOutputStream();
	}
	
	// 发送响应
	public void flushBuffer() throws IOException {
		
		String path = req.getServletPath(); 
		
		// 将响应报文推送到 浏览器
		OutputStream out = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(out);
		
		// 响应头行
		pw.printf("HTTP/1.1 %d %s\n" , code, msg);
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
		// Tomcat ==> ServletContext ==> 应用上下文对象
		FileInputStream fis = new FileInputStream(Tomcat.webContent + path);
		byte[] buffer = new byte[1024];
		int count;
		while((count = fis.read(buffer))>0) {
			out.write(buffer, 0, count);
		}
		fis.close();
		
	}
}
