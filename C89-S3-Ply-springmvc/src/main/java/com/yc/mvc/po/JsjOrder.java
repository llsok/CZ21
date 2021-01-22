package com.yc.mvc.po;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class JsjOrder implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long uid;
	private String addrName;
	private String addrPhone;
	private Double	money;
	private Timestamp createTime;
	private Integer	state;
	private String remark;
	
	private List<JsjOrderDetail> detail;
}
