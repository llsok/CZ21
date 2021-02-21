package com.yc.sq.dao;

import com.yc.sq.bean.SqMember;
import com.yc.sq.bean.SqMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SqMemberMapper {
    long countByExample(SqMemberExample example);

    int deleteByExample(SqMemberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SqMember record);

    int insertSelective(SqMember record);

    List<SqMember> selectByExample(SqMemberExample example);

    SqMember selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SqMember record, @Param("example") SqMemberExample example);

    int updateByExample(@Param("record") SqMember record, @Param("example") SqMemberExample example);

    int updateByPrimaryKeySelective(SqMember record);

    int updateByPrimaryKey(SqMember record);
}