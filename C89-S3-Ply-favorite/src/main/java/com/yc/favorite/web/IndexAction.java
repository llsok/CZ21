package com.yc.favorite.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.favorite.bean.Favorite;
import com.yc.favorite.bean.Tag;
import com.yc.favorite.biz.FavoriteBiz;
import com.yc.favorite.dao.FavoriteMapper;
import com.yc.favorite.dao.TagMapper;

@RestController
public class IndexAction {
	
	@Resource private TagMapper tm;
	
	@Resource private FavoriteMapper fm;
	
	@Resource private FavoriteBiz fbiz;

	@RequestMapping("hello")
	public String hello() {
		return "hello world";
	}
	
	@RequestMapping("add.do")
	public String add(Favorite f) {
		try {
			fbiz.addFavorite(f);
		}catch(Exception e) {
			e.printStackTrace();
			return "添加链接失败！";
		}
		return "添加链接成功！";
	}
	
	@RequestMapping("queryAllTag.do")
	public List<Tag> queryAllTag(){
		return tm.selectAll();
	}
	
	@RequestMapping("queryAllFavorite.do")
	public List<Favorite> queryAllFavorite(){
		return fm.selectAll();
	}
	
	@RequestMapping("queryFavoriteByTid.do")
	public Tag queryFavoriteByTid(int tid){
		return tm.selectByTid(tid);
	}
	
}
