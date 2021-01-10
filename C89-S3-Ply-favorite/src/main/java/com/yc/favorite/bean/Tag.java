package com.yc.favorite.bean;

import lombok.Data;

@Data  // 自动的生成 get set toString 方法
public class Tag implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer tid;
	private String tname;
	private Long tcount;
	
}
