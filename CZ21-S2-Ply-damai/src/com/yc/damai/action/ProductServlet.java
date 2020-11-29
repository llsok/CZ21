package com.yc.damai.action;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.damai.dao.ProductDao;

@WebServlet("/product.s")
public class ProductServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	private ProductDao pdao = new ProductDao();

	public void queryHot(HttpServletRequest request, HttpServletResponse response) throws IOException {
		append(response, pdao.queryHot());
	}

}
