package com.yc.damai.test;

import java.sql.SQLException;

import org.junit.Test;

import com.yc.damai.util.DBHelper;

public class DmTest {

	@Test
	public void test1() throws SQLException {
		String sql = "select * from product";
		DBHelper.selectList(sql, new com.yc.damai.dao.ProductDao.ProductMapper());
	}

}
