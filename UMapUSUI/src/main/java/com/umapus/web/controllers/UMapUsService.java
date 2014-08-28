package com.umapus.web.controllers;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.umapus.common.domain.entity.LoginRequest;
import com.umapus.common.domain.entity.LoginResponse;

import com.umapus.common.domain.entity.User;
import com.umapus.controller.component.UMapUsComponent;


@Controller
//@Path("umapusservice")
//@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class UMapUsService {


	@Autowired
	private User user;
	
	@Autowired
	private UMapUsComponent component;
	


	@RequestMapping(value = { "/login"},method = RequestMethod.POST)
	public String Login(@ModelAttribute("loginrequest") LoginRequest loginrequest,ModelMap model)
			throws Exception {

		
		System.out.println("Login request username :- " + loginrequest.getuserName());
		System.out.println("Login request password :- " + loginrequest.getPassWord());
		if(loginrequest != null)
		           model.addAttribute("message",loginrequest.getuserName());
		           
		LoginResponse response = component.Login(loginrequest);
		if(response !=  null)
				return "UMapUSWork";
		else
			return "";
	}

	
	// Don't comment this method I am using this as a stub for direct access to fix html and js
	@RequestMapping(value = { "/UMapUSWork"},method = RequestMethod.GET)
	public String myStubDontDelete(ModelMap model)
	{
		model.addAttribute("message","Arunkumar Hariharan");
		return "UMapUSWork";
	}
	
	
	
	@POST
	@Path("/signup")
	@Produces(MediaType.APPLICATION_JSON)
	public String SignUp(String jsonBody, @Context HttpServletRequest req) {

		return null;
	}

	/*private HttpSession createSession(HttpServletRequest req,
			HashMap<String, String> attributesmap) {

		HttpSession session = req.getSession(true);

		session.setMaxInactiveInterval(UMapUsConstants.SessionMaxInActiveTimeinSec);
//		for (Map.Entry<String, String> entry : attributesmap.entrySet()) {
//			session.setAttribute(entry.getKey(), entry.getValue());
//		}
	   addSessionToRepository(session.getId(),
				attributesmap);
		
		return session;
	}*/

	/*private void addSessionToRepository(String sessionId,
			HashMap<String, String> hv) {

		 daoFactory.getSessionRepoDao().AddToRedis(
				"Session:"+sessionId, hv);
		
	}*/

	private NewCookie createCookie(HttpSession session) {

		return new NewCookie("id", session.getId());
	}

	/*private User LoginUser(LoginRequest loginRequest, HttpServletRequest req)
			throws NamingException {

		user = daoFactory.getLdapDao().LoginUser(loginRequest);
		return user;

	}*/

}
