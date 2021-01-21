package com.yc.mvc.po;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class JsjOrder {

	private Long id;
	private Long uid;
	private String addr_name;
	private String addr_phone;
	private String addr_desc;
	private Double money;
	private Timestamp create_time;
	private Integer state;
	private String remark;
	
	
	private List<JsjOrderDetail> details;

}
