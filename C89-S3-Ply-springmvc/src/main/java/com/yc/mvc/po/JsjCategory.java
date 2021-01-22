package com.yc.mvc.po;

import javax.validation.constraints.NotEmpty;

public class JsjCategory {
    private Integer id;

    @NotEmpty(message = "名称不能为空")
    private String name;

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
}