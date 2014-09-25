package com.umapus.internal.utilities;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.DefaultCsrfToken;

public class UMapUSAuthSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest req,
			HttpServletResponse resp, Authentication authenticationObject) throws IOException,
			ServletException {
		
		
		     DefaultCsrfToken ctoken = (DefaultCsrfToken) req.getAttribute("_csrf");
		     System.out.println("CSRF Token : - " + ctoken.getToken());
		   
               
		     //req.getHeader(name) 
		
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
		     
		    
		     
		     resp.setHeader("pragma", "no-cache");              
		     resp.setHeader("Cache-control", "no-cache, no-store, must-revalidate");    
		     resp.setHeader("X-CSRF-HEADER", ctoken.getHeaderName());
		     resp.setHeader("X-CSRF-PARAM", ctoken.getParameterName());
		     resp.setHeader("X-CSRF-TOKEN", ctoken.getToken());
		    // resp.setHeader("Expires", "0"); 
		     
		     String targetURL = "/UMapUSWork";
		     
		     HttpSession session = req.getSession(false);
		   //save message in session
		    TestPojo testpojo = new TestPojo();
		    testpojo.setEmail(userdetails.getFirstName());
		    testpojo.setLastname(userdetails.getLastName());
		    testpojo.setGraphid(userdetails.getGraphId());
		     
		    
		    
		   session.setAttribute("UMapUSUserDetails", testpojo);		
		   redirectStrategy.sendRedirect(req,resp,targetURL);
		     
		    
		    // resp.sendRedirect("/UMapUSUI/UMapUSWork?LastName="+userdetails.getLastName()+"&Email="+userdetails.getFirstName());

		     
	}
	
	

}
