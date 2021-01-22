package com.yc.mvc.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.mvc.dao.LinkMapper;
import com.yc.mvc.po.JsjLink;

@RestController
public class LinkAction {
	
	@Resource private LinkMapper lm;
	
	@RequestMapping("link.do")
	public List<JsjLink> selectAll(){
		return lm.selectAll();
	}
}
