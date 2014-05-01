package com.umapus.controller.infrastructure.dao;


import javax.naming.NamingException;

import com.umapus.common.domain.entity.LoginRequest;
import com.umapus.common.domain.entity.LoginResponse;
import com.umapus.common.domain.entity.SignUpRequest;


public interface LdapDao {

	public LoginResponse bindUser(LoginRequest loginRequest);
	
}
