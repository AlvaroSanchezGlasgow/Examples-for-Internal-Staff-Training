package com.course.batch.service;

import javax.mail.MessagingException;

public interface EmailService {

	void sendEmail() throws MessagingException;

}
