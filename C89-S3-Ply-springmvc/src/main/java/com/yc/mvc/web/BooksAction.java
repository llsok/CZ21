package com.yc.mvc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yc.mvc.dao.BooksMapper;
import com.yc.mvc.po.JsjBook;
import com.yc.mvc.web.po.Result;

@RestController
public class BooksAction {

	@Resource
	private BooksMapper bm;

	@RequestMapping("Hbooks.do")
	public Map<String, Object> queryBooksH(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "20") int size) {
		boolean count = true;
		if (page<2) {
			page = 1;
		}
		if(page>5) {
			page = 5;
		}
		Page<JsjBook> p = PageHelper.startPage(page, size, count);
		// Page 封装分页的页码相关的数值： 第几页，每页行数 。。。
		bm.SelectBookH();
		//bm.selectNew();
		Map<String, Object> ret = new HashMap<>();
		// 分页数据
		ret.put("list", p);
		// 总页数
		ret.put("pages", p.getPages());
		// 当前页
		ret.put("page", p.getPageNum());
		return ret;
	}

	@RequestMapping("Tbooks.do")
	public Map<String, Object> queryBooksT(@RequestParam(defaultValue = "1") int page2,
			@RequestParam(defaultValue = "20") int size) {
		boolean count = true;
		if (page2<2) {
			page2 = 1;
		}
		if(page2>5) {
			page2 = 5;
		}
		Page<JsjBook> p = PageHelper.startPage(page2, size, count);
		// Page 封装分页的页码相关的数值： 第几页，每页行数 。。。
		bm.SelectBookT();
		//bm.selectNew();
		Map<String, Object> ret = new HashMap<>();
		// 分页数据
		ret.put("list", p);
		// 总页数
		ret.put("pages", p.getPages());
		// 当前页
		ret.put("page", p.getPageNum());
		return ret;
	}

	@RequestMapping(path = "queryname")
	public Result queryBookByname(String name) {
		if (name.equals("")) {
			return Result.failure("请输入你想搜索的物品", null);
		} else {
			List<JsjBook> list = bm.queryBookByname(name);
			if (list.isEmpty()) {
				return Result.failure("没有搜索到您想要的商品", null);
			} else {
				return Result.success("搜索成功", null);
			}
		}
	}

	@RequestMapping(path = "search.s")
	public List<JsjBook> queryByname(String name) {
		return bm.queryBookByname(name);
	}

	@RequestMapping(path = "queryByCategory.do")
	public Map<String, Object> queryByCategory(int category, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size) {
		// 分页查询
		// count 参数： 表示是否查询总行数
		boolean count = true;
		if (page<2) {
			page = 1;
		}
		Page<JsjBook> p = PageHelper.startPage(page, size, count);
		// Page 封装分页的页码相关的数值： 第几页，每页行数 。。。
		bm.SelectByCategory(category);
		Map<String, Object> ret = new HashMap<>();
		// 分页数据
		ret.put("list", p);
		// 总页数
		ret.put("pages", p.getPages());
		// 当前页
		ret.put("page", p.getPageNum());
		return ret;

		// 1. Page 是 ArrayList的子类 也就是 List 的子类
		// 2. PageHelper 会讲查询的数据写入到 Page 中
	}
	
	@RequestMapping(path = "queryNew.do")
	public Map<String, Object> queryBew(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size) {
		// 分页查询
		// count 参数： 表示是否查询总行数
		boolean count = true;
		if (page<2) {
			page = 1;
		}
		Page<JsjBook> p = PageHelper.startPage(page, size, count);
		// Page 封装分页的页码相关的数值： 第几页，每页行数 。。。
		bm.selectNew();
		Map<String, Object> ret = new HashMap<>();
		// 分页数据
		ret.put("list", p);
		// 总页数
		ret.put("pages", p.getPages());
		// 当前页
		ret.put("page", p.getPageNum());
		return ret;

		// 1. Page 是 ArrayList的子类 也就是 List 的子类
		// 2. PageHelper 会讲查询的数据写入到 Page 中
	}

	@RequestMapping("quertBookDetail.do")
	public JsjBook quertBookDetail(int id) {
		System.out.println("id====" + id);
		return bm.quertBookDetail(id);
	}
	
	@GetMapping("mysell")
	public List<JsjBook> queryMySell(int ownerid){
		return bm.queryMySellById(ownerid);
	}

}
