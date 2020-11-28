package com.yc.vue.d1128.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.vue.d1128.BaseServlet;
import com.yc.vue.d1128.bean.User;
import com.yc.vue.d1128.biz.UserBiz;
import com.yc.vue.dyg.biz.BizException;

@WebServlet("/user.s")
public class UserServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	private UserBiz biz = new UserBiz();
	public void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		user.setHead(request.getParameter("head"));
		user.setName(request.getParameter("name"));
		user.setPwd(request.getParameter("pwd"));
		try {
			biz.register(user);
			response.getWriter().append("×¢²á³É¹¦£¡");
		} catch (BizException e) {
			e.printStackTrace();
			response.getWriter().append(e.getMessage());
		}
	}

}
