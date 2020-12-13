package com.yc.C89S2Plyspringboot.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailBiz {
	@Autowired 
	/**
	 * 自动装配 ==》 @Resource
	 * JavaMailSender 被SpringIOC容器托管，是容器中的一个Bean
	 * @Bean
	 * public JavaMailSender mailSender(){
	 *		// 伪代码
	 * 		return new JavaMailSender();
	 * }
	 */
	private JavaMailSender mailSender; // SpringBoot 提供的邮件发送器对象
	
	@Value("${mail.from.addr}") // 读取配置参数
	private String from;

	/**
	 * 发送方法
	 * @param to		发送给谁
	 * @param subject	邮件标题
	 * @param content	邮件内容
	 */
	public void sendSimpleMail(String to, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		mailSender.send(message);
	}

}
