package com.yc.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.yc.mybatis.bean.JsjBook;
import com.yc.mybatis.bean.JsjSearch;

public interface SearchMapper {
	
	@Select("select * from jsj_search where id=#{iiiddd}")
	JsjSearch selectById(int id);
	
	@Insert("insert into jsj_search values(null, #{keyword}, #{hots})")
	/**
	 *	获取数据库生成主键值
	 *	useGeneratedKeys 开启获取自增列值的开关
	 *	keyColumn		 主键字段名
	 *	keyProperty		 实体类的主键字段对应属性名
	 *	@Options 注解的属性 对应与 insert 标签的属性
	 */
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	int insert(JsjSearch js);
	
	/**
	 * 	课堂练习
	 * @Update
	 * @Delete
	 */
	
	/**
	 * 	自定义映射: xml 
	 * 		<resultMap id="rmXXX"> : <id> <result> <collection> <association>
	 * 	对应	@Results
	 * 	book ==> user 一对一
	 */
	@Select("select * from jsj_book where id=#{id}")
	@Results(id = "rmXXX", 
		value = {
			@Result(column = "mark_price", property = "markPrice"),
			@Result(column = "owner_id", property = "ownerId"),
			@Result(column = "owner_id", property = "user",
				one = @One(select = "com.yc.mybatis.dao.UserMapper.selectById",
					fetchType = FetchType.LAZY)),
		})
	JsjBook queryById(int id);
	
	@Select("select * from jsj_book where category=#{category}")
	@ResultMap("rmXXX")
	List<JsjBook> queryByCategory(String category);
	
	/**
	 * 	请实现一对多关联查询:  查询用户下的所有的图书
	 */
}
