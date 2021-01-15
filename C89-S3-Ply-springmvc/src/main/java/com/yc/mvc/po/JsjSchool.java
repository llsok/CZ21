package com.yc.mvc.po;

public class JsjSchool implements java.io.Serializable{
	
	private static final long serialVersionUID = 2028909196711864219L;

	private Integer id;

    private String name;

    private String province;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }
}