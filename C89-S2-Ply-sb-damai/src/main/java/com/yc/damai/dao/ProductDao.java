package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.damai.po.Product;

@Repository
public class ProductDao extends BaseDao {

	public List<Product> selectHot() {
		String sql = "select * from product where is_hot=1 limit 0,10";
		return jt.query(sql, productRowMapper);
	}

	/**
	 * 根据ID查询商品
	 * @param id
	 * @return
	 */
	public Product selectById(int id) {
		String sql = "select * from product where pid=?";
		return jt.query(sql, rs -> { // lamda 表达式
			// ResultSetExtrator 接口中方法，要求手动执行 结果集的 next 方法
			return rs.next() ? productRowMapper.mapRow(rs, -1)  :  null;
		}, id);
	}

	private RowMapper<Product> productRowMapper = new RowMapper<Product>() {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
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

	};

}
