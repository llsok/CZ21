package com.yc.thread.d0103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;

public class HttpServletRequest {
	
	private String method;
	private String servletPath;
	private Cookie[] cookies;
	private HashMap<String,String> headerMap = new HashMap<String, String>();
	private HashMap<String,String> paramsMap = new HashMap<String, String>();

	public HttpServletRequest(Socket socket) throws IOException {
		InputStream in = socket.getInputStream();
		/**
		 * 解析请求报文  GET, 没有实体
		 */
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		String line;
		int i = 0;
		while( ( line = br.readLine() ).isEmpty() == false ) {
			System.out.println(line);
			if(i==0) {
				// line 是请求头行
				String[] items = line.split("\\s");
				method = items[0];
				servletPath = items[1];
				// 忽略协议
				if(servletPath.contains("?")) {
					// index.html?a=1&b=2&c=3
					int index = servletPath.indexOf("?");
					String paramsString = servletPath.substring(index+1);
					servletPath = servletPath.substring(0, index);
					for(String paramItemString : paramsString.split("&")) {
						// paramItemString ==> a=1;
						items = paramItemString.split("=");
						paramsMap.put(items[0], items[1]);
					}
				}
				
			} else {
				// line 是请求头域里面一个字段
				String[] items = line.split(":\\s");  // ? 0~1, * 0~N , + 1~N , {2,3}
				String key = items[0];
				String val = items[1];
				headerMap.put(key, val);
			}
			i++;
		}
		System.out.println("解析后的请求对象");
		System.out.println(this);
		
	}
	

	public String getServletPath() {
		return servletPath;
	}

	public String getMethod() {
		return method;
	}

	public String getParameter(String name) {
		return paramsMap.get(name);
	}

	public void getParameterValues(String name) {
		// TODO 未完待续...
	}

	/**
	 * Cookie: _gcl_au=1.1.1815177047.1608098912; _ga=GA1.2.1696117590.1608098912; 
	 */
	public Cookie[] getCookies() {
		// TODO 解析cookie 返回Cookie数组, 未完待续...
		if(cookies==null) {
			String cookieString = headerMap.get("Cookie");
			if(cookieString == null) {
				return null;
			}
			String[] cookieItems = cookieString.split(";\\s*");
			cookies = new Cookie[cookieItems.length];
			for(int i=0; i<cookies.length ; i++) {
				String[] items = cookieItems[i].split("=");
				cookies[i] = new Cookie(items[0],items[1]);
			}
		}
		return cookies;
	}

	public String getContentType() {
		return headerMap.get("Content-Type");
	}

	public String getHeader(String name) {
		return headerMap.get(name);
	}


	@Override
	public String toString() {
		return "HttpServletRequest [method=" + method + ", \nservletPath=" + servletPath + ", \ncookies="
				+ Arrays.toString(getCookies()) + ", \nheaderMap=" + headerMap + ", \nparamsMap=" + paramsMap + "]";
	}

}
