package com.yc.sq.dao;

import com.yc.sq.bean.SqComment;
import com.yc.sq.bean.SqCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SqCommentMapper {
    long countByExample(SqCommentExample example);

    int deleteByExample(SqCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SqComment record);

    int insertSelective(SqComment record);

    List<SqComment> selectByExample(SqCommentExample example);

    SqComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SqComment record, @Param("example") SqCommentExample example);

    int updateByExample(@Param("record") SqComment record, @Param("example") SqCommentExample example);

    int updateByPrimaryKeySelective(SqComment record);

    int updateByPrimaryKey(SqComment record);
}