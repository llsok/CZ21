package com.yc.mvc.po;





import lombok.Data;

@Data
public class JsjOrderDetail implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
    private Long id;
    private Long oid;
    private Long bid;
    private Integer count;
    private Double price;
    private Integer state;
    private JsjBook book;
    private JsjOrder sellOrders;
    
    
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOid() {
		return oid;
	}
	public void setOid(Long oid) {
		this.oid = oid;
	}
	public Long getBid() {
		return bid;
	}
	public void setBid(Long bid) {
		this.bid = bid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public JsjBook getBook() {
		return book;
	}
	public void setBook(JsjBook book) {
		this.book = book;
	}
	public JsjOrder getSellOrders() {
		return sellOrders;
	}
	public void setSellOrders(JsjOrder sellOrders) {
		this.sellOrders = sellOrders;
	}
	@Override
	public String toString() {
		return "JsjOrderDetail [id=" + id + ", oid=" + oid + ", bid=" + bid + ", count=" + count + ", price=" + price
				+ ", book=" + book + ", sellOrders=" + sellOrders + "]";
	}
    
    
    
}


