package com.yc.mvc.po;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class JsjOrderDetail {

	private Long id;
	private Long oid;
	private Integer count;
	private double price;
	private Integer bid;


}
