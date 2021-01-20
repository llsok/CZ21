package com.yc.thread.d0101;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlDemo {

	public static void main(String[] args) throws IOException {

		URL url = new URL("http://www.hyycinfo.com/index.html");
		// 开启连接
		URLConnection conn = url.openConnection();
		// 获取字节输入流
		InputStream in = conn.getInputStream();
		// 读取流的数据
		/*
		byte[] buffer = new byte[1024]; // 勺子
		int count; // 定义勺子里面的水量
		while ((count = in.read(buffer)) > 0) {
			System.out.print(new String(buffer, 0, count, "utf-8"));
		}
		*/
		/**
		 *  InputStreamReader 字节流转字符流 ==> 资源流
		 */
		InputStreamReader isr = new InputStreamReader(in, "utf-8");
		char[] buffer = new char[1024];
		int count; // 定义勺子里面的水量
		while ((count = isr.read(buffer)) > 0) {
			System.out.print(new String(buffer, 0, count));
		}

		System.out.println();
		System.out.println("协议: " + url.getProtocol());
		System.out.println("域名: " + url.getHost());
		System.out.println("端口: " + url.getPort());
		System.out.println("路径: " + url.getPath());
		System.out.println("资源名: " + url.getFile());
		System.out.println("参数: " + url.getQuery());

		/**
		 * 问题: 问什么会出现 ?? ?
		 * 		Jsoup 实现网络资源爬取
		 */

	}

}
