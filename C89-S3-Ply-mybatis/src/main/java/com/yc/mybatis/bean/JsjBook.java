package com.yc.mybatis.bean;

import java.sql.Timestamp;

public class JsjBook {
	
	/**
	 * 一对一关联: 一本书只属于一个用户, 书的所有者
	 */
	private JsjUser user;
	
    public JsjUser getUser() {
		return user;
	}

	public void setUser(JsjUser user) {
		this.user = user;
	}

	private Integer id;

    private String name;

    private String author;

    private String press;

    private String isbn;

    private String pic;

    private String category;

    private String price;

    private String markPrice;

    private String discount;

    private String oldnew;

    private Integer ownerId;

    private Timestamp upTime;

    private Integer state;

    private String intro;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(String markPrice) {
        this.markPrice = markPrice == null ? null : markPrice.trim();
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount == null ? null : discount.trim();
    }

    public String getOldnew() {
        return oldnew;
    }

    public void setOldnew(String oldnew) {
        this.oldnew = oldnew == null ? null : oldnew.trim();
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Timestamp getUpTime() {
        return upTime;
    }

    public void setUpTime(Timestamp upTime) {
        this.upTime = upTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }
}