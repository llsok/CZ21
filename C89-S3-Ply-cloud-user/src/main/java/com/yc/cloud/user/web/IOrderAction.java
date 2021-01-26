package com.yc.cloud.user.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.cloud.user.bean.Numbers;

// 定义远程调用的服务名
@FeignClient("cloud-order")
public interface IOrderAction {
	
	// 使用SpringMVC的控制器地址映射注解，定义该方法要调用的远程接口方法
	@RequestMapping("order/way")
	String orderWay();
	
	@PostMapping("add")
	String add(Numbers numbers);
	
	
	// Feign 使用 Post 请求
	// @RequestBody 表示该参数写入到请求体中
	@PostMapping("show")
	String show(Integer a);

}
