package com.yc.thread.d0102;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class BankServer {

	private ServerSocket server;

	/**
	 * ��������
	 * @throws IOException 
	 */
	public void begin() throws IOException {
		server = new ServerSocket(8888);
		System.out.println("服务器启动:8888");
		
		boolean running = true;
		while (running) {
			Socket client = server.accept();
			System.out.println("接收到客户端请求:" + client.getRemoteSocketAddress());
			try {
				InputStream in = client.getInputStream();
				OutputStream out = client.getOutputStream();
				DataInputStream dis = new DataInputStream(in);
				DataOutputStream dos = new DataOutputStream(client.getOutputStream());
				String type = dis.readUTF();
				if ("register".equals(type)) {
					String name = dis.readUTF();
					double money = dis.readDouble();
					String id = register(name, money);
					dos.writeUTF("register: " + id);
				} else if ("dipoist".equals(type)) {
					dos.writeUTF("dipoist ++");
				} else if ("transfer".equals(type)) {
					dos.writeUTF("transfer ++");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		new BankServer().begin();
	}

	@Resource
	private JdbcTemplate jt;

	/**
	 * @param name
	 * @param money
	 * @return 
	 */
	public String register(String name, double money) {
		/**
		 *  	 1. 建表account 
		 *  	 2. 加入springboot的支持
		 */
		String id = "" + System.currentTimeMillis();
		jt.update("insert into account values(?,?,?)", id, name, money);
		return id;
	}

}
