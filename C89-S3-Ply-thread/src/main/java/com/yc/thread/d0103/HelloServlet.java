package com.yc.thread.d0103;

import java.io.IOException;

public class HelloServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//response.getWriter().write("Hello world");
		
		String name = request.getParameter("name");
		
		Cookie c1 = new Cookie("user","zhangsan"); // 默认情况下cookie不能存非西方文字
		c1.setMaxAge(7 * 24 * 60 * 60);  // cookie有效时间单位:秒
		response.addCookie(c1);
		
		Cookie c2 = new Cookie("like","book"); // 默认情况下cookie不能存非西方文字
		response.addCookie(c2);
		
		response.getWriter().write("<script>alert('你好"+name+"!')</script>");
		
		// 请输出一段js脚本 , 弹出窗口显示 "你好中国"
	}

}
