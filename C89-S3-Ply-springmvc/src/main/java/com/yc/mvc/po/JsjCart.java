package com.yc.mvc.po;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class JsjCart {
	
	private Integer id;
	
	private Integer bid;
	
	private Integer uid;
	
	private Integer count;
	
	private Timestamp createTime;

}
