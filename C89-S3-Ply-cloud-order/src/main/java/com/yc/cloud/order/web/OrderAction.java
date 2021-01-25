package com.yc.cloud.order.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderAction {

	@GetMapping("order/way")
	public String way(HttpServletRequest req) {
		return "order way :" + req.getServerPort();
	}

}
