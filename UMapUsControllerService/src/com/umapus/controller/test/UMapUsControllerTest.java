package com.umapus.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import scala.annotation.meta.companionClass;

import com.umapus.common.domain.entity.LoginRequest;
import com.umapus.common.domain.entity.SignUpRequest;
import com.umapus.controller.component.UMapUsComponent;
// This class is a testonly class
//I will change it to a junit or remove it

public class UMapUsControllerTest {


	private static ApplicationContext ctx;

	public static void main(String[] args) {
		
	    ctx = new ClassPathXmlApplicationContext(
				"classpath:applicationcontext-umapuscontroller.xml");

	     UMapUsComponent cntlcomp = (UMapUsComponent) ctx.getBean("cntlComp");
	     SignUpRequest signUpRequest = (SignUpRequest) ctx.getBean("signUpRequest");
		 LoginRequest loginRequest = (LoginRequest) ctx.getBean("loginRequest");
		 //Login(cntlcomp,loginRequest);
	     //SignUp(cntlcomp, signUpRequest);
	     Activate(cntlcomp,"vglvishnu@gmail.com","f26b4a50377900094ca373253252643e");
		 
	}

	
	public static void SignUp(UMapUsComponent cntlcomp, SignUpRequest signUpRequest){
		
		cntlcomp.SetSignUpFirstName("Chari");
		signUpRequest.setEmail("vglvishnu@gmail.com");
		signUpRequest.setFamilyName("Vaitiyam");
		signUpRequest.setLastName("VG");
		signUpRequest.setPassword("test123");
		signUpRequest.setFirstName("Chari");
		cntlcomp.SignUp(signUpRequest);
	}

	
public static void Activate(UMapUsComponent cntlcomp, String emailid, String activationCode){
		
		
		System.out.println("Activated = " +cntlcomp.activateAccount(emailid, activationCode));
	}
	
}
