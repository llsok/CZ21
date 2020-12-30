package com.yc.thread.d1230;

public class Demo2 {
	
	/**
	 * 线程属性,分类,方法
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new Thread("demo") {
			public void run() {
				System.out.println("==========子线程开始==========");
				try {
					// 子线程休眠3秒
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("==========子线程结束==========");
			}
		};
		
		// 线程属性
		t.getId(); // 标识 int 唯一
		t.getName(); // 名字 String
		t.getPriority(); // 优先级 int 1 ~ 10 默认 5, 数值越大优先级越高
		t.getThreadGroup(); // 线程组
		t.getState(); // 线程状态
		
		t.isAlive(); // 活的
		t.isDaemon(); // 精灵线程(守护线程)标志
		t.isInterrupted();// 是否中断 ==> 即将停止
		
		// 线程方法
		// 静态方法
		Thread.sleep(0); // 休眠 单位:毫秒
		Thread.yield(); // 屈服,让渡
		Thread.currentThread(); // 获取当前线程对象
		// 实例方法
		t.join();  // 加入
		//t.interrupt(); // 中断 替代   t.stop();  中断 != 立即停止
		//t.run();	// 线程启动后执行的代码
		//t.start();	// 启动线程
		
		//与线程有关的方法, 是Object的方法
		/*
		t.wait();	// 等待
		t.notify();	// 通知
		t.notifyAll();	// 通知全部
		Object o = new Object();
		o.wait();	// 等待
		o.notify();	// 通知
		o.notifyAll();	// 通知全部
		*/		
		/**
		 * 线程分类:
		 * 	1. 父线程
		 * 	2. 子线程
		 * 	3. 精灵线程(守护线程)
		 * 	4. 主线程
		 */
		
		Thread t1 = Thread.currentThread();
		System.out.println(t1.getId());
		System.out.println(t1.getName());
		
		// t 是 t1(main 主线程) 的子线程,  是在父线程的内部创建的线程
		// t1 是 t 的父线程
		System.out.println(t.getId());
		System.out.println(t.getName());
		
		/**
		 * 父线程与子线程的关系:
		 * 	默认情况下: 父线程会等待子线程执行完之后再结束, 尽管父线程的代码已经执行完成
		 * 	如果子线程设置为精灵线程(守护线程),那么父线程代码执行完毕,就会中断子线程的执行
		 */
		t.setDaemon(true);
		t.start();
		
		System.out.println("主线程的代码执行结束");
		
		
	}

}
