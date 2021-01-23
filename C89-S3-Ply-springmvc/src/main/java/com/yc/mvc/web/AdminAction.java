package com.yc.mvc.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.yc.mvc.biz.AdminBiz;
import com.yc.mvc.biz.BizException;
import com.yc.mvc.biz.UserBiz;
import com.yc.mvc.dao.AdminMapper;
import com.yc.mvc.dao.UserMapper;
import com.yc.mvc.po.JsjFans;
import com.yc.mvc.po.JsjAdmin;
import com.yc.mvc.po.JsjDict;
import com.yc.mvc.po.JsjUser;
import com.yc.mvc.web.po.Result;

@RestController
public class AdminAction {

	@Resource
	private AdminBiz abiz;

	@Resource
	private AdminMapper am;

	@PostMapping("log")
	public Result adminlogin(String name, String pwd, HttpSession session) throws BizException {
		JsjAdmin admin = new JsjAdmin();
		admin.setAccount(name);
		admin.setPwd(pwd);
		JsjAdmin dbadmin;
		try {
			dbadmin = abiz.login(admin);
			session.setAttribute("loginedAdmin", dbadmin);
			return Result.success("登录成功！", dbadmin);
		} catch (BizException e) {
			e.printStackTrace();
			return Result.failure(e.getMessage(), null);
		}
	}

	@RequestMapping("getAdminName")
	public Result getLoginedAdmin(@SessionAttribute JsjAdmin loginedAdmin) {
		return Result.success("获取管理员对象成功", loginedAdmin);
	}

}
