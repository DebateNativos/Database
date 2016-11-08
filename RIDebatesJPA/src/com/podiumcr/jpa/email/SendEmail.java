package com.podiumcr.jpa.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public static void main(String[] args) {

		final String username = "latinapodiumcr@gmail.com";
		final String password = "p0diumcr";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
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
			message.setSubject("Registro al debate");
			message.setText("Hola,"
				+ "\n\n Usted se ha registrado al debate Luisgui y su administracion!." + "\n\n Una hora antes del debate se le asignara un rol.");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
}

