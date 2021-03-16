package com.mailService.javakafka.kafkajava.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mailService.javakafka.kafkajava.entity.Users;


@Service
public class MailService {

	@Autowired
	private UserService service;
	@PostConstruct
	public void sendEmail(String mail) throws Exception {
		List<Users> listaUsuarios = new ArrayList<>();
		listaUsuarios = service.findAll();
		Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");

	    Session session = Session.getDefaultInstance(props,
	      new javax.mail.Authenticator() {
	           protected PasswordAuthentication getPasswordAuthentication()
	           {
	                 return new PasswordAuthentication("",
	                 "");
	           }
	      });

	    try {

	      Message message = new MimeMessage(session);
	      message.setFrom(new InternetAddress(""));
	      Address[] toUser = null;
	      for (Users users : listaUsuarios) {
	    	  toUser = InternetAddress.parse(users.getEmail());
	      }

	      message.setRecipients(Message.RecipientType.TO, toUser);
	      message.setSubject("Email enviado aos usuários admin");
	      message.setText("Mensagem enviado do kafka app" + mail);
	      Transport.send(message);

	     } catch (MessagingException e) {
	        throw new RuntimeException(e);
	    }
	}
}
