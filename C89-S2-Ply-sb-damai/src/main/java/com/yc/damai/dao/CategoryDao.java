package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.yc.damai.po.category;

@Repository
public class CategoryDao extends BaseDao{
	
	public List<category> selectAll(){
		String sql="select * from category order by cid";
		return jt.query(sql, categoryRowMapper);
	}
	
	
	
	
	private RowMapper<category> categoryRowMapper = new RowMapper<category>() {

		@Override
		public category mapRow(ResultSet rs, int rowNum) throws SQLException {
			category c = new category();
			c.setCid(rs.getInt("cid"));
			c.setCname(rs.getString("cname"));
			return c;
		}

	};
}
