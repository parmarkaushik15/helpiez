package com.kaushik.helpiez.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Repository;

import com.kaushik.helpiez.webservice.controller.WebServiceController;

@Repository
public class MailUtility {

	private static final Logger LOGGER = LoggerFactory.getLogger(MailUtility.class);
	
	@Autowired
	private  MailSender mailSender;
	
	public  boolean mailSend(String to, String title, String body)
	{
		try
		{
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("kaushikparmar123456@gmail.com");
			message.setTo(to);
			message.setSubject(title);
			message.setText(body);
			mailSender.send(message);
			
			return true;
		}
		catch(Exception ex)
		{
			LOGGER.error("Exception :",ex);
			return false;
		}
	}
	
}
