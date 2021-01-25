package com.yc.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.yc.mvc.po.JsjBook;
import com.yc.mvc.po.JsjSearch;

public interface BooksMapper {

	@Results(value = { @Result(column = "mark_price", property = "markPrice"),
			@Result(column = "owner_id", property = "ownerId") })
	@Select("select * from jsj_book order by up_time desc limit 0,40")
	public List<JsjBook> SelectBookH();

	@Results(value = { @Result(column = "mark_price", property = "markPrice"),
			@Result(column = "owner_id", property = "ownerId") })
	@Select("select * from jsj_book order by price limit 0,40")
	public List<JsjBook> SelectBookT();

	@Results(value = { @Result(column = "mark_price", property = "markPrice"),
			@Result(column = "owner_id", property = "ownerId") })
	@Select("select * from jsj_book where name like concat('%',#{name},'%')")
	public List<JsjBook> queryBookByname(String name);

	@Select("select * from jsj_book where category=#{cgy}")
	@ResultMap("rmbook")
	public List<JsjBook> SelectByCategory(int category);

	@Select("select * from jsj_book where id=#{id}")
	@Results(id="rmbook", value = { @Result(column = "owner_id", property = "user", 
		one = @One(select = "com.yc.mvc.dao.UserMapper.selectById")) })
	public JsjBook quertBookDetail(int id);

	@Select("select * from jsj_book order by id desc")
	@ResultMap("rmbook")
	public List<JsjBook> selectNew();
	
	@Select("select * from jsj_search  order by id")
	  public List<JsjSearch> queryhot();

	@Select("select *from jsj_book where owner_id = #{ownerid}")
	public List<JsjBook> queryMySellById(int ownerid);
	
	@Results(id="rmop",value = { @Result(column = "mark_price", property = "markPrice"),
			@Result(column = "owner_id", property = "ownerId"),
			@Result(column = "category", property = "cate",
			one = @One(select = "com.yc.mvc.dao.CategoryMapper.selectById"))})
	@Select("select * from jsj_book a join jsj_category b on a.category=b.id "
			+ "where a.name like concat('%',#{name},'%') "
			+ "and b.name like concat('%',#{catename},'%')"
			+ " ORDER BY a.id limit #{page},20")
	List<JsjBook> queryBookByNameAndCatename(String catename,String name,int page);

	@Select("select count(*) from jsj_book a join jsj_category b on a.category=b.id "
			+ "where a.name like concat('%',#{name},'%') "
			+ "and b.name like concat('%',#{catename},'%') ")
	int queryBookCount(String catename,String name);
}
