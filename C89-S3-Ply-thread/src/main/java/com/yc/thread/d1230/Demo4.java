package com.yc.thread.d1230;

import java.util.ArrayList;

public class Demo4 {
	/**
	 * ����: ���߳�ִ�г���
	 * ��������������ģʽ
	 * ͬ��: ���߳�����ִ�� synchronized
	 * 		1. ͬ������    =>�����ǵ�ǰ����
	 * 		2. ͬ�������=>ָ�������Ķ���
	 * �ȴ�,֪ͨ
	 */
	ArrayList<Object> list = new ArrayList<>();

	// ������ǰ����
	public synchronized void produce()  throws InterruptedException {
		while (list.isEmpty()) {
			for (int i = 0; i < 10; i++) {
				list.add(i);
			}
			System.out.println("������Ʒ: " + list);
			notifyAll(); // ֪ͨ�����̼߳�������
			wait();   // ��������ȴ�״̬
		}
	}

	// �÷���������ִ�й�����,ֻ����һ���߳�ִ��
	public void consume() throws InterruptedException {
		// ͬ�������, ����Ҫд�ϱ������Ķ���
		synchronized(this) {
			while (list.isEmpty()) {
				notifyAll();  // ֪ͨ�����߳�, ���������߳�
				wait();		  // �ȴ�
			}
			System.out.println("���Ѳ�Ʒ: " + list.remove(0));
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
