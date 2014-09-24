package com.umapus.internal.utilities;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class UMapUSAuthSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req,
			HttpServletResponse resp, Authentication authenticationObject) throws IOException,
			ServletException {
               
		      
		
		     UMapUSUserDetails userdetails =  (UMapUSUserDetails)authenticationObject.getPrincipal();
		     if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UMapUSUserDetails)
		     {
		    	 UMapUSUserDetails details = (UMapUSUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    	 System.out.println("detailsEmail: " + details.getFirstName());
			     System.out.println("detailsLast Name: " + details.getLastName());
			     System.out.println("detailsgraphid : " + details.getGraphId());	
		     }
		     
		     for(Cookie cookie : req.getCookies())
		     {
		    	 System.out.println("CookieName : " +  cookie.getName());
		    	 System.out.println("Cookievalue : " +  cookie.getValue());
		    	 System.out.println("CookieAge : " +  cookie.getMaxAge());
		     }
		     System.out.println(" Secutiry Context: - " + SecurityContextHolder.getContext().getAuthentication().getPrincipal().getClass());
		     
		     System.out.println("Email: " + userdetails.getFirstName());
		     System.out.println("Last Name: " + userdetails.getLastName());
		     System.out.println("graphid : " + userdetails.getGraphId());	
		     Cookie sessioncookie = new Cookie("SID", "Test123");
		     sessioncookie.setMaxAge(-1);
		     
		     resp.addCookie(new Cookie("SID", "Test123"));
		     resp.setHeader("pragma", "no-cache");              
		     resp.setHeader("Cache-control", "no-cache, no-store, must-revalidate");             
		     resp.setHeader("Expires", "0"); 
		     resp.sendRedirect("/UMapUSUI/UMapUSWork?LastName="+userdetails.getLastName()+"&Email="+userdetails.getFirstName());

		     
	}
	
	

}
