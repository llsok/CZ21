package com.yc.mvc.po;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class JsjAdmin {

	private Integer id;
	
	@NotNull(message = "账号不能为空！")
	@NotEmpty(message = "账号不能为空！")
	private String account;
	
	@Length(min = 6, max = 16, message = "密码长度必须是6-16位")
	@NotEmpty(message = "密码不能为空！")
	// 密码必须是以字母开头的数字+字母字符串
	@Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]{5,15}", message = "密码必须是以字母开头的数字+字母字符串")
	private String pwd;
	
	@Pattern(regexp = "1\\d{10}", message = "电话号码必须是1开头的11位数字")
	private String phone;
	
	@Email(message = "邮箱地址格式错误")
	@NotEmpty(message = "邮箱不能为空")
	private String email;
	
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "JsjAdmin [id=" + id + ", account=" + account + ", pwd=" + pwd + ", phone=" + phone + ", email=" + email
				+ ", status=" + status + "]";
	}

	
}
