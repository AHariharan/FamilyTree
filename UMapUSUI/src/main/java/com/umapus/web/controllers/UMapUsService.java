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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.umapus.common.domain.entity.LoginRequest;
import com.umapus.common.domain.entity.LoginResponse;
import com.umapus.common.domain.entity.SignUpRequest;
import com.umapus.common.domain.entity.User;
import com.umapus.controller.component.UMapUsComponent;
import com.umapus.internal.utilities.TestPojo;
import com.umapus.internal.utilities.UMapUSUserDetails;


@Controller
//@Path("umapusservice")
//@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class UMapUsService {


	@Autowired
	private User user;
	
	@Autowired
	private UMapUsComponent component;
	


	@RequestMapping(value = { "/login"},method = RequestMethod.POST)
	public String Login(@ModelAttribute("loginrequest") LoginRequest loginrequest,ModelMap model,HttpServletRequest request)
			throws Exception {

		System.out.println("Session is : " + request.getSession().getId());
		System.out.println("Login request username :- " + loginrequest.getuserName());
		System.out.println("Login request password :- " + loginrequest.getPassWord());
		if(loginrequest != null)
		           model.addAttribute("message",loginrequest.getuserName());
		           
		try
		{
		LoginResponse response = component.Login(loginrequest);
		if(response !=  null)
			return "UMapUSWork";
	    else
		    return "LoginFailure";
		}catch(Exception e)
		{
			e.printStackTrace();
			return "LoginFailure";
		}
		
	}

	
	// Don't comment this method I am using this as a stub for direct access to fix html and js
	@RequestMapping(value = { "/UMapUSWork"},method = RequestMethod.GET)
	public String myStubDontDelete(ModelMap model,HttpServletRequest request)
	{
	    System.out.println("Request" + request.getSession().getAttribute("UMapUSUserDetails").getClass());	
	    TestPojo testdata = (TestPojo) request.getSession().getAttribute("UMapUSUserDetails");
	 	model.addAttribute("message",testdata.getEmail() + " :: " + testdata.getLastname());
		return "UMapUSWork";
	}
	
	@RequestMapping(value = {"/logout_sucess"},method = RequestMethod.GET)
	public ModelAndView logout(ModelMap model)
	{
		System.out.println("Logout invoked for user" + SecurityContextHolder.getContext().getAuthentication().getPrincipal());		
		SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
	
		return new ModelAndView("redirect:/");
	
	}
	
	
	@POST
	@RequestMapping(value = { "/signup"},method = RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody Object SignUp(@RequestBody SignUpRequest signUpRequest , HttpServletRequest request) {
		System.out.println("Session is : " + request.getSession().getId());
        System.out.println("Sign up request getFamilyName :" + signUpRequest.getFamilyName());
        System.out.println("Sign up request getFirstName :" + signUpRequest.getFirstName());
        System.out.println("Sign up request getLastName :" + signUpRequest.getLastName());
        System.out.println("Sign up request getEmail :" + signUpRequest.getEmail());
        System.out.println("Sign up request getPassWord :" + signUpRequest.getPassword());
		component.SetSignUpFirstName(signUpRequest.getFirstName());
		try
		{
		   component.SignUp(signUpRequest);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return "Success";
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
