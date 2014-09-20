package com.umapus.internal.utilities;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class UMapUSAuthSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req,
			HttpServletResponse resp, Authentication authenticationObject) throws IOException,
			ServletException {
               
		     UMapUSUserDetails userdetails =  (UMapUSUserDetails)authenticationObject.getPrincipal();
		     
		     System.out.println("Email: " + userdetails.getFirstName());
		     System.out.println("Last Name: " + userdetails.getLastName());
		     System.out.println("graphid : " + userdetails.getGraphId());		   
		     resp.sendRedirect("/UMapUSUI/UMapUSWork?LastName="+userdetails.getLastName()+"&Email="+userdetails.getFirstName());

	}

}
