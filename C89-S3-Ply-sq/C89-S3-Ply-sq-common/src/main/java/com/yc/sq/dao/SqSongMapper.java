package com.yc.sq.dao;

import com.yc.sq.bean.SqSong;
import com.yc.sq.bean.SqSongExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SqSongMapper {
    long countByExample(SqSongExample example);

    int deleteByExample(SqSongExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SqSong record);

    int insertSelective(SqSong record);

    List<SqSong> selectByExample(SqSongExample example);

    SqSong selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SqSong record, @Param("example") SqSongExample example);

    int updateByExample(@Param("record") SqSong record, @Param("example") SqSongExample example);

    int updateByPrimaryKeySelective(SqSong record);

    int updateByPrimaryKey(SqSong record);
}