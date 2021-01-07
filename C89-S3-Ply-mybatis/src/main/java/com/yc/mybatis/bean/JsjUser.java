package com.yc.mybatis.bean;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class JsjUser {
	
	/**
	 * 从用户角度看, 与书的关系是 1对多
	 */
	private List<JsjBook> books;
	
    public List<JsjBook> getBooks() {
		return books;
	}

	public void setBooks(List<JsjBook> books) {
		this.books = books;
	}
	
	/**
	 * 获取用户粉丝属性方法
	 */
	public List<JsjUser> getFans() {
		// TODO Auto-generated method stub
		return null;
	}


	private Integer id;

    private String account;

    private String name;

    private String pwd;

    private Integer inviteId;

    private String headImg;

    private String phone;

    private String email;

    private String school;

    private String gender;

    private String sign;

    private String collectType;

    private String collectAccount;

    private String collectName;

    private String addrName;

    private String addrPhone;

    private String addrPost;

    private String addrProvince;

    private String addrDesc;

    private Timestamp regTime;

    private Date lastLoginTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
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

    public Integer getInviteId() {
        return inviteId;
    }

    public void setInviteId(Integer inviteId) {
        this.inviteId = inviteId;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public String getCollectType() {
        return collectType;
    }

    public void setCollectType(String collectType) {
        this.collectType = collectType == null ? null : collectType.trim();
    }

    public String getCollectAccount() {
        return collectAccount;
    }

    public void setCollectAccount(String collectAccount) {
        this.collectAccount = collectAccount == null ? null : collectAccount.trim();
    }

    public String getCollectName() {
        return collectName;
    }

    public void setCollectName(String collectName) {
        this.collectName = collectName == null ? null : collectName.trim();
    }

    public String getAddrName() {
        return addrName;
    }

    public void setAddrName(String addrName) {
        this.addrName = addrName == null ? null : addrName.trim();
    }

    public String getAddrPhone() {
        return addrPhone;
    }

    public void setAddrPhone(String addrPhone) {
        this.addrPhone = addrPhone == null ? null : addrPhone.trim();
    }

    public String getAddrPost() {
        return addrPost;
    }

    public void setAddrPost(String addrPost) {
        this.addrPost = addrPost == null ? null : addrPost.trim();
    }

    public String getAddrProvince() {
        return addrProvince;
    }

    public void setAddrProvince(String addrProvince) {
        this.addrProvince = addrProvince == null ? null : addrProvince.trim();
    }

    public String getAddrDesc() {
        return addrDesc;
    }

    public void setAddrDesc(String addrDesc) {
        this.addrDesc = addrDesc == null ? null : addrDesc.trim();
    }

    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

}