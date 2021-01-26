package com.yc.cloud.order.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yc.cloud.order.bean.Numbers;

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
		String url = "http://cloud-user/user/way";
		return rt.getForObject(url, String.class);
	}
	
	@PostMapping("add")
	public String add(@RequestBody Numbers numbers) {
		return "result: " + (numbers.getA() + numbers.getB());
	}
	
	@PostMapping("show")
	public String show(@RequestBody Integer a) {
		return "number is: " + a;
	}
	
	
}
