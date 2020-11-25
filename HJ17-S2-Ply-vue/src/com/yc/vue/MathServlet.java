package com.yc.vue;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/math.s")
public class MathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * doGet 方法实现加法运算
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收请求参数 a ， b
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		double da = a == null ? 0 : Double.parseDouble(a);
		double db = a == null ? 0 : Double.parseDouble(b);
		response.getWriter().write(da + db + "");
	}
	
	/**
	 * doPost 方法实现减法运算
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		double da = a == null ? 0 : Double.parseDouble(a);
		double db = a == null ? 0 : Double.parseDouble(b);
		response.getWriter().write(da - db + "");
	}
		

}
