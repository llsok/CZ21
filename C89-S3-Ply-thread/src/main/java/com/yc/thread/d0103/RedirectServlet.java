package com.yc.thread.d0103;

import java.io.IOException;

public class RedirectServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 响应重定向 ==> 跳转到另一个页面, 浏览器的地址栏将会显示 新的页面地址
		response.sendRedirect("/index.html");
		
	}

}
