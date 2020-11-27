package com.yc.vue.dyg.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.vue.dyg.bean.DygMsg;
import com.yc.vue.dyg.biz.BizException;
import com.yc.vue.dyg.biz.DygBiz;

@WebServlet("/addMsg.s")
public class AddMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DygBiz biz = new DygBiz();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// ����ʵ�����
		DygMsg msg = new DygMsg();
		msg.setCreateName(request.getParameter("createName"));
		msg.setEmail(request.getParameter("email"));
		msg.setContent(request.getParameter("content"));
		// ����ҵ�񷽷�
		try {
			biz.addMsg(msg);
			// ���ؽ�� ��ȷ
			response.getWriter().append("���Գɹ���");
		} catch (BizException e) {
			// ���ؽ�� ����
			e.printStackTrace();
			
			response.getWriter().append(e.getMessage());
		}
		// ���ؽ��
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
