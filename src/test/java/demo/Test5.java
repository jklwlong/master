package demo;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class Test5 {
	public static void main(String[] args) throws Exception{
		simpleMail();
		htmlMail();
	}
	/**
	 * 简单邮件发送
	 */
	private static void  simpleMail(){
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		// 设定mail server
		senderImpl.setHost("smtp.163.com");
		// 建立邮件消息
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		// 设置收件人，寄件人 用数组发送多个邮件
		mailMessage.setTo("415465852@qq.com");
		mailMessage.setFrom("jklwlong@163.com");
		mailMessage.setSubject("这里标题！");
		mailMessage.setText("这里内容！");
		// 根据自己的情况,设置username
		senderImpl.setUsername("jklwlong@163.com"); 
		// 根据自己的情况, 设置password
		senderImpl.setPassword("jkl532100"); 
		Properties prop = new Properties();
		// 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
		prop.put("mail.smtp.auth", " true "); 
		prop.put("mail.smtp.timeout", "25000");
		senderImpl.setJavaMailProperties(prop);
		// 发送邮件
		senderImpl.send(mailMessage);
		System.out.println("简单邮件发送成功");
	}
	/**
	 * html邮件发送
	 */
	private static void  htmlMail() throws Exception{
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();  
		  
        // 设定mail server  
        senderImpl.setHost("smtp.163.com");  
  
        // 建立邮件消息,发送简单邮件和html邮件的区别  
        MimeMessage mailMessage = senderImpl.createMimeMessage();  
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage);  
  
        // 设置收件人，寄件人  
        messageHelper.setTo("415465852@qq.com");  
        messageHelper.setFrom("jklwlong@163.com");  
        messageHelper.setSubject("主题");  
        // true 表示启动HTML格式的邮件  
        messageHelper.setText("<html><head></head><body><h1>hello!!spring html Mail</h1></body></html>", true);  
        senderImpl.setUsername("jklwlong@163.com"); // 根据自己的情况,设置username  
        senderImpl.setPassword("jkl532100"); // 根据自己的情况, 设置password  
        Properties prop = new Properties();  
        prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确  
        prop.put("mail.smtp.timeout", "25000");  
        senderImpl.setJavaMailProperties(prop);  
        // 发送邮件  
        senderImpl.send(mailMessage);  
  
        System.out.println("邮件发送成功..");  
	}
}
