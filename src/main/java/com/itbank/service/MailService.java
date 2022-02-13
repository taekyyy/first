package com.itbank.service;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class MailService {

	public String getAuthNumber() {
		Random ran = new Random();
		String authNumber = "";
		for(int i = 0 ; i < 6 ; i++) {
			authNumber += ran.nextInt(9);
		}
		return authNumber;
	}
	
	public String sendMail(String email, String authNumber, String account) {
		String host = "smtp.naver.com";
		int port = 587;
		final String userid = account.split("/")[0];
		final String password = account.split("/")[1];
		
		Properties props = System.getProperties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.prot", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable","true");
		props.put("mail.smtp.trust", host);
		
		Session mailSession = Session.getDefaultInstance(props, new Authenticator() {
		String id = userid;
		String pw = password;
		
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(id, pw);
			}
		});
		mailSession.setDebug(true);
		
		Message mimeMessage = new MimeMessage(mailSession);
		
		String subject = "[onEarth(us)] 인증번호 입니다";
		String tag = "<div style=\"padding: 10px; font-size: 24px;border: 2px solid #dadada;box-sizing:border-box;\">"
				+ "안녕하세요  <span style=\"font-weight: 700; color: #1e5784;\">onEarth(us)</span>에서 알려드립니다.<br><br>"
				+ "인증 번호는 [<span style=\"font-size=24px; font-weight: bold;\">%s</span>] 입니다</div>";
		String body = String.format(tag, authNumber);
	
		try {
			mimeMessage.setFrom(new InternetAddress(userid + "@naver.com"));
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
			mimeMessage.setSubject(subject);
			mimeMessage.setContent(body, "text/html; charset=utf-8");
			
			Transport.send(mimeMessage);
			
		} catch(MessagingException e) {
			System.out.println("주소가 잘못되었습니다");
		}
		
		return authNumber;
	}
}
