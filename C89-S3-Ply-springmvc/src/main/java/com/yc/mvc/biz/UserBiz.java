package com.yc.mvc.biz;

import org.springframework.stereotype.Service;

import com.yc.mvc.po.JsjUser;

@Service
public class UserBiz {

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

}
