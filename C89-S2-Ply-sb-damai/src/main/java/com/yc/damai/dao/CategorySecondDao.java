package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.damai.po.CategorySecond;

@Repository
public class CategorySecondDao extends BaseDao{

	public List<CategorySecond> queryCategorySecond() throws SQLException {
		String sql = "select * from categorysecond";
		return jt.query(sql, CSRowMapper);
	}
	
	
	
	private RowMapper<CategorySecond> CSRowMapper = new RowMapper<CategorySecond>() {

		@Override
		public CategorySecond mapRow(ResultSet rs, int rowNum) throws SQLException {
			CategorySecond cs = new CategorySecond();
			cs.setCid(rs.getInt("cid"));
			cs.setCsid(rs.getInt("csid"));
			cs.setCsname(rs.getString("csname"));
			return cs;
		}
	};
}
