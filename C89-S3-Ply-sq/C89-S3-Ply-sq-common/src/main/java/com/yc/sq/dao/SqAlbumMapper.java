package com.yc.sq.dao;

import com.yc.sq.bean.SqAlbum;
import com.yc.sq.bean.SqAlbumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SqAlbumMapper {
    long countByExample(SqAlbumExample example);

    int deleteByExample(SqAlbumExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SqAlbum record);

    int insertSelective(SqAlbum record);

    List<SqAlbum> selectByExample(SqAlbumExample example);

    SqAlbum selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SqAlbum record, @Param("example") SqAlbumExample example);

    int updateByExample(@Param("record") SqAlbum record, @Param("example") SqAlbumExample example);

    int updateByPrimaryKeySelective(SqAlbum record);

    int updateByPrimaryKey(SqAlbum record);
}