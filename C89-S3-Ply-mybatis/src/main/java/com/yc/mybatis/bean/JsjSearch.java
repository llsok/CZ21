package com.yc.mybatis.bean;

public class JsjSearch {
    private Integer id;

    private String keyword;

    private Integer hots;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Integer getHots() {
        return hots;
    }

    public void setHots(Integer hots) {
        this.hots = hots;
    }
}