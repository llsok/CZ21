package com.yc.vue.dyg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.vue.dyg.bean.DygCategory;
import com.yc.vue.dyg.bean.DygMovie;
import com.yc.vue.dyg.bean.DygMovieWithBLOBs;
import com.yc.vue.dyg.bean.DygMsg;
import com.yc.vue.dyg.util.DBHelper;
import com.yc.vue.dyg.util.DBHelper.ResultSetMapper;

public class DygDao {
	
	public List<DygCategory> selectAllCategory() throws SQLException{
		// 查询所有分类
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
		return list;
		
	}
	
	public List<DygMovie> selectIndexYs() throws SQLException{
		String sql = "SELECT * from dyg_movie where category='ys'"
				+ " order by create_date desc limit 0,16";
		List<DygMovie> list;
		list = DBHelper.selectList(sql, new ResultSetMapper<DygMovie>() {

			@Override
			public DygMovie map(ResultSet rs) throws SQLException {
				DygMovie dm = new DygMovie();
				dm.setId(rs.getInt("id"));
				dm.setName(rs.getString("name"));
				dm.setPoster(rs.getString("poster"));
				dm.setCreateDate(rs.getInt("create_date"));
				// 其他字段请自行添加
				return dm;
			}
		});
		return list;
	}

	public DygMovieWithBLOBs selectById(String id) throws SQLException {
		String sql = "SELECT * from dyg_movie where id=?";
		List<DygMovieWithBLOBs> list;
		list = DBHelper.selectList(sql, new ResultSetMapper<DygMovieWithBLOBs>() {
			@Override
			public DygMovieWithBLOBs map(ResultSet rs) throws SQLException {
				DygMovieWithBLOBs dm = new DygMovieWithBLOBs();
				dm.setId(rs.getInt("id"));
				dm.setName(rs.getString("name"));
				dm.setPoster(rs.getString("poster"));
				dm.setCreateDate(rs.getInt("create_date"));
				dm.setIntro(rs.getString("intro"));
				// 其他字段请自行添加
				return dm;
			}
		}, id);
		return list.get(0);
	}
	
	public void insertMsg(DygMsg msg) throws SQLException {
		String sql = "insert into dyg_msg values(null,?,?,?,default,null,null)";
		DBHelper.update(sql, 
				msg.getCreateName(),
				msg.getEmail(),
				msg.getContent());
	}

}
