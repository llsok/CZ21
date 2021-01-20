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
	
	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static Result success(String msg, Object data) {
		return new Result(1, msg, data);
	}

	public static Result failure(String msg, Object data) {
		return new Result(0, msg, data);
	}
	
	public static Result success(int code,String msg, Object data) {
		return new Result(1, msg, data);
	}

	public static Result failure(int code,String msg, Object data) {
		return new Result(0, msg, data);
	}

	public Result(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
	
}
