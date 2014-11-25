package com.umapus.controller.infrastructure.dao;

public interface EmailManagerDao {

	
	public void SendEmail(String receiverEmail, String messagetext,String subject);
}
