package com.umapus.controller.infrastructure.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailManagerDaoImpl implements EmailManagerDao {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private SimpleMailMessage templateMessage;

	@Override
	public void SendEmail(String receiverEmail, String messagetext) {
		SimpleMailMessage message = new SimpleMailMessage(this.templateMessage);
		message.setTo(receiverEmail);
		message.setText(messagetext);
		try {
			//mailSender.send(message);
			taskExecutor.execute(new Emailer(mailSender,message));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}
	
	private TaskExecutor taskExecutor;
	
	public  EmailManagerDaoImpl(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

	private class Emailer implements Runnable{
	
		private JavaMailSender mailSender;

		
		private SimpleMailMessage templateMessage;
		
		
		
		public Emailer (JavaMailSender jMailSender, SimpleMailMessage simpleMailMessage){
			
			this.mailSender = jMailSender;
			this.templateMessage = simpleMailMessage;
		
		}
		
		@Override
		public void run() {
			
			this.mailSender.send(this.templateMessage);
		}
		
	}

	
}
