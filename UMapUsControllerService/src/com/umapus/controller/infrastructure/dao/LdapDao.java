package com.umapus.controller.infrastructure.dao;


import java.util.List;

import javax.naming.NamingException;

import com.umapus.common.domain.entity.LDAPUser;
import com.umapus.common.domain.entity.LoginRequest;
import com.umapus.common.domain.entity.LoginResponse;
import com.umapus.common.domain.entity.SignUpRequest;
import com.umapus.controller.domain.entity.SignUpStatus;


public interface LdapDao {

	
	public SignUpStatus CreateLDAPUser(SignUpRequest signUpRequest) throws NamingException;
	public boolean activateUser(String uid, String activationCode);
	public  LDAPUser findUserByUserId(String userId);
}
