package com.yc.mvc.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.yc.mvc.biz.BizException;
import com.yc.mvc.biz.UserBiz;
import com.yc.mvc.dao.UserMapper;
import com.yc.mvc.po.JsjUser;
import com.yc.mvc.web.po.Result;

@RestController
public class UserAction {

	@Resource
	private UserBiz ubiz;
	
	@Resource
	private UserMapper um;
	
	@PostMapping("login.do")
	public Result login(JsjUser user, HttpSession session) throws BizException {
		JsjUser dbuser;
		try {
			dbuser = ubiz.login(user);
			session.setAttribute("loginedUser", dbuser);
			return Result.success("登录成功！", dbuser);
		} catch (BizException e) {
			e.printStackTrace();
			return Result.failure(e.getMessage(), null);
		}
	}
	
	@RequestMapping("getLoginedUser.do")
	public Result getLoginedUser(@SessionAttribute JsjUser loginedUser) {
		return Result.success("获取用户对象成功", loginedUser);
	}
	
	/**
	 * 	注册用户， SpringMVC 验证功能
	 * 	第一步：pom依赖：添加验证依赖
	 *  <dependency>
			<groupId>javax.validation</groupId>
			<artifactId>validation-api</artifactId>
		</dependency>
		<dependency>
			<groupId>org.hibernate.validator</groupId>
			<artifactId>hibernate-validator</artifactId>
		</dependency>
		规范数据验证：JSR303规范
		
		第二步：在实体类属性上添加验证注解
		第三步： 在控制器方法中定义 错误对象
			1. 在被验证的对象前添加 Valid 注解
			2.在被验证的对象后添加 Errors 对象参数（必须是紧跟被验证的对象参数后）
		
	 * @param user
	 * @return
	 */
	@RequestMapping("regist.do")
	public Result regist(@Valid JsjUser user, Errors errors) {
		// 判断是否出现验证错误
		if(errors.hasErrors()) {
			return Result.failure("字段验证错误！", errors.getAllErrors());
		}
		// TODO 业务层代码， 未完待续
		try {
			ubiz.register(user);
			return Result.success("注册成功！", null);
		} catch (Exception e) {
			//e.printStackTrace();
			errors.rejectValue("account", "NotOne", e.getMessage());
			return Result.failure("字段验证错误", errors.getAllErrors());
		}
		
	}
	
	/**
	 * 	二阶段 Servlet 如何接收上传的文件
	 * 	@MutilPartConfig
	 * 	public class XXXServlet extends HttpServlet{
	 * 		public void doPost(req,resp){
	 * 			Part part = req.getPart("headImgFile");
	 * 			part.write("文件路径");
	 * 		}
	 * 	}
	 * 
	 * 
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@PostMapping("upload.do")
	public Result upload(@RequestParam("headImgFile") MultipartFile headImgFile,
			@SessionAttribute JsjUser loginedUser){
		// 1. 保存文件 （保存到磁盘上）
		String newfile = UUID.randomUUID().toString();//   1  时间戳， 2 随机数，  3，UUID
		String oldfile = headImgFile.getOriginalFilename();
		// 获取原文件的后缀名
		String suffix = oldfile.substring(oldfile.lastIndexOf("."));
		System.out.println(suffix);
		if(suffix.equalsIgnoreCase(".png")||suffix.equalsIgnoreCase(".jpg")||suffix.equalsIgnoreCase(".gif")||suffix.equalsIgnoreCase(".jpeg")
				||suffix.equalsIgnoreCase(".pdf")) {
			newfile += suffix;
			try {
				headImgFile.transferTo(new File("e:/jsj/upload_head", newfile));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return Result.failure(0,"文件上传失败！", null);
			}
			// 2. 返回图片的web路径 
			String webpath = "upload_head/" + newfile;
			loginedUser.setHeadImg(webpath);
			ubiz.updateHeadImg(loginedUser);
			return Result.success(1,"文件上传成功！", webpath);
		}else {
			return Result.failure(0,"文件上传失败，文件不是图片！", suffix);
		}
		
	}

	@RequestMapping("getlastTimeUsers.do")
	public List<JsjUser> getlastTimeUsers() {
		return um.getlastTimeUsers();
	}
	
	@GetMapping("NewReg.do")
	public List<JsjUser> selectNewReg() {
		List<JsjUser> newReg;
		newReg =um.selectNewRegUser();
		return newReg;
	}

	
	@RequestMapping("selectById")
	public JsjUser selectById(int id) {
		return  um.selectById(id);		
	}

	@PostMapping("sign.do")
	public Result updateSign(String sign,int id) {
		um.updateJsjUserSign(sign,id);
		return Result.success("修改成功", null);
	}


}
