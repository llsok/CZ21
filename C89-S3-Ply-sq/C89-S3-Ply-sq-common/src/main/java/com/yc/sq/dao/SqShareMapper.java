package com.yc.sq.dao;

import com.yc.sq.bean.SqShare;
import com.yc.sq.bean.SqShareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SqShareMapper {
    long countByExample(SqShareExample example);

    int deleteByExample(SqShareExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SqShare record);

    int insertSelective(SqShare record);

    List<SqShare> selectByExample(SqShareExample example);

    SqShare selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SqShare record, @Param("example") SqShareExample example);

    int updateByExample(@Param("record") SqShare record, @Param("example") SqShareExample example);

    int updateByPrimaryKeySelective(SqShare record);

    int updateByPrimaryKey(SqShare record);
}