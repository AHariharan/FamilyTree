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

	// static{
	//
	// ApplicationContext appcontext =
	// new ClassPathXmlApplicationContext
	// ("classpath:applicationcontext-umapuscontroller.xml");
	// }

//	static ApplicationContext ctx = new ClassPathXmlApplicationContext(
//			"classpath:applicationcontext-umapuscontroller.xml");
//
//    static UMapUsComponent cntlcomp = (UMapUsComponent) ctx.getBean("cntlComp");
//    

//	public UMapUsController() {
//		System.out.println("In constructor");
//
//		if (applicationContext != null) {
//			applicationContext = new AnnotationConfigApplicationContext(
//					"classpath:applicationcontext-umapuscontroller.xml");
//		}
//      
//		
//		 signUpRequest.setFirstName("Vishnu");
//			System.out.println("FirstName==" + signUpRequest.getFamilyName());
//	}

	private static ApplicationContext ctx;

	public static void main(String[] args) {
		
	    ctx = new ClassPathXmlApplicationContext(
				"classpath:applicationcontext-umapuscontroller.xml");

	     UMapUsComponent cntlcomp = (UMapUsComponent) ctx.getBean("cntlComp");
	     SignUpRequest signUpRequest = (SignUpRequest) ctx.getBean("signUpRequest");
		 LoginRequest loginRequest = (LoginRequest) ctx.getBean("loginRequest");
		 Login(cntlcomp,loginRequest);
	 
	}

	
	public static void SignUp(UMapUsComponent cntlcomp, SignUpRequest signUpRequest){
		
		cntlcomp.SetSignUpFirstName("Chari");
		signUpRequest.setEmail("t2vglvishnu@yahoo.com");
		signUpRequest.setFamilyName("Vaitiyam");
		signUpRequest.setLastName("Vaitiyam Gunasekaran");
		signUpRequest.setPassword("Test@123");
		signUpRequest.setFirstName("Vishnu");
		cntlcomp.SignUp(signUpRequest);
	}

	private static void Login(UMapUsComponent cntlcomp, LoginRequest loginRequest){
		
		loginRequest.setUserName("vglvishnu@yahoo.com");
		loginRequest.setPassWord("Test@123");
		cntlcomp.Login(loginRequest);
	}
}
