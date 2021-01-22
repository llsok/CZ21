package com.yc.mvc.po;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;


@Data
public class JsjOrder implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	 
	private Long id;
	private Long uid;
	private String addrName;
	
	@Pattern(regexp = "1\\d{10}", message = "电话号码必须是1开头的11位数字")
	private String addrPhone;
	
	@NotEmpty(message = "详细地址不能为空！")
	@Pattern(regexp = "[\\u4e00-\\u9fa5]+[0-9]*[a-zA-Z]*", message = "详细地址必须有中文")
	private String addrDesc;
	
	private Double money;
	private Timestamp createTime;
	private Integer state;
	private String remark;
	
	private List<JsjOrderDetail> details;
      
}


