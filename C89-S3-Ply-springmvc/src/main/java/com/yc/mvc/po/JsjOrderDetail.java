
package com.yc.mvc.po;

import lombok.Data;

@Data
public class JsjOrderDetail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long oid;
	private Long bid;
	private Integer count;
	private Double price;
	
	private JsjBook book;
 
}

