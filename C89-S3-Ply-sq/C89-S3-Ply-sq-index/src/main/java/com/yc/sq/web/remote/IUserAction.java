package com.yc.sq.web.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.sq.bean.Result;
import com.yc.sq.bean.SqMember;

@FeignClient("sq-user")
public interface IUserAction {

	@PostMapping("login")
	Result login(SqMember sm);
	
	@PostMapping("regist")
	Result regist(SqMember sm);
	
}
