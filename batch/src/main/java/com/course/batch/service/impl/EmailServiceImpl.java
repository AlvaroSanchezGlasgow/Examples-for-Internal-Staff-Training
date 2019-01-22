package com.course.batch.service.impl;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.course.batch.service.EmailService;

@Component
public class EmailServiceImpl implements EmailService {
  
    @Autowired
    public JavaMailSender emailSender;
 
    public void sendEmail() throws MessagingException {
     
    	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    	  mailSender.setHost("smtp.gmail.com");
  	    mailSender.setPort(587);
  	     
  	    mailSender.setUsername("exampleFro@gmail.com");
  	    mailSender.setPassword("password");
  	     
  	    Properties props = mailSender.getJavaMailProperties();
  	    props.put("mail.transport.protocol", "smtp");
  	    props.put("mail.smtp.auth", "true");
  	    props.put("mail.smtp.starttls.enable", "true");
  	    props.put("mail.debug", "true");
  	     

    	MimeMessage message = mailSender.createMimeMessage();

    	// use the true flag to indicate you need a multipart message
    	MimeMessageHelper helper = new MimeMessageHelper(message, true);
    	
    	helper.setTo("exampleTo@gmail.com");
    	helper.setSubject("Email Example");
    	// use the true flag to indicate the text included is HTML
    	helper.setText("<html><body>Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
    			+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, "
    			+ "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    			+ "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. "
    			+ "Excepteur sint occaecat cupidatat non proident,"
    			+ " sunt in culpa qui officia deserunt mollit anim id est laborum.</body></html>", true);

    	mailSender.send(message);
    }
}