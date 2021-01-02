package com.yc.thread.d0102;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLDownload {

	public static void main(String[] args) throws MalformedURLException {
		String[] filepath = {
				"https://mirrors.tuna.tsinghua.edu.cn/apache/tomcat/tomcat-8/v8.5.61/bin/apache-tomcat-8.5.61.zip",
				"https://mirrors.tuna.tsinghua.edu.cn/apache"
						+ "/tomcat/tomcat-8/v8.5.61/bin/apache-tomcat-8.5.61.tar.gz",
				"https://mirrors.tuna.tsinghua.edu.cn/apache"
						+ "/tomcat/tomcat-8/v8.5.61/bin/apache-tomcat-8.5.61-windows-x64.zip" };
		for (final String s : filepath) {
			new Thread() {
				@Override
				public void run() {

					try {
						download(s);
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}.start();
		}
	}

	protected static void download(String s) throws IOException {
		URL url = new URL(s);
		// 获取连接
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		// 获取文件大小
		int filesize = conn.getContentLength();
		System.out.println("文件大小为：" + filesize / 1024 / 1024 + "MB");

		String filename = url.getFile().substring(url.getFile().lastIndexOf("/") + 1);

		FileOutputStream fos = new FileOutputStream("d:/recv/" + filename);
		try {
			System.out.println("文件开始下载！");
			byte[] buffer = new byte[1024];
			int count = 0;
			int le = 0;
			while ((count = in.read(buffer)) > 0) {
				le += count;
				fos.write(buffer, 0, count);
				System.out.println(filename + "当前进度为：" + le * 100 / filesize + "%");
			}
		} finally {
			fos.close();
			in.close();
			System.out.println("文件下载成功：" + "d:/recv/" + filename);
		}
	}
}
