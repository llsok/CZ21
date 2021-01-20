package com.yc.damai.web;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.dao.CategoryDao;
import com.yc.damai.dao.CategorySecondDao;
import com.yc.damai.po.Category;

@RestController
public class CategoryAction {

	@Resource
	private CategoryDao cdao;
	
	@Resource
	private CategorySecondDao csdao;
	
	@RequestMapping("queryAll")
	public Map<String, Object> queryAll() throws SQLException {
		Map<String,Object> data = new HashMap<>();
		data.put("clist",cdao.queryCategory());
		data.put("cslist",csdao.queryCategorySecond());
		return data;
	}
	
	@RequestMapping(path="category.s",params = "op=queryCategory")
	public List<Category> queryCategory(){
		return cdao.queryCategory();
		
	}
}
