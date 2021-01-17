package com.yc.mvc.web.po;

import lombok.Data;

@Data
public class Result implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int code;
	private String msg;
	private Object data;

	public static Result success(String msg, Object data) {
		return new Result(1, msg, data);
	}

	public static Result failure(String msg, Object data) {
		return new Result(0, msg, data);
	}

	public Result(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
}
