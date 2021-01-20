package com.yc.damai.po;

public class Cart implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private Integer ciid;
	private Integer uid;
	private Integer pid;
	private Integer count;
	public Integer getCiid() {
		return ciid;
	}
	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "Cart [ciid=" + ciid + ", uid=" + uid + ", pid=" + pid + ", count=" + count + "]";
	}
	
}
