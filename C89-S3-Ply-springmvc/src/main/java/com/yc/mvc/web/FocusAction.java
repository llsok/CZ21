package com.yc.mvc.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.mvc.dao.FocusMapper;
import com.yc.mvc.po.JsjFocus;

@RestController
public class FocusAction {
	
	@Resource
	private FocusMapper fom;
	
	@GetMapping("focus")
	public List<JsjFocus> queryByState(int state){
		return fom.queryByState(state);
	}
}
