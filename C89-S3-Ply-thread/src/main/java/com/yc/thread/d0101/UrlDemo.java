package com.yc.thread.d0101;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlDemo {

	public static void main(String[] args) throws IOException {

		URL url = new URL("http://www.hyycinfo.com/index.html");
		// ��������
		URLConnection conn = url.openConnection();
		// ��ȡ�ֽ�������
		InputStream in = conn.getInputStream();
		// ��ȡ��������
		/*
		byte[] buffer = new byte[1024]; // ����
		int count; // �������������ˮ��
		while ((count = in.read(buffer)) > 0) {
			System.out.print(new String(buffer, 0, count, "utf-8"));
		}
		*/
		/**
		 *  InputStreamReader �ֽ���ת�ַ��� ==> ��Դ��
		 */
		InputStreamReader isr = new InputStreamReader(in, "utf-8");
		char[] buffer = new char[1024];
		int count; // �������������ˮ��
		while ((count = isr.read(buffer)) > 0) {
			System.out.print(new String(buffer, 0, count));
		}

		System.out.println();
		System.out.println("Э��: " + url.getProtocol());
		System.out.println("����: " + url.getHost());
		System.out.println("�˿�: " + url.getPort());
		System.out.println("·��: " + url.getPath());
		System.out.println("��Դ��: " + url.getFile());
		System.out.println("����: " + url.getQuery());

		/**
		 * ����: ��ʲô����� ?? ?
		 * 		Jsoup ʵ��������Դ��ȡ
		 */

	}

}
