package com.umapus.controller.infrastructure.dao;


import javax.naming.NamingException;

import com.umapus.common.domain.entity.LoginRequest;
import com.umapus.common.domain.entity.LoginResponse;
import com.umapus.common.domain.entity.SignUpRequest;
import com.umapus.common.domain.entity.SignUpResponse;


public interface LdapDao {

	
	public String CreateLDAPUser(SignUpRequest signUpRequest) throws NamingException;
	public LoginResponse AuthenticateUser(LoginRequest loginRequest) throws NamingException;
	
}
