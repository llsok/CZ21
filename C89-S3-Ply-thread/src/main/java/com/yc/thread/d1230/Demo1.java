package com.yc.thread.d1230;

public class Demo1 {
	
	
	public String toString() {
		return "";
	}
	
	
	/**
	 * ������ʹ���߳�
	 */
	
	public void doLogin() {
		System.out.println("=========doLogin begin==========");
		for (int i = 0; i < 100; i++) {
			System.out.println("=========doLogin "+ i +" ==========");
		}
		System.out.println("=========doLogin end==========");
	}
	
	public void doRegister() {
		System.out.println("=========doRegister begin==========");
		for (int i = 0; i < 100; i++) {
			System.out.println("=========doRegister "+ i +" ==========");
		}
		System.out.println("=========doRegister end==========");
	}
	
	public static void main(String[] args) {
		
		Demo1 d = new Demo1();
		
		// �̵߳Ĵ�����ʽ1: �̳� Thread ��: ������
		Thread t1 = new Thread() {
			public void run() {
				d.doLogin();
			}
		};
		t1.start(); // �����߳�
		
		// �����̷߳�ʽ2: ʵ��Runnable �ӿ� : ������ ==> �����
		Runnable r1 = new Runnable() {
			public void run() {
				d.doRegister();
			}
		};
		/**
		 * class UserDao extends BaseDao implements Runnable{
		 * }
		 */
		Thread t2 = new Thread(r1);
		
		t2.start();// �����߳�
		
		//d.doLogin();
		
		//d.doRegister();
		
	}

}
