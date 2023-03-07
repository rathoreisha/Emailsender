package com.email.email;

import java.util.Properties;

import org.springframework.stereotype.Component;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.Authenticator;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

@Component
public class Gmailsender {
	
	boolean flag=false;
	
	public boolean sendEmail(String to,String from,String subject,String text,String content)
	{
		Properties properties =new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		
		String username="isharathore345";
		String password="zwximtbgbnlzjoyi";
		
		Session session =Session.getInstance(properties,new Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			
			Message msg=new MimeMessage(session);
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setFrom(new InternetAddress(from));
			msg.setSubject(subject);
			msg.setText(text);
//			File sending code
			MimeBodyPart messgeBodyPart=new MimeBodyPart();
			Multipart multipart=new MimeMultipart();
			multipart.addBodyPart(messgeBodyPart);

			
			DataSource source=new FileDataSource(content);
			messgeBodyPart.setDataHandler(new DataHandler(source));
            multipart.addBodyPart(messgeBodyPart);
            messgeBodyPart.setContent(multipart);
			Transport.send(msg);
			flag=true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
