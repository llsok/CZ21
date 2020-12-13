package com.yc.C89S2Plyspringboot.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.C89S2Plyspringboot.dao.Account;
import com.yc.C89S2Plyspringboot.dao.AccountDao;

@Service
public class BankBiz {
	
	/**
	 * 根据用户名发送验证邮件，并且将生产验证码返回
	 * @param name
	 * @return
	 */
	@Resource
	private AccountDao adao;
	
	@Resource
	private MailBiz mbiz;
	
	public String sendVcode(String name) {
		// 根据用户名获取用户信息
		Account acc = adao.selectByName(name);
		// 生产随机验证码
		String vcode = "" + System.currentTimeMillis();
		vcode = vcode.substring(vcode.length()-4);
		// 发送邮件
		mbiz.sendSimpleMail(acc.getEmail(), 
				"密码重置验证码", "请使用 "+vcode+" 验证码重置您的密码!");
		return vcode;
	}

	public String resetPwd(String name, String vcode, 
			String pwd, String sessionVcode) {
		if(vcode.equalsIgnoreCase(sessionVcode)) {
			adao.updatePwdByName(pwd, name);
			return "密码重置成功！";
		} else {
			return "验证码错误！";
		}
	}

}
