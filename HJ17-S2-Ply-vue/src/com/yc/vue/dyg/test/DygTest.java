package com.yc.vue.dyg.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.yc.vue.dyg.bean.DygCategory;
import com.yc.vue.dyg.util.DBHelper;
import com.yc.vue.dyg.util.DBHelper.ResultSetMapper;

public class DygTest {

	/**
	 * 单元测试 ， 替代main方法测试
	 * 
	 * @throws SQLException
	 */
	@Test // 注解
	public void test1() throws SQLException {

		String sql = "select * from dyg_category";
		List<DygCategory> list;
		list = DBHelper.selectList(sql, new ResultSetMapper<DygCategory>() {

			@Override
			public DygCategory map(ResultSet rs) throws SQLException {
				DygCategory dc = new DygCategory();
				dc.setId(rs.getInt("id"));
				dc.setName(rs.getString("name"));
				dc.setSn(rs.getString("sn"));
				return dc;
			}
		});
		
		for(DygCategory dc : list) {
			System.out.println(dc.getName());
		}

	}

}
