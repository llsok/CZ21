package com.yc.thread.d1230;

public class Demo3 {
	/**
	 * join 方法导致阻塞
	 */
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread("注册线程") {
			public void run() {
				String name = Thread.currentThread().getName();
				System.out.printf("===== %s 开始======\n", name);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("===== %s 结束======\n", name);
			}
		};
		
		
		
		Thread t2 = new Thread("登录线程"){
			public void run() {
				String name = Thread.currentThread().getName();
				System.out.printf("===== %s 开始======\n", name);
				try {
					
					// 当前线程加入到 t1 线程中, 在t1线程执行完之后,再执行
					//t1.join(); // ==> 阻塞  5秒
					
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("===== %s 结束======\n", name);
			}
		};
		
		t1.start();
		
		t2.start();
		
	}

}
