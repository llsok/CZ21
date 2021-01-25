package com.yc.cloud.user.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserAction {
	
	@GetMapping("user/way")
	public String way(HttpServletRequest req) {
		return "user way :" + req.getServerPort();
	}
	
	@Resource
	private RestTemplate rt;
	
	@GetMapping("order/way")
	public String orderWay() {
		// 通过远程调用的方式，获取到 order 应用的 way 的结果
		String url = "http://cloud-user/order/way";
		return rt.getForObject(url, String.class);
	}

}
