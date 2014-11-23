package com.umapus.controller.infrastructure.dao;

public class DAOFactory {

	private LdapDao ldapDao;
	private SessionRepositoryDao sessionRepositoryDao;
	private EmailManagerDao emailManagerDao;

	public void setLdapDao(LdapDao ldapDao) {
		this.ldapDao = ldapDao;
	}
	
	public  LdapDao getLdapDao(){
		return  this.ldapDao;
	}
	
	public void setSessionRepositoryDao(SessionRepositoryDao sessionRepositoryDao) {
		this.sessionRepositoryDao = sessionRepositoryDao;
	}
	
	public  SessionRepositoryDao getSessionRepositoryDao(){
		return  this.sessionRepositoryDao;
	}

	public EmailManagerDao getEmailManagerDao() {
		return emailManagerDao;
	}

	public void setEmailManagerDao(EmailManagerDao emailManagerDao) {
		this.emailManagerDao = emailManagerDao;
	}
	
}
