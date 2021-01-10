package com.yc.favorite;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.yc.favorite.bean.Favorite;
import com.yc.favorite.bean.Tag;
import com.yc.favorite.biz.FavoriteBiz;
import com.yc.favorite.dao.FavoriteMapper;
import com.yc.favorite.dao.TagMapper;

@SpringBootTest
public class BaseTest {
	
	@Resource
	private TagMapper tm;
	
	@Resource
	private FavoriteMapper fm;
	
	@Resource
	private FavoriteBiz fbiz;
	
	@Test
	public void test1() {
		Tag tag = new Tag();
		tag.setTname("娱乐");
		tag.setTcount(1L);
		tm.insert(tag);
	}
	
	@Test  // 测试驱动开发
	public void testAddFavorite() {
		
		Favorite f = new Favorite();
		f.setFlabel("淘宝");
		f.setFurl("www.taobao.com");
		f.setFdesc("知名购物网站");
		f.setFtags("购物，视频，娱乐");  // 假定数据库中已经有娱乐（tcount=1）的分类
		
		fbiz.addFavorite(f);
		
		// 结果==》 验证==》断言
		Tag gouwu = tm.selectByName("购物");
		Tag shipin = tm.selectByName("视频");
		Tag yule = tm.selectByName("娱乐");
		
		Assert.isTrue(gouwu.getTcount()==1, "购物的分类测试失败！");
		Assert.isTrue(shipin.getTcount()==1, "视频的分类测试失败！");
		Assert.isTrue(yule.getTcount()==2, "娱乐的分类测试失败！");
		
		Favorite f1 = fm.selectByLabel("淘宝");
		
		Assert.isTrue("www.taobao.com".equals(f1.getFurl()), "收藏链接测试失败！");
		
	}

}
