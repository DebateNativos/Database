package com.podiumcr.jpa.resources;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.podiumcr.jpa.entities.Debate;
import com.podiumcr.jpa.entities.User;

public class SendEmail {

	private final String username = "latinapodiumcr@gmail.com";
	private final String password = "p0diumcr";

	public SendEmail() {

	}

	public void SendWelcomeEmail(User user) throws AddressException, MessagingException {

		Properties props = new Properties();
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.EnableSSL.enable", "true");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		// session.setDebug(true);

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));

		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
		message.setSubject("Bienvenido a PODIUM!");
		message.setText("Bienvenido " + user.getName() + "," + "\n\n Usted se ha registrado a PODIUM!."
				+ "\n\n En nuestra aplicacion encontrara los mejores debates de la Universidad Latina.");
		String html = "HOLA!" + "\n\n Usted ha sido seleccionado para participar en el debate "
				+ "link <a href='http://debatesapp.azurewebsites.net/podiumwebapp/ws/debate/confirmeddebates?email=@gmail'>Confirmar Asistencia</a>";
		message.setContent(html, "text/html; charset=utf-8");

		Transport transport = session.getTransport("smtp");
		try {
			transport.connect("smtp.gmail.com", username, password);
			transport.sendMessage(message, message.getAllRecipients());
		} finally {
			transport.close();
		}
	}

	public void SendInformationChangedEmail(User user) throws AddressException, MessagingException {

		Properties props = new Properties();
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.EnableSSL.enable", "true");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		// session.setDebug(true);

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));

		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
		message.setSubject("Bienvenido a PODIUM!");
		message.setText("Bienvenido " + user.getName() + "," + "\n\n Usted se ha registrado a PODIUM!."
				+ "\n\n En nuestra aplicacion encontrara los mejores debates de la Universidad Latina.");
		String html = "HOLA!"
				+ "\n\n Se hicieron cambios en su cuenta de PODIUM. Si no ha sido usted favor cambiar la contrasena.</a>";
		message.setContent(html, "text/html; charset=utf-8");

		Transport transport = session.getTransport("smtp");
		try {
			transport.connect("smtp.gmail.com", username, password);
			transport.sendMessage(message, message.getAllRecipients());
		} finally {
			transport.close();
		}

	}

	public void SendDebateConfirmationEmail(List<User> userList, Debate debate)
			throws AddressException, MessagingException {

		Properties props = new Properties();
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.password", password);
		props.setProperty("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.EnableSSL.enable", "true");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		// session.setDebug(true);

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
		message.setSubject("Seleccionado PODIUM!");
		for (User user : userList) {
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));

		}
		String html = "HOLA!" + "\n\n Usted ha sido seleccionado para participar en el debate " + debate.getName()
				+ "link <a href='http://debatesapp.azurewebsites.net/podiumwebapp/ws/debate/confirmeddebates?email=@gmail'>Confirmar Asistencia</a>";
		message.setContent(html, "text/html; charset=utf-8");
		/*
		 * for (String to : toList) {
		 * message.addRecipient(Message.RecipientType.TO, new
		 * InternetAddress(to)); }
		 * 
		 * message.setSubject(subject); message.setContent(htmlBody,
		 * "text/html");
		 */
		Transport transport = session.getTransport("smtp");
		try {
			transport.connect("smtp.gmail.com", username, password);
			transport.sendMessage(message, message.getAllRecipients());
		} finally {
			transport.close();
		}
	}
}
