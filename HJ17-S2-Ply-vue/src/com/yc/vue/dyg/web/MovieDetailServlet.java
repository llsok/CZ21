package com.yc.vue.dyg.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yc.vue.dyg.bean.DygMovieWithBLOBs;
import com.yc.vue.dyg.dao.DygDao;

@WebServlet("/movie.s")
public class MovieDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DygDao dao = new DygDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 根据 id 查询一部电影信息
		String id = request.getParameter("id");
		DygMovieWithBLOBs dmwb = null;
		try {
			dmwb = dao.selectById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 转换成json字符串返回
		Gson gson = new Gson();
		String json = gson.toJson(dmwb);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
