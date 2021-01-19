package com.yc.mvc.biz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.mvc.dao.CartMapper;
import com.yc.mvc.po.JsjCart;

@Service
@Transactional
public class CartBiz {
	
	private CartMapper cm;
	
	public void addCart(JsjCart cart) {
		// 添加购物车，如果已经有该书籍，那么加数量
		if( cm.updateCount(cart) == 0) {
			cm.insert(cart);
		}
	}

}
