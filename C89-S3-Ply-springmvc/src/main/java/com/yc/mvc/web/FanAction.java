package com.yc.mvc.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yc.mvc.dao.FanMapper;
import com.yc.mvc.po.JsjFans;
import com.yc.mvc.po.JsjUser;

@RestController
public class FanAction {
	
	@Resource
	private FanMapper fm ;
	
	@RequestMapping(path = "queryfans.do")
	public List<JsjUser> queryByname(@SessionAttribute JsjUser loginedUser) {
		return fm.queryFansById(loginedUser);
	}

}
