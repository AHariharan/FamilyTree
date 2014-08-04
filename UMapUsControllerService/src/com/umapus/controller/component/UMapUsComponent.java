package com.umapus.controller.component;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;

import com.umapus.common.domain.entity.LoginRequest;
import com.umapus.common.domain.entity.LoginResponse;
import com.umapus.common.domain.entity.SignUpRequest;
import com.umapus.common.domain.entity.SignUpResponse;
import com.umapus.controller.infrastructure.dao.DAOFactory;

public class UMapUsComponent {

	@Autowired
	private  SignUpRequest signUpRequest;
	@Autowired
	private DAOFactory dao;
	
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
		
		try {
			String status = dao.getLdapDao().CreateLDAPUser(signUpRequest);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return null;
	}
	
}
