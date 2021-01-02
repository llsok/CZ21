package com.yc.thread.d1230;

import java.util.ArrayList;

public class Demo4 {
	/**
	 * 并发: 多线程执行场景
	 * 生产者与消费者模式
	 * 同步: 让线程依次执行 synchronized
	 * 		1. 同步方法    =>锁定是当前对象
	 * 		2. 同步代码块=>指定锁定的对象
	 * 等待,通知
	 */
	ArrayList<Object> list = new ArrayList<>();

	// 锁定当前对象
	public synchronized void produce()  throws InterruptedException {
		while (list.isEmpty()) {
			for (int i = 0; i < 10; i++) {
				list.add(i);
			}
			System.out.println("生产产品: " + list);
			notifyAll(); // 通知其他线程继续运行
			wait();   // 主动进入等待状态
		}
	}

	// 该方法将会在执行过程中,只允许一个线程执行
	public void consume() throws InterruptedException {
		// 同步代码块, 后面要写上被锁定的对象
		synchronized(this) {
			while (list.isEmpty()) {
				notifyAll();  // 通知其他线程, 包括生产线程
				wait();		  // 等待
			}
			System.out.println("消费产品: " + list.remove(0));
		}
	}

	public static void main(String[] args) {

		Demo4 d = new Demo4();
		
		new Thread() {
			public void run() {
				try {
					d.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();

		for (int i = 0; i < 100; i++) {
			new Thread() {
				public void run() {
					try {
						d.consume();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}.start();
		}

	}

}
