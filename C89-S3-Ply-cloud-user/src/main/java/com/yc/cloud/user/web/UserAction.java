package com.yc.cloud.user.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAction {
	
	@GetMapping("user/way")
	public String way(HttpServletRequest req) {
		return "user way :" + req.getServerPort();
	}

}
