package com.yc.thread.d1230;

public class Demo3 {
	/**
	 * join ������������
	 */
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread("ע���߳�") {
			public void run() {
				String name = Thread.currentThread().getName();
				System.out.printf("===== %s ��ʼ======\n", name);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("===== %s ����======\n", name);
			}
		};
		
		
		
		Thread t2 = new Thread("��¼�߳�"){
			public void run() {
				String name = Thread.currentThread().getName();
				System.out.printf("===== %s ��ʼ======\n", name);
				try {
					
					// ��ǰ�̼߳��뵽 t1 �߳���, ��t1�߳�ִ����֮��,��ִ��
					//t1.join(); // ==> ����  5��
					
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("===== %s ����======\n", name);
			}
		};
		
		t1.start();
		
		t2.start();
		
	}

}
