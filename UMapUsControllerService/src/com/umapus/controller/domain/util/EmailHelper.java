package com.umapus.controller.domain.util;

import java.util.HashMap;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class EmailHelper {

	private  VelocityEngine velocityEngine;
	
	@Autowired
	public EmailHelper(VelocityEngine velocityEngine){
		this.velocityEngine = velocityEngine;	
	}
	
	public String CreateSignUpEmail(HashMap<String,Object> varMap){
		
		String body = VelocityEngineUtils.
				mergeTemplateIntoString
				(velocityEngine, 
				 "/SignUpEmail.vm","UTF-8",varMap);
		
		return body;
	}
}
