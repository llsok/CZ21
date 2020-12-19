package com.yc.damai.web;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.dao.CartDao;
import com.yc.damai.po.Result;
import com.yc.damai.po.User;

@RestController
public class CartAction {

	@Resource
	private CartDao cdao;

	@RequestMapping(path = "cart.s", params = "op=deleteCart")
	public void deleteCart() {

	}

	/**
	 * 添加购物车
	 * 
	 * @param pid     商品id
	 * @param count   商品数量
	 * @param session 会话对象
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(path = "cart.s", params = "op=addCart")
	public Result addCart(int pid, int count, HttpSession session) throws SQLException {
		// 获取当前的登录的用户
		User user = (User) session.getAttribute("loginedUser");
		// 添加购物车记录, 注意:这里没有判断,是否有添加过商品,请自行移植
		cdao.addCart(user.getUid(), pid, count);
		// 返回结果
		return Result.success("添加购物车成功!");
	}

	/**
	 * 查询购物车
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(path = "cart.s", params = "op=queryCart")
	public List<?> queryCart(HttpSession session) {
		User user = (User) session.getAttribute("loginedUser");
		return cdao.selectCart(user.getUid());
	}

	@RequestMapping(path = "cart.s", params = "op=upCart")
	public Result upCart(int pid, int count, HttpSession session) {
		User user = (User) session.getAttribute("loginedUser");
		System.out.println("pid" + pid);
		System.out.println("count" + count);
		cdao.upCart(user.getUid(), pid, count);

		return Result.success("操作成功！");

	}
}
