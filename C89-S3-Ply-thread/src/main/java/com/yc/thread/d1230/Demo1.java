package com.yc.thread.d1230;

public class Demo1 {
	
	
	public String toString() {
		return "";
	}
	
	
	/**
	 * 创建和使用线程
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
		
		// 线程的创建方式1: 继承 Thread 类: 匿名类
		Thread t1 = new Thread() {
			public void run() {
				d.doLogin();
			}
		};
		t1.start(); // 启动线程
		
		// 创建线程方式2: 实现Runnable 接口 : 匿名类 ==> 更灵活
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
		
		t2.start();// 启动线程
		
		//d.doLogin();
		
		//d.doRegister();
		
	}

}
