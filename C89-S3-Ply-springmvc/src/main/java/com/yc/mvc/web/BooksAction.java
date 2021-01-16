package com.yc.mvc.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.mvc.dao.BooksMapper;
import com.yc.mvc.po.JsjBook;
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
  
}
