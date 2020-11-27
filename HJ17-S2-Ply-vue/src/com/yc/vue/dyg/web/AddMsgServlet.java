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
		// 加载实体对象
		DygMsg msg = new DygMsg();
		msg.setCreateName(request.getParameter("createName"));
		msg.setEmail(request.getParameter("email"));
		msg.setContent(request.getParameter("content"));
		// 调用业务方法
		try {
			biz.addMsg(msg);
			// 返回结果 正确
			response.getWriter().append("留言成功！");
		} catch (BizException e) {
			// 返回结果 错误
			e.printStackTrace();
			
			response.getWriter().append(e.getMessage());
		}
		// 返回结果
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
