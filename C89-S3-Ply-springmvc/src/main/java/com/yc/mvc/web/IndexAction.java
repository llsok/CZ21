package com.yc.mvc.web;

import java.io.InputStream;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @Controller ==> 动态模版技术时代 （jsp， asp， thymleaf。。。）
 * @RestController ==> 前后端分离时代（ajax）==》 json
 * 
 * MVC ： M：spring ejb   V： jsp，asp   C： springmvc， struts  workmvc。。。
 * 
 * 	坐井观天
 *
 */
@RestController
/**
 * 	监视 数据模型（Model）中的某些数据，如果出现那么就保存到会话中
 * 		1. 监视属性名
 * 		2. 监视属性的类型
 */

@SessionAttributes(names = "数据1", types = Date.class)
public class IndexAction {
	
	/**
	 * 	回顾：
	 * 	地址映射：
	 * 		RequestMapping
	 * 			name，
	 * 			path == value
	 * 			params 参数限定
	 * 			headers 头域值限定
	 * 			consumes ==> Content-Type 字段 ： post 请求  get 没有 body
	 * 			produres ==> Accpet 字段
	 * 			method   头行 method 字段
	 * 		GetMapping， PostMapping ， DeleteMapping 。。。
	 * 	参数映射规则：
	 * 		1. 请求参数名 == 方法参数名 ==》 请求参数名 ==》对象属性名
	 * 		2. 对象接收参数，支持 . （点号运算符）
	 * 		3. 请求的数组语法： a=1&a=2&a=3&.... ==> String[] a
	 * 		4. 数组+对象语法： a[0].id=10&a[0].name=root&....
	 * 		5.springmvc 可以自动转换常用的数据类型  int date 。。。
	 * 	自定义类型转换：
	 * 		1.定义类实现 springmvc 的 Converter<String, Date> 接口
	 * 		2.实现该接口转换类型的方法
	 * 		3.将该类提交给IOC容器托管 ==》组件注解 Component
	 * 
	 * 1. 	Servlet 对象注入 + 会话数据处理
	 * 		请求， 响应，会话，输入输出流（tomcat）
	 * 		Sevlet对象可以直接注入到 控制器的方法中
	 * 		
	 * 		案例1
	 * 		index ==> index1
	 * 			  ==> index2
	 * 		案例2
	 * 		index4 ==> index2	正确
	 * 		index3 ==> index2 	错误 
	 * 
	 * 		登录
	 * 
	 * 2. 	请求参数校验
	 * 		注册
	 * 3.	文件上传
	 * 4.	静态的资源映射
	 * 
	 */
	@GetMapping("index")
	public String index(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			InputStream in) {
		System.out.println(request);
		System.out.println(response);
		System.out.println(session);
		System.out.println(in);
		session.setAttribute("数据1", "你好啊");
		request.setAttribute("数据2", "我好啊");
		return "index";
	}
	
	@GetMapping("index1")
	public String index1(
			HttpServletRequest request,
			HttpSession session) {
		String ret = session.getAttribute("数据1") + "<br>"; 
		ret +=  request.getAttribute("数据2") ;
		return ret;
	}
	
	/**
	 * SpringMVC如何向会话中读写数据？前提，不使用会话对象
	 * @SessionAttribute 用于读写会话中的属性值， 默认以方法参数名作为属性名
	 * required 必须的 ==》 默认为 true
	 * @return
	 */
	@GetMapping("index2")
	public String index2(@SessionAttribute(name="数据1",required = false) String data1) {
		return "index2 : " + data1;
		// 热部署 ， 保存会话中的数据
	}
	
	/**
	 * 	写会话数据，在RestController控制中可能有问题
	 * 	Model model 应用在页面跳转的场景下
	 * 	ajax ==》 json
	 */
	// 失败， 没有将数据保存到会话中
	@GetMapping("index3")
	public String index3(Model model) {
		// model 默认会将数据保存到 请求对象中
		model.addAttribute("数据1", "下午好");
		return "index3";
	}
	
	/**
	 * ModelAndView 用于页面跳转==》携带数据
	 * @param mav
	 * @return
	 */
	@GetMapping("index4")
	public ModelAndView index4(ModelAndView mav) {
		mav.addObject("数据1", "下午好");
		mav.setViewName("test");
		return mav;
	}
	
}
