package com.umapus.controller.infrastructure.dao;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class EmailManagerDaoImpl implements EmailManagerDao {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private SimpleMailMessage templateMessage;

	@Override
	public void SendEmail(final String receiverEmail, final String messagetext, final String subject) {
		SimpleMailMessage message = new SimpleMailMessage(this.templateMessage);
		message.setTo(receiverEmail);
		message.setText(messagetext);
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(receiverEmail);
				message.setText(messagetext, true);
				message.setSubject(subject);
			}
		};
		try {
			// mailSender.send(message);
			taskExecutor.execute(new Emailer(mailSender, preparator));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private TaskExecutor taskExecutor;

	public EmailManagerDaoImpl(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	private class Emailer implements Runnable {

		private JavaMailSender mailSender;

		private MimeMessagePreparator preparator;

		public Emailer(JavaMailSender jMailSender,
				MimeMessagePreparator preparator) {

			this.mailSender = jMailSender;
			this.preparator = preparator;

		}

		@Override
		public void run() {

			this.mailSender.send(this.preparator);
		}

	}

}
