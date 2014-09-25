package com.umapus.internal.utilities;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class UMapUSLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest req,
			HttpServletResponse response, Authentication auth) throws IOException,
			ServletException {
		    System.out.println("Logout invoked for  : "+ auth.getPrincipal());
		    if(auth == null)
		    {
		    	System.out.println("Authentication object null");
		    	super.onLogoutSuccess(req, response, auth);
		    	return;
		    }	
		    System.out.println("Logout invoked for  : "+ auth.getPrincipal());
		    response.sendRedirect("");
		    super.onLogoutSuccess(req, response, auth);
		  

	}

}
