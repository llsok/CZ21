package com.yc.mvc.dao;

import java.util.List;


import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


import com.yc.mvc.po.JsjBook;

public interface BooksMapper {
  
  @Results(value= {
		    		 @Result(column = "mark_price",property = "markPrice"),
		    		 @Result(column="owner_id", property="ownerId")
		          }
		     )
  @Select("select * from jsj_book order by up_time desc limit 0,40")
  public List<JsjBook> SelectBookH();
  
  @Results(value= {
 		 @Result(column = "mark_price",property = "markPrice"),
 		 @Result(column="owner_id", property="ownerId")
       }
  )
  @Select("select * from jsj_book order by price limit 0,40")
  public List<JsjBook> SelectBookT();
  
}
