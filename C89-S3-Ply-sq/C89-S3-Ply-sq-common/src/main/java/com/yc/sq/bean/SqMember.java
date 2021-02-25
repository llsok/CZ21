package com.yc.sq.bean;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class SqMember implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Integer id;

    @NotNull(message = "账号不能为空！")
	@NotEmpty(message = "账号不能为空！")
    private String name;
    
    @Length(min = 6, max = 16, message = "密码长度必须是6-16位")
	@NotEmpty(message = "密码不能为空！")
    private String pwd;
    
    @NotEmpty(message = "电话号码不能为空！")
    @Pattern(regexp = "1\\d{10}", message = "电话号码必须是1开头的11位数字")
    private String phone;

    private String email;

    private String qq;

    private String head;

    private String rank;

    private Integer glod;

    private Date createTime;

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
    }

    public Integer getGlod() {
        return glod;
    }

    public void setGlod(Integer glod) {
        this.glod = glod;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}