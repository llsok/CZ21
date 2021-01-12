package com.yc.favorite.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.favorite.bean.Favorite;
import com.yc.favorite.bean.Tag;
import com.yc.favorite.dao.FavoriteMapper;
import com.yc.favorite.dao.TagFavoriteMapper;
import com.yc.favorite.dao.TagMapper;

@Service	
@Transactional  // 事务注解
public class FavoriteBiz {
	
	@Resource
	private TagMapper tm;
	
	@Resource
	private FavoriteMapper fm;
	
	@Resource
	private TagFavoriteMapper tfm;
	
	/**
	 * 	添加链接, 请完成该业务方法
	 */
	public void addFavorite(Favorite f) {
		/**
		 * 	简化版本：省去了验证代码， 字段是否填写， 数据库是否已经有该记录
		 */
		
		/**
		 * 1. 添加链接到  favorite 表
		 * 2. 对 favorite的tags字段进行分割
		 * 3. 循环更新分类的数量，如果更新失败，则添加分类
		 * 4. 向 tagfavorite 添加记录（获取到tid和fid）
		 */
		fm.insert(f);
		String[] tags = null;
		if(f.getFtags()==null || f.getFtags().trim().isEmpty()) {
			tags = new String[0];
		} else {
			tags = f.getFtags().split("[,;：，;:]");
		}
		for(String tag : tags) {
			Tag t = new Tag();
			if( tm.updateCountByName(tag) == 0) {
				t.setTname(tag);
				t.setTcount(1L);
				tm.insert(t);
			} else {
				// 否则是tag已经存在，并且数量已经更新完成， 通过tag【tname】获取到t对象
				t = tm.selectByName(tag);
			}
			tfm.insert(t.getTid(), f.getFid());
		}
	}

}
