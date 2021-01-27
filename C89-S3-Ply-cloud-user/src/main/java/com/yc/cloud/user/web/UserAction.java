package com.yc.cloud.user.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yc.cloud.user.bean.Numbers;

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
		// String url = "http://127.0.0.1:8002/order/way";
		String url = "http://cloud-order/order/way";
		return rt.getForObject(url, String.class);
	}
	
	// 注入远程调用接口对象
	@Resource
	private IOrderAction ioa;
	@GetMapping("order/wayByFeign")
	public String orderWay1() {
		return ioa.orderWay();
	}
	
	@GetMapping("order/add")
	public String add(Numbers numbers) {
		return ioa.add(numbers);
	}
	
	
	@GetMapping("order/show")
	public String show(Integer a) {
		System.out.println("a === " + a);
		return ioa.show(a);
	}
	
}
