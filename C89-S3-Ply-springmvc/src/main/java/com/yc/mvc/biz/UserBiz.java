package com.yc.mvc.biz;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.mvc.dao.UserMapper;
import com.yc.mvc.po.JsjUser;
import com.yc.mvc.util.QRCodeUtils;
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
	public void register(JsjUser user) throws Exception {
		if (um.selectByAccount(user.getAccount()) != null) {
			throw new BizException("该账号已被使用！");
		}
		
		
		user.setGender("m".equals(user.getGender())?"男":"女");
		Random r=new Random();
		Integer inviteId=r.nextInt(10000000)+100000;
		String phone = user.getPhone().replaceAll("(\\d{7})\\d{4}", "$1****");
		user.setPhone(phone);
		user.setInviteId(inviteId);
		if(user.getInviteName().equals("undefined")) {
			user.setInviteName(null);
		}
		String text = "http://127.0.0.1/register.html?"+inviteId;
		String logoPath = "e:/jsj/upload_head/test.jpg";
        String destPath = "e:/jsj/upload_head";
        String jpgName=QRCodeUtils.encode(text, logoPath, destPath,true);
        String webpath = "upload_head/" + jpgName;
        user.setQrImg(webpath);
		um.insert(user);		
	}


	public void updateHeadImg(JsjUser loginedUser) {
		um.updateHeadImg(loginedUser);
	}

}
