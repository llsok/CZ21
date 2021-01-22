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

}
