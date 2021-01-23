package com.yc.mvc.biz;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.mvc.dao.AdminMapper;
import com.yc.mvc.dao.UserMapper;
import com.yc.mvc.po.JsjAdmin;
import com.yc.mvc.po.JsjUser;
import com.yc.mvc.web.po.Result;

@Service
public class AdminBiz {

	@Resource
	private AdminMapper am;
	
	public JsjAdmin login(JsjAdmin admin) throws BizException {
		// 避免对数据库连接资源的滥用
		if(admin.getAccount()==null || admin.getAccount().trim().isEmpty()) {
			throw new BizException("请填写用户名");
		}
		JsjAdmin admin2 = am.selectByAccountAndPwd(admin.getAccount(),admin.getPwd());
		if(admin2 !=null) {
			return admin2;
		}else {
			throw new BizException("用户名或密码错误");
		}
	}
}
