package com.yc.vue.d1128.bean;

import java.sql.Timestamp;

public class User implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String phone;
	private String email;
	private String name;
	private String head;
	private String pwd;
	private Timestamp regTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Timestamp getRegTime() {
		return regTime;
	}
	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", phone=" + phone + ", email=" + email + ", name=" + name + ", head=" + head
				+ ", pwd=" + pwd + "]";
	}

}
