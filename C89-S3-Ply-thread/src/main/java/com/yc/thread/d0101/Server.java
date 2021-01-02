package com.yc.thread.d0101;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Arrays;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException, InterruptedException {
		// �����׽��ַ�����, ����ָ���˿�
		ServerSocket server = new ServerSocket(1234);
		Scanner sc = new Scanner(System.in);
		// �����������, IO����==>��ǰ�߳�����״̬
		// ���ͻ������Ϸ�����,��ô�׽����,����Socket����
		System.out.println("����������1234�˿�");
		Socket socket = server.accept();
		// ��ȡ��ǰ����������·��ַ
		InetAddress myAddr = socket.getInetAddress();
		// ������
		System.out.println(myAddr.getHostName());
		// IP��ַ
		System.out.println(Arrays.toString(myAddr.getAddress()));
		SocketAddress otherAddr = socket.getRemoteSocketAddress();
		System.out.println(otherAddr);

		Thread t1 = new Thread() {
			public void run() {
				boolean running = true;
				while (running) {
					// ����Ļ��ȡ��Ϣ
					System.out.println("������:");
					String msg = sc.nextLine();
					try {
						socket.getOutputStream().write(msg.getBytes());
						if(msg.startsWith("�ļ�:")) {
							String filepath = msg.substring("�ļ�:".length());
							transfar(socket.getOutputStream(), filepath);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};

		/**
		 * ������͵���Ϣ��"�ļ�:�ļ���",��ô���潫�ᷢ���ļ�����
		 * 	�ļ�:c:/a.txt
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
						if(msg.startsWith("�ļ�:")) {
							String filepath = msg.substring("�ļ�:".length());
							recv(socket.getInputStream(), filepath);
						} else {
							System.out.println("�ͻ��˷�����Ϣ:" + msg);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};

		t1.start();
		t2.start();

		// �õ�ǰ�̼߳��뵽 t1,t2 ֮��
		t1.join();
		t2.join();

		// Unreachable code ���벻�ɴ�
		socket.close();
		server.close();
		sc.close();
	}

	/**
	 * �����ļ�
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
			System.out.println("�ļ����ͳɹ�: " + filepath);
		}
	}
	
	/**
	 * �����ļ�
	 * @param in
	 * @param filepath
	 * @throws IOException 
	 */
	public static void recv(InputStream in, String filepath) throws IOException {
		// ��ȡ�ļ�·���е��ļ���
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
			System.out.println("�ļ����ճɹ�: " + "d:/recv/"+filename);
		}	
	}

}
