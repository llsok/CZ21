package com.yc.mvc.biz;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.mvc.dao.UserMapper;
import com.yc.mvc.po.JsjUser;
import com.yc.mvc.web.po.Result;

@Service
public class UserBiz {

	@Resource
	private UserMapper um;
	
	public JsjUser login(JsjUser user) throws BizException {
		// yc 123 扩展： mybatis 实现数据库的查询
//		if("yc".equals(user.getAccount()) && "123".equals(user.getPwd())) {
//			JsjUser dbuser = new JsjUser();
//			dbuser.setAccount(user.getAccount());
//			dbuser.setPwd(user.getPwd());
//			dbuser.setName("root");
//			//....
//			return dbuser;
//		} else {
//			throw new BizException("用户名或密码错误！");
//		}
		
		// 避免对数据库连接资源的滥用
		if(user.getAccount()==null || user.getAccount().trim().isEmpty()) {
			throw new BizException("请填写用户名");
		}
		JsjUser user2 = um.selectByAccountAndPwd(user.getAccount(),user.getPwd());
		if(user2 !=null) {
			Date date=new Date();
			String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			Timestamp timestamp=Timestamp.valueOf(time);
			user2.setLastLoginTime(timestamp);
			um.updatelastLoginTime(user2);
			return user2;
		}else {
			throw new BizException("用户名或密码错误");
		}
		
		
	}
	
	
	@Transactional
	public void register(JsjUser user) throws BizException {
		if (um.selectByAccount(user.getAccount()) != null) {
			throw new BizException("该账号已被使用！");
		}
		if (user.getGender().equals("m")) { // 空指针异常的风险
			user.setGender("男");
		}else {
			user.setGender("女");
		}
		user.setGender("m".equals(user.getGender())?"男":"女");
		String phone = user.getPhone().replaceAll("(\\d{7})\\d{4}", "$1****");
		user.setPhone(phone);
		um.insert(user);		
	}


	public void updateHeadImg(JsjUser loginedUser) {
		um.updateHeadImg(loginedUser);
	}

}
