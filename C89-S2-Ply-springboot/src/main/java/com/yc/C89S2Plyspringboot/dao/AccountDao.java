package com.yc.C89S2Plyspringboot.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao extends BaseDao<Account> {

	@Resource
	private JdbcTemplate jt;

	public void insert(Account e) {
		jt.update("insert into account values(null,?,?,?)", e.getBalance(), e.getName(), e.getPwd());
	}

	public void update(Account e) {
		String sql = "update account set balance = balance + ? where accountid=?";
		jt.update(sql, e.getBalance(), e.getAccountid());
	}
	
	public List<Account> selectAll() {
		String sql = "select * from account";
		return jt.query(sql,  (rs,index) -> { // lamda 表达式， 匿名类简写
			Account a = new Account();
			a.setAccountid(rs.getInt("accountid"));
			a.setName(rs.getString("name"));
			a.setBalance(rs.getDouble("balance"));
			a.setPwd(rs.getString("pwd"));
			return a;
		});
		
	}

	@SuppressWarnings("deprecation")
	public Account selectById(int id) {
		String sql = "select * from account where accountid=?";
		Object[] params = {id};
		return jt.query(sql, params, rs -> { // lamda 表达式， 匿名类简写
			rs.next();
			Account a = new Account();
			a.setAccountid(rs.getInt("accountid"));
			a.setName(rs.getString("name"));
			a.setBalance(rs.getDouble("balance"));
			a.setPwd(rs.getString("pwd"));
			return a;
		});
		
		/*
		 * 匿名类
		jt.query(sql, new ResultSetExtractor<Account>() {
			@Override
			public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
				return null;
			}
		});*/
	}
	
	/**
	 * 根据用户名查用户信息
	 */
	public Account selectByName(String name) {
		String sql = "select * from account where name=?";
		return jt.query(sql, rs -> { // lamda 表达式， 匿名类简写
			rs.next();
			Account a = new Account();
			a.setAccountid(rs.getInt("accountid"));
			a.setName(rs.getString("name"));
			a.setBalance(rs.getDouble("balance"));
			a.setPwd(rs.getString("pwd"));
			a.setEmail(rs.getString("email"));
			return a;
		}, name);
	}

	/**
	 * 根据用户名修改密码
	 * @param pwd
	 * @param name
	 */
	public void updatePwdByName(String pwd, String name) {
		String sql = "update account set pwd=? where name=?";
		jt.update(sql, pwd, name);
	}
	

}
