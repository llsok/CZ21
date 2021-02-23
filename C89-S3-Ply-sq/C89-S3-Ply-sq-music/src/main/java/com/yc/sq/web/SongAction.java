package com.yc.sq.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.yc.sq.bean.SqSongExample;
import com.yc.sq.dao.SqSongMapper;

@RestController
public class SongAction {
	
	@Resource
	private SqSongMapper ssm;
	
	// 查询最新歌曲
	@GetMapping("queryHot")
	public List<?> queryHot(){
		// 创建查询条件
		SqSongExample sse = new SqSongExample();
		// 设置配租
		sse.setOrderByClause("heat desc");
		// 设置分页
		PageHelper.startPage(1, 12);
		return ssm.selectByExample(sse);
	}

}
