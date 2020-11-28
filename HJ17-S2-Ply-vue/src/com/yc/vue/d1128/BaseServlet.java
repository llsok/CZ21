package com.yc.vue.d1128;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *	������ص�servlet 
 * 	
 * 	url: /msg.s
 * 	
 * 	����1�� ʹ��op����������ֲ�ͬ��������
 * 	���� �������ԣ�	/msg.s?op=add
 * 		��ѯ����:	/msg.s?op=query
 * 		�ظ�����	/msg.s?op=reply
 * 		....
 * 	����2�����岻ͬҵ�񷽷���Ӧ����ͬ������ �÷������� op ֵ��Ӧ
 * 		public void add(...) ==> op=add
 * 		public void query(...) ==> op=query
 * 		
 * 	BaseServlet ��һ����ͬ���࣬ ҵ�񷽷�д��������
 * 		java �ڿƼ� ���� ����
 * 	
 */
//@WebServlet("/BaseServlet") // ������BaseServlet�ĵ�ַ 
// BaseServlet ��ϣ������������new���� ֻ����̳�
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// final ��ֹ������д�÷���
	protected final void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �ڴ������ַ�������
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String op = request.getParameter("op");
		if (op == null) {
			throw new ServletException("�����ṩop�ֶΣ�");
		}
		// ͨ�������ȡ public ��������
		// getClass().getMethod(name, parameterTypes)
		try {
			// ͨ�������ȡ ����ģ���ǰ���ж���ģ� ��������
			Method m = getClass().getDeclaredMethod(op, HttpServletRequest.class, HttpServletResponse.class);
			// ����ǿ�Ʒ��� ����public��
			m.setAccessible(true);
			// ����method���� ִ�з���
			m.invoke(this, request, response);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new ServletException("��ȡ" + op + "����ʧ�ܣ�", e);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new ServletException("����" + op + "����ʧ�ܣ�", e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
