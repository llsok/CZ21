package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.damai.po.Product;

@Repository
public class ProductDao extends BaseDao{
	
	public List<Product> selectHot(){
		
		String sql = "select * from product where is_hot=1 limit 0,10";
		return jt.query(sql, productRowMapper);
	}
	
	public List<Product> queryNewProduct() {
		String sql = "select * from product order by pdate desc limit 0,10";
		return jt.query(sql, productRowMapper);
		
	}
	public Product queryProductById(int pid) {
		String sql = "select * from product where pid=?";
		return jt.query(sql, rs->{
			return rs.next() ? productRowMapper.mapRow(rs, -1) : null;
		}, pid);
		
	}
	
	public List<Product> queryProductByCsid(int csid) {
		String sql = "select * from product where csid=?";
		return jt.query(sql, productRowMapper,csid);
	}
	
	public List<Product> queryProductByCid(int cid) {
		String sql = "select product.* from product,categorysecond where "
				+ "product.csid=categorysecond.csid and categorysecond.cid=?";
		return jt.query(sql, productRowMapper,cid);
	}
	
	private RowMapper<Product> productRowMapper = new RowMapper<Product>() {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product p = new Product();
			p.setPid(rs.getInt("pid"));
			p.setPname(rs.getString("pname"));
			p.setMarketPrice(rs.getDouble("market_price"));
			p.setShopPrice(rs.getDouble("shop_price"));
			p.setImage(rs.getString("image"));
			p.setPdesc(rs.getString("pdesc"));
			p.setIsHot(rs.getInt("is_hot"));
			p.setPdate(rs.getDate("pdate"));
			p.setCsid(rs.getInt("csid"));
			return p;
		}
	};

	

	
}
