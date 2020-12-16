package com.yc.damai.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CartDao extends BaseDao{
	public List<?> queryCart(Integer uid) throws SQLException {
		String sql = "select product.*,cart.* from cart,product "
				+ "where cart.pid=product.pid and cart.uid=?";
		List<?> list = null;
		//list = jt.query(sql, uid);
		System.out.println("list==" + list);
		return list;
	}

	public void addCart(String pid,String count,Integer uid) throws SQLException {
		/*String sql = "select * from cart where uid=? and pid=?";
		if (DBHelper.selectOne(sql, uid,pid) != null) {
			sql = "update cart set count=count+? where uid=? and pid=?";
			DBHelper.update(sql, count, uid, pid);
		} else {
			sql = "insert into cart values(null,?,?,?)";
			DBHelper.update(sql, uid, pid, count);
		}*/
		
		String sql = "update cart set count=count+? where uid=? and pid=?";
		if(jt.update(sql,count, uid,pid) == 0) {
			sql = "insert into cart values(null,?,?,?)";
			jt.update(sql, uid, pid, count);
		}
	}
	
	public void deleteCart(String pid) {
		String sql = "delete from cart where pid=?";
		
		jt.update(sql, pid);
		
	}

	public void clearCart(Integer iUid) throws SQLException {
		String sql = "delete from cart where uid = ?";
		jt.update(sql, iUid);
	}
}
