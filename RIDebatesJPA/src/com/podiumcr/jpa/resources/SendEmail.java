package com.podiumcr.jpa.resources;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.podiumcr.jpa.entities.User;

public class SendEmail {
	
	public SendEmail(){
		
	}
	
	public void SendWelcomeEmail(User user) {
		
		final String username = "latinapodiumcr@gmail.com";
		final String password = "p0diumcr";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", false);
		//props.put("mail.smtp.ssl.trust", "host");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("latinapodiumcr@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("latinapodiumcr@gmail.com"));
			message.setSubject("Bienvenido a PODIUM!");
			message.setText("Bienvenido "+user.getName()+","
				+ "\n\n Usted se ha registrado a PODIUM!." + "\n\n En nuestra aplicacion encontrara los mejores debates de la Universidad Latina.");

			Transport.send(message);

			//System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
}

