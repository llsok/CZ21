package com.yc.cloud.order.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderAction {

	@GetMapping("order/way")
	public String way(HttpServletRequest req) {
		return "order way :" + req.getServerPort();
	}

	@Resource
	private RestTemplate rt;
	
	@GetMapping("user/way")
	public String userWay() {
		// 通过远程调用的方式，获取到 order 应用的 way 的结果
		String url = "http://127.0.0.1:8001/user/way";
		return rt.getForObject(url, String.class);
	}
}
