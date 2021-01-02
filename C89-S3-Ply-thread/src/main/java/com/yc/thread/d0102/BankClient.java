package com.yc.thread.d0102;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class BankClient {
	
	public void register(String name, double money) throws UnknownHostException, IOException {
		
		Socket client = new Socket("127.0.0.1",8888);
		DataInputStream dis = new DataInputStream(client.getInputStream()); // ����(�߼�,����)��
		DataOutputStream dos = new DataOutputStream(client.getOutputStream()); // ����(�߼�,����)��
		dos.writeUTF("register");
		dos.writeUTF(name);
		dos.writeDouble(money);
		System.out.println(dis.readUTF());
		client.close();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		BankClient client = new BankClient();
		client.register("test", 123);
		
		
	}

}
