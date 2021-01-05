package com.yc.thread.d0103;

import java.io.CharArrayWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

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
	
	
	// 内存存储缓冲区流: 字符数组输出流, 将字符串输出到 内存中, 最后通toString返回内容
	CharArrayWriter caw = new CharArrayWriter();
	PrintWriter pw = new PrintWriter(caw);
	
	// 获取字符流
	public PrintWriter getWriter() {
		// TODO 未完待续 ==> Servlet
		return pw;
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
		
		/*输出cookie*/
		for(Cookie c : cookieList) {
			pw.println(c);
		}
		
		/*输出响应头域的其他的字段*/
		for(Entry<String,String> entry : headerMap.entrySet()) {
			pw.printf("%s: %s\n", entry.getKey(), entry.getValue());
		}
		
		// 空行
		pw.println();
		pw.flush();
		
		String content = caw.toString();
		// 响应实体
		if( code >= 300 & code <=399) {
			// 没有实体 body
		} else if(content.isEmpty() == false) {
			// 输出内存中的数据 ==> 动态请求
			out.write(content.getBytes());
		} else {
			// 直接输出文件 ==> 静态请求
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
	
	/**
	 * 响应报文中 每一个cookie项, 将产生一行 以上代码
	 * @param cookie
	 */
	List<Cookie> cookieList = new ArrayList<>();
	public void addCookie(Cookie cookie) {
		cookieList.add(cookie);
	}

	/**
	 * 响应重定向
	 * @param path
	 */
	public void sendRedirect(String path) {
		// 设置结果码
		this.setStatus(301, "Redirect");
		// 设置跳转的页面
		this.headerMap.put("Location", path);
	}
}
