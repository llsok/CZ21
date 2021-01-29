package com.yc.cloud.zuul.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAction {
	
	@GetMapping("hello/test")
	public String hello() {
		return "hello";
	}

}
