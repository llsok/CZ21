package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.damai.po.Product;
import com.yc.damai.util.DBHelper;
import com.yc.damai.util.DBHelper.ResultSetMapper;

public class ProductDao {

	/**
	 * 商品字段映射器对象
	 */
	private ProductMapper pm = new ProductMapper();

	public List<Product> queryHot() {
		String sql = "select * from product where is_hot=1 limit 0,10";
		try {
			return DBHelper.selectList(sql, pm);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static class ProductMapper implements ResultSetMapper<Product> {

		@Override
		public Product map(ResultSet rs) throws SQLException {
			Product p = new Product();
			p.setPid(rs.getInt("pid"));
			p.setCsid(rs.getInt("csid"));
			p.setImage(rs.getString("image"));
			p.setIsHot(rs.getInt("is_hot"));
			p.setMarketPrice(rs.getDouble("market_Price"));
			p.setPdate(rs.getDate("pdate"));
			p.setPdesc(rs.getString("pdesc"));
			p.setPname(rs.getString("pname"));
			p.setShopPrice(rs.getDouble("shop_price"));
			return p;
		}

	}

}
