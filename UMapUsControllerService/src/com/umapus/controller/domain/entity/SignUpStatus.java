package com.umapus.controller.domain.entity;

import com.umapus.common.domain.entity.SignUpResponse;

public class SignUpStatus{

	private SignUpResponse signupresponse;
	private String activationCode;
	
	public SignUpStatus(SignUpResponse signupresponse, String activationCode ){
		
		this.signupresponse = signupresponse;
		this.activationCode = activationCode;
	}
	
	public SignUpResponse getSignupresponse() {
		return signupresponse;
	}
	public void setSignupresponse(SignUpResponse signupresponse) {
		this.signupresponse = signupresponse;
	}
	
	
	
	public String getActivationCode() {
		return activationCode;
	}
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	


}
