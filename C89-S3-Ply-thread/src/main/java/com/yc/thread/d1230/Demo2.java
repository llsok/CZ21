package com.yc.thread.d1230;

public class Demo2 {
	
	/**
	 * �߳�����,����,����
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new Thread("demo") {
			public void run() {
				System.out.println("==========���߳̿�ʼ==========");
				try {
					// ���߳�����3��
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("==========���߳̽���==========");
			}
		};
		
		// �߳�����
		t.getId(); // ��ʶ int Ψһ
		t.getName(); // ���� String
		t.getPriority(); // ���ȼ� int 1 ~ 10 Ĭ�� 5, ��ֵԽ�����ȼ�Խ��
		t.getThreadGroup(); // �߳���
		t.getState(); // �߳�״̬
		
		t.isAlive(); // ���
		t.isDaemon(); // �����߳�(�ػ��߳�)��־
		t.isInterrupted();// �Ƿ��ж� ==> ����ֹͣ
		
		// �̷߳���
		// ��̬����
		Thread.sleep(0); // ���� ��λ:����
		Thread.yield(); // ����,�ö�
		Thread.currentThread(); // ��ȡ��ǰ�̶߳���
		// ʵ������
		t.join();  // ����
		//t.interrupt(); // �ж� ���   t.stop();  �ж� != ����ֹͣ
		//t.run();	// �߳�������ִ�еĴ���
		//t.start();	// �����߳�
		
		//���߳��йصķ���, ��Object�ķ���
		/*
		t.wait();	// �ȴ�
		t.notify();	// ֪ͨ
		t.notifyAll();	// ֪ͨȫ��
		Object o = new Object();
		o.wait();	// �ȴ�
		o.notify();	// ֪ͨ
		o.notifyAll();	// ֪ͨȫ��
		*/		
		/**
		 * �̷߳���:
		 * 	1. ���߳�
		 * 	2. ���߳�
		 * 	3. �����߳�(�ػ��߳�)
		 * 	4. ���߳�
		 */
		
		Thread t1 = Thread.currentThread();
		System.out.println(t1.getId());
		System.out.println(t1.getName());
		
		// t �� t1(main ���߳�) �����߳�,  ���ڸ��̵߳��ڲ��������߳�
		// t1 �� t �ĸ��߳�
		System.out.println(t.getId());
		System.out.println(t.getName());
		
		/**
		 * ���߳������̵߳Ĺ�ϵ:
		 * 	Ĭ�������: ���̻߳�ȴ����߳�ִ����֮���ٽ���, ���ܸ��̵߳Ĵ����Ѿ�ִ�����
		 * 	������߳�����Ϊ�����߳�(�ػ��߳�),��ô���̴߳���ִ�����,�ͻ��ж����̵߳�ִ��
		 */
		t.setDaemon(true);
		t.start();
		
		System.out.println("���̵߳Ĵ���ִ�н���");
		
		
	}

}
