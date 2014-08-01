package com.umapus.controller.component;

import org.springframework.beans.factory.annotation.Autowired;

import com.umapus.common.domain.entity.LoginRequest;
import com.umapus.common.domain.entity.LoginResponse;
import com.umapus.common.domain.entity.SignUpRequest;
import com.umapus.common.domain.entity.SignUpResponse;

public class UMapUsComponent {

	@Autowired
	private  SignUpRequest signUpRequest;
	
	//Dummy method used for testing the approach
	//TODO: To be deleted
	public void SetSignUpFirstName(String firstName){
		  
		signUpRequest.setFirstName(firstName);
		System.out.println("First name in component" + 
		     signUpRequest.getFirstName() + " ClassName=" + this.getClass());
	   
	}
	//End of the method to be deleted
	
	public LoginResponse Login (LoginRequest loginRequest) {
		
		return null;
	}
	
	public SignUpResponse SignUp(SignUpRequest signUpRequest){
		
		return null;
	}
	
}
