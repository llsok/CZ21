package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.damai.po.categorySecond;
import com.yc.damai.po.category;

@Repository
public class CategorysecondDao extends BaseDao{
	
		
	public List<categorySecond> selectAll(){
		String sql="select * from categorysecond";
		return jt.query(sql, categorySecondRowMapper);
	}
	
	private RowMapper<categorySecond> categorySecondRowMapper = new RowMapper<categorySecond>() {

		@Override
		public categorySecond mapRow(ResultSet rs, int rowNum) throws SQLException {
			categorySecond cs = new categorySecond();
			cs.setCid(rs.getInt("cid"));
			cs.setCsid(rs.getInt("csid"));
			cs.setCsname(rs.getString("csname"));
			return cs;
		}

	};
}
