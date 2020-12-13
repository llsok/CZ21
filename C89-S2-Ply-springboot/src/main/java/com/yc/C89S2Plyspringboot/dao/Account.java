package com.yc.C89S2Plyspringboot.dao;

import org.springframework.stereotype.Component;

/**
 * 银行账户
 * @author Administrator
 *
 */
public class Account {

	private Integer accountid; // 主键
	private Double balance; // 余额
	private String name; // 姓名
	private String pwd; // 密码
	
	public Account() { }
	
	public Account(Integer accountid, Double balance) {
		super();
		this.accountid = accountid;
		this.balance = balance;
	}
	
	public Account(Integer accountid, Double balance, String name, String pwd) {
		super();
		this.accountid = accountid;
		this.balance = balance;
		this.name = name;
		this.pwd = pwd;
	}
	public Integer getAccountid() {
		return accountid;
	}
	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", balance=" + balance + ", name=" + name + ", pwd=" + pwd + "]";
	}
	
}
