package com.yc.thread.d0101;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		// 创建套接字, 输入服务器的IP地址和端口
		Socket socket = new Socket("127.0.0.1", 1234);
		Scanner sc = new Scanner(System.in);
		
		Thread t1 = new Thread() {
			public void run() {
				boolean running = true;
				while (running) {
					// 从屏幕读取信息
					System.out.println("请输入:");
					String msg = sc.nextLine();
					try {
						socket.getOutputStream().write(msg.getBytes());
						if(msg.startsWith("文件:")) {
							String filepath = msg.substring("文件:".length());
							transfar(socket.getOutputStream(), filepath);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};

		/**
		 * 如果返送的消息是"文件:文件名",那么后面将会发出文件内容
		 * 	文件:c:/a.txt
		 */
		Thread t2 = new Thread() {
			public void run() {
				boolean running = true;
				while (running) {
					byte[] buffer = new byte[1024];
					int count = 0;
					try {
						count = socket.getInputStream().read(buffer);
						String msg = new String(buffer, 0, count);
						if(msg.startsWith("文件:")) {
							String filepath = msg.substring("文件:".length());
							recv(socket.getInputStream(), filepath);
						} else {
							System.out.println("客户端发来消息:" + msg);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};

		t1.start();
		t2.start();

		// 让当前线程加入到 t1,t2 之后
		t1.join();
		t2.join();

		// Unreachable code 代码不可达
		socket.close();
		sc.close();
	}

	/**
	 * 发送文件
	 * @param out
	 * @param filepath
	 * @throws IOException 
	 */
	public static void transfar(OutputStream out, String filepath) throws IOException {
		FileInputStream fis = new FileInputStream(filepath);
		try {
			byte[] buffer = new byte[1024];
			int count;
			while ((count = fis.read(buffer)) > 0) {
				out.write(buffer, 0, count);
			}
		} finally {
			fis.close();
			System.out.println("文件发送成功: " + filepath);
		}
	}
	
	/**
	 * 接收文件
	 * @param in
	 * @param filepath
	 * @throws IOException 
	 */
	public static void recv(InputStream in, String filepath) throws IOException {
		// 获取文件路径中的文件名
		String filename = filepath.substring(filepath.lastIndexOf("/")+1);
		FileOutputStream fos = new FileOutputStream("d:/recv/"+filename);
		try {
			byte[] buffer = new byte[1024];
			int count;
			while ((count = in.read(buffer)) > 0) {
				fos.write(buffer, 0, count);
			}
		} finally {
			fos.close();
			System.out.println("文件接收成功: " + "d:/recv/"+filename);
		}	
	}
}