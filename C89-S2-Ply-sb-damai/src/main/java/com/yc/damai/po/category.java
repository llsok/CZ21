package com.yc.damai.po;

public class category implements java.io.Serializable{


	private static final long serialVersionUID = 1L;
	private Integer cid;
	private String cname;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "cateGory [cid=" + cid + ", cname=" + cname + "]";
	}
	
}
