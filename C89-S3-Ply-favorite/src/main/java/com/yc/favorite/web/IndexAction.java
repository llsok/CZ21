package com.yc.favorite.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexAction {

	@RequestMapping("hello")
	public String hello() {
		return "hello world";
	}
	
}
