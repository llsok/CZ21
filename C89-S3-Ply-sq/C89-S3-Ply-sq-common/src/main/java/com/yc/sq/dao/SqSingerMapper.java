package com.yc.sq.dao;

import com.yc.sq.bean.SqSinger;
import com.yc.sq.bean.SqSingerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SqSingerMapper {
    long countByExample(SqSingerExample example);

    int deleteByExample(SqSingerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SqSinger record);

    int insertSelective(SqSinger record);

    List<SqSinger> selectByExample(SqSingerExample example);

    SqSinger selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SqSinger record, @Param("example") SqSingerExample example);

    int updateByExample(@Param("record") SqSinger record, @Param("example") SqSingerExample example);

    int updateByPrimaryKeySelective(SqSinger record);

    int updateByPrimaryKey(SqSinger record);
}