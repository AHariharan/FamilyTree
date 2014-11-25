package com.umapus.controller.domain.util;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Set;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class EmailHelper {

	private  VelocityEngine velocityEngine;
	
	@Autowired
	public EmailHelper(VelocityEngine velocityEngine){
		this.velocityEngine = velocityEngine;	
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		velocityEngine.init();
	}
	
	public String CreateSignUpEmail(HashMap<String,Object> varMap){
		
		
		System.out.println("Velocity Resource path " + velocityEngine.getTemplate("SignUpEmail.vm"));
		
		VelocityContext context = new VelocityContext();
		for(String key : varMap.keySet())
		{
			context.put(key, varMap.get(key));
		}
	
		StringWriter writer = new StringWriter();
		
		velocityEngine.mergeTemplate("SignUpEmail.vm", "UTF-8", context, writer);
		
		/*String body = VelocityEngineUtils.
				mergeTemplateIntoString
				(velocityEngine, 
				 "/SignUpEmail.vm","UTF-8",varMap);*/
		
		return writer.toString();
	}
}
