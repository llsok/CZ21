package com.yc.damai.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.MailcapCommandMap;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.dao.CategoryDao;
import com.yc.damai.dao.CategorysecondDao;
import com.yc.damai.po.category;

@RestController
public class CategoryAction {
	
	@Resource
	private CategoryDao cdao;
	@Resource
	private CategorysecondDao csdao;
	
	@RequestMapping("queryList")
	public List<category> query(){
		return cdao.selectAll();
	}
	
	@RequestMapping("selectDouble")
	public Map<String, Object> selectDouble(){
		Map<String, Object> map=new HashMap<>();
		map.put("clist",cdao.selectAll());
		map.put("cslist", csdao.selectAll());
		return map;
	}
}
