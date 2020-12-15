package com.yc.damai.po;

public class categorySecond implements java.io.Serializable{


	private static final long serialVersionUID = 1L;
	
	private Integer csid;
	private String csname;
	private Integer cid;
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "cateGorySecond [csid=" + csid + ", csname=" + csname + ", cid=" + cid + "]";
	}
}
