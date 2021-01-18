package com.yc.mvc.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.yc.mvc.dao.BooksMapper;
import com.yc.mvc.po.JsjBook;
import com.yc.mvc.web.po.Result;

@RestController
public class BooksAction {
	
  @Resource
  private BooksMapper bm;
  
  @RequestMapping("Hbooks.do")
  public List<JsjBook> queryBooksH(){
	  return bm.SelectBookH();
  }
  
  @RequestMapping("Tbooks.do")
  public List<JsjBook> queryBooksT(){
	  return bm.SelectBookT();
  }
  
  @RequestMapping(path="queryname")
  public Result queryBookByname(String name){
 	  if(name.equals("")) {
 		 return Result.failure("请输入你想搜索的物品",null);
 	  }else {
 		  List<JsjBook> list = bm.queryBookByname(name);
 		  if(list.isEmpty()) {
 			 return Result.failure("没有搜索到您想要的商品",null);
 		  }else {
 			  return Result.success("搜索成功",null);
 		  }
 	  }
  }
  
  @RequestMapping(path="search.s")
  public List<JsjBook> queryByname(String name){
	   return bm.queryBookByname(name);
  }
  
  @RequestMapping(path="queryByCategory.do")
  public List<JsjBook> queryByCategory(int category, 
		  @RequestParam(defaultValue = "1") int page,
		  @RequestParam(defaultValue = "10")int size){
	  // 分页查询
	  // count 参数： 表示是否查询总行数
	  PageHelper.startPage(page, size, true);
	  return bm.SelectByCategory(category);
 }
  
}
