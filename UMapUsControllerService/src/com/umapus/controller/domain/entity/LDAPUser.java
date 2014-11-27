package com.umapus.controller.domain.entity;

public class LDAPUser {

	private String graphid;
	private String mail;
	private String sn;
	private String uid;
	private String activationCode;
	private String isuseractive;
	
	public String getGraphid() {
		return graphid;
	}
	public void setGraphid(String graphid) {
		this.graphid = graphid;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getActivationCode() {
		return activationCode;
	}
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	public String getIsuseractive() {
		return isuseractive;
	}
	public void setIsuseractive(String isuseractive) {
		this.isuseractive = isuseractive;
	}
	
}
