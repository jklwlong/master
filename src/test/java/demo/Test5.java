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
	 * ���ʼ�����
	 */
	private static void  simpleMail(){
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		// �趨mail server
		senderImpl.setHost("smtp.163.com");
		// �����ʼ���Ϣ
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		// �����ռ��ˣ��ļ��� �����鷢�Ͷ���ʼ�
		mailMessage.setTo("415465852@qq.com");
		mailMessage.setFrom("jklwlong@163.com");
		mailMessage.setSubject("������⣡");
		mailMessage.setText("�������ݣ�");
		// �����Լ������,����username
		senderImpl.setUsername("jklwlong@163.com"); 
		// �����Լ������, ����password
		senderImpl.setPassword("jkl532100"); 
		Properties prop = new Properties();
		// �����������Ϊtrue���÷�����������֤,��֤�û����������Ƿ���ȷ
		prop.put("mail.smtp.auth", " true "); 
		prop.put("mail.smtp.timeout", "25000");
		senderImpl.setJavaMailProperties(prop);
		// �����ʼ�
		senderImpl.send(mailMessage);
		System.out.println("���ʼ����ͳɹ�");
	}
	/**
	 * html�ʼ�����
	 */
	private static void  htmlMail() throws Exception{
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();  
		  
        // �趨mail server  
        senderImpl.setHost("smtp.163.com");  
  
        // �����ʼ���Ϣ,���ͼ��ʼ���html�ʼ�������  
        MimeMessage mailMessage = senderImpl.createMimeMessage();  
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage);  
  
        // �����ռ��ˣ��ļ���  
        messageHelper.setTo("415465852@qq.com");  
        messageHelper.setFrom("jklwlong@163.com");  
        messageHelper.setSubject("����");  
        // true ��ʾ����HTML��ʽ���ʼ�  
        messageHelper.setText("<html><head></head><body><h1>hello!!spring html Mail</h1></body></html>", true);  
        senderImpl.setUsername("jklwlong@163.com"); // �����Լ������,����username  
        senderImpl.setPassword("jkl532100"); // �����Լ������, ����password  
        Properties prop = new Properties();  
        prop.put("mail.smtp.auth", "true"); // �����������Ϊtrue���÷�����������֤,��֤�û����������Ƿ���ȷ  
        prop.put("mail.smtp.timeout", "25000");  
        senderImpl.setJavaMailProperties(prop);  
        // �����ʼ�  
        senderImpl.send(mailMessage);  
  
        System.out.println("�ʼ����ͳɹ�..");  
	}
}
