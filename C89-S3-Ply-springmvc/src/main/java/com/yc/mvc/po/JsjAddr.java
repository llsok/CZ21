package com.yc.mvc.po;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class JsjAddr implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer uid;
	
	@NotNull(message = "收货人不能为空！")
	@NotEmpty(message = "收货人不能为空！")
	private String addrName;
	
	@Pattern(regexp = "1\\d{10}", message = "电话号码必须是1开头的11位数字")
	private String addrPhone;
	
	@Pattern(regexp = "^[1-9]\\d{5}$", message = "邮政编码格式错误")
	private String addrPost;
	
	@NotNull(message = "地址不能为空！")
	@NotEmpty(message = "地址不能为空！")
	private String addrProvince;
	
	@NotNull(message = "地址不能为空！")
	@NotEmpty(message = "地址不能为空！")
	private String addrDesc;
	
	private Integer code;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getAddrName() {
		return addrName;
	}

	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}

	public String getAddrPhone() {
		return addrPhone;
	}

	public void setAddrPhone(String addrPhone) {
		this.addrPhone = addrPhone;
	}

	public String getAddrPost() {
		return addrPost;
	}

	public void setAddrPost(String addrPost) {
		this.addrPost = addrPost;
	}

	public String getAddrProvince() {
		return addrProvince;
	}

	public void setAddrProvince(String addrProvince) {
		this.addrProvince = addrProvince;
	}

	public String getAddrDesc() {
		return addrDesc;
	}

	public void setAddrDesc(String addrDesc) {
		this.addrDesc = addrDesc;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "JsjAddr [id=" + id + ", uid=" + uid + ", addrName=" + addrName + ", addrPhone=" + addrPhone
				+ ", addrPost=" + addrPost + ", addrProvince=" + addrProvince + ", addrDesc=" + addrDesc + ", code="
				+ code + "]";
	}

	
}
