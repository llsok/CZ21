package com.yc.mvc.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.mvc.dao.UserMapper;
import com.yc.mvc.po.JsjUser;

@Service
public class UserBiz {

	@Resource
	private UserMapper um;
	
	public JsjUser login(JsjUser user) throws BizException {
		// yc 123 扩展： mybatis 实现数据库的查询
		if("yc".equals(user.getAccount()) && "123".equals(user.getPwd())) {
			JsjUser dbuser = new JsjUser();
			dbuser.setAccount(user.getAccount());
			dbuser.setPwd(user.getPwd());
			dbuser.setName("root");
			//....
			return dbuser;
		} else {
			throw new BizException("用户名或密码错误！");
		}
	}
	
	
	@Transactional
	public void register(JsjUser user) throws BizException {
		if (um.selectByAccount(user.getAccount()) != null) {
			throw new BizException("该账号已被使用！");
		}
		if (user.getGender().equals("m")) {
			user.setGender("男");
		}else {
			user.setGender("女");
		}
		String phone = user.getPhone().replaceAll("(\\d{7})\\d{4}", "$1****");
		user.setPhone(phone);
		um.insert(user);		
	}

}
