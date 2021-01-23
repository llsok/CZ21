package com.yc.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yc.mvc.po.JsjFocus;

public interface FocusMapper {

	@Select("select * from jsj_focus where state=#{state}")
	List<JsjFocus> queryByState(int state);

}
