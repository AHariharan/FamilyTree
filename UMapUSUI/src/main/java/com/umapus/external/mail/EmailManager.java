package com.umapus.external.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailManager {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private SimpleMailMessage templateMessage;

	private String emailReceiver;
	
	public EmailManager() {
		super();
		
	}
	
	
	
	public String getEmailReceiver() {
		return emailReceiver;
	}



	public void setEmailReceiver(String emailReceiver) {
		this.emailReceiver = emailReceiver;
	}



	public void sendSignUpConfirmation()
	{
		SimpleMailMessage message = new SimpleMailMessage(this.templateMessage);
		message.setTo(getEmailReceiver());
		message.setText("Thank you for Signing up @ UMapUS" );
		try
		{
			this.mailSender.send(message);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
}
