package com.yc.mvc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yc.mvc.biz.CategoryBiz;
import com.yc.mvc.dao.CategoryMapper;
import com.yc.mvc.po.JsjBook;
import com.yc.mvc.po.JsjCategory;
import com.yc.mvc.web.po.Result;

@RestController
public class CategoryAction {

	@Resource
	private CategoryMapper cm;
	
	@Resource
	private CategoryBiz cb;
	
	@RequestMapping("selectByCateId.do")
	public JsjCategory selectById(int category ){
		return cm.selectById(category);
	}
	
	@RequestMapping("selectAllCate.do")
	public List<JsjCategory> selectAllCate(){
		return cm.selectAll();
	}
	
	
	@RequestMapping("queryAllCate")
	public Map<String, Object> queryAllCate(@RequestParam(defaultValue = "1") int pageIndex,
			@RequestParam(defaultValue = "7") int size){
		boolean count = true;
		Page<JsjBook> p = PageHelper.startPage(pageIndex, size, count);
		cm.selectAll();
		Map<String, Object> ret = new HashMap<>();

		ret.put("list", p);

		ret.put("pages", p.getPages());

		ret.put("page", p.getPageNum());
		return ret;
	}
	
	
	@RequestMapping("update")
	public Result update(int id,String name) {
		JsjCategory category = new JsjCategory();
		category.setId(id);
		category.setName(name);
		try {
			cm.update(category);
			return Result.success("修改成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure("修改失败,请联系技术人员", null);
		}		
	}
	
	
	@RequestMapping("addCate")
	public Result addCate(@Valid JsjCategory category,Errors errors) {
		if (errors.hasErrors()) {
			return Result.failure("字段验证错误", errors.getAllErrors());
		}
		try {
			cb.insert(category);
			return Result.success("添加成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			errors.rejectValue("name", "NotOne", e.getMessage());
			return Result.failure("添加失败,请联系技术人员", errors.getAllErrors());
		}		
	}
	
	
	@RequestMapping("del")
	public Result del(int id) {
		try {
			cm.delete(id);
			return Result.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure("删除失败,请联系技术人员", null);
		}
	}
}
