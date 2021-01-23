package com.yc.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.mvc.po.JsjAddr;

public interface AddrMapper {

	@Select("select * from jsj_addr where id=#{id}")
	JsjAddr getAddrById(int id);

	@Update({ "update jsj_addr set code=0 where code=1;", "update jsj_addr set code=1 where id=#{id};" })
	void changeCode(int id);

	@Update("update jsj_addr set code=0")
	void updateAllCode();

	@Insert("insert into jsj_addr values(null,#{uid},#{addrName},#{addrPhone},#{addrPost},"
			+ "#{addrProvince},#{addrDesc},#{code})")
	int insertAddr(JsjAddr addr);

	@Select("select * from jsj_addr where uid=#{uid}")
	List<JsjAddr> getAddr(int uid);

	@Select("delete from jsj_addr where id=#{id}")
	void deleteAddr(int id);
	
	@Update("update jsj_addr set addr_name=#{addrName},addr_phone=#{addrPhone},addr_post=#{addrPost},"
			+ "addr_province=#{addrProvince},addr_desc=#{addrDesc},code=#{code} where id=#{id}")
	int changeAddr(JsjAddr addr);
}
