package com.yc.vue.dyg.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yc.vue.dyg.bean.DygCategory;
import com.yc.vue.dyg.dao.DygDao;

@WebServlet("/queryCyg.s")
public class QueryCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DygDao dao = new DygDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DygCategory> list = null;
		try {
			list = dao.selectAllCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// list ==> json  使用 gson
		// [ {...},{...},{...},{...} ... ]
		Gson gson = new Gson();
		String json = gson.toJson(list);
		// 解决乱码问题
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
