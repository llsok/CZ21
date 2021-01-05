package com.yc.thread.d0103;

public class Cookie {
	
	/**
	 * 存储会话,缓存,记录历史
	 * 在浏览器端存储用户少量数据的技术
	 * name,value,maxAge,path...
	 * Cookie cookie = new Cookie(name, value);
	 * 存放在:内存(maxAge未提供)    硬盘(maxAge>0)   ==>
	 * maxAge == 0  ==> 立即删除该cookie 
	 * 
	 */
	
	private String name;
	private String value;
	private Integer maxAge;
	private String path = "/";
	
	public Cookie(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Integer getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public String toString() {
		String ret = "Set-Cookie: %s=%s; Path=%s";
		ret = String.format(ret, name, value, path);
		if(maxAge != null) {
			// int类型的字段 默认值是 0, 0 在maxAge值表示立即删除该cookie 
			ret += "; Max-Age=" + maxAge;
		}
		return ret;
	}

}
