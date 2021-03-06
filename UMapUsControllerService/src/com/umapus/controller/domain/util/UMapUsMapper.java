package com.umapus.controller.domain.util;

import java.security.MessageDigest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.ldap.core.DirContextAdapter;

import com.umapus.common.domain.entity.LoginResponse;
import com.umapus.common.domain.entity.UMapUsConstants;
import com.umapus.common.domain.entity.User;

public class UMapUsMapper {

  
	
	
	


	public LoginResponse MapLDAPAttributeToLoginResponse(DirContextAdapter dc, boolean isLoggedIn ) {
		
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setEmailId(dc.getStringAttribute(UMapUsConstants.MAIL));
		loginResponse.setGraphId(dc.getStringAttribute(UMapUsConstants.GRAPHID));
		loginResponse.setSurname(dc.getStringAttribute(UMapUsConstants.SN));
		loginResponse.setLoggedin(isLoggedIn);
		
		return loginResponse;
	}
	
//	public LoginRequest MapJsonToLoginRequest(String jsonLoginRequest) throws JSONException{
//	  
//	   JSONObject ojson = (JSONObject) new JSONTokener(jsonLoginRequest).nextValue();
//	   loginRequest.setUserName(ojson.getString(UMapUsConstants.JsEMAIL));
//	   loginRequest.setPassWord(ojson.getString(UMapUsConstants.JsPASSWD));
//	   return loginRequest;
//	   
//   }
//   
//   public SignUpRequest MapJsonToSignupRequest(String jsonSignUpRequest) throws JSONException{
//	   
//	
//	    JSONObject ojson = (JSONObject) new JSONTokener(jsonSignUpRequest).nextValue();
//	    
//	    signUpRequest.setEmail(ojson.getString(UMapUsConstants.JsEMAIL));
//	    signUpRequest.setFamilyName(ojson.getString(UMapUsConstants.JsFAMILYNAME));
//	    signUpRequest.setFirstName(ojson.getString(UMapUsConstants.JsFAMILYNAME));
//	    signUpRequest.setLastName(ojson.getString(UMapUsConstants.JsLASTNAME));
//	    signUpRequest.setPassWord(ojson.getString(UMapUsConstants.JsPASSWD));
//	    
//	   return signUpRequest;
//   }
//   
//   public User MapDNAttributesToUser(Attributes dnAttributes) throws NamingException{
//	   
//	    //user.setEmailId(dnAttributes.get(UMapUsConstants.UID).toString());	
//	    user.setEmailId(dnAttributes.get(UMapUsConstants.UID).get().toString());	
//	    //dnAttributes.get(UMapUsConstants.UID).get().toString();
//	    user.setGraphId(dnAttributes.get(UMapUsConstants.GRAPHID).get().toString());
//	    user.setSurname(dnAttributes.get(UMapUsConstants.SN).get().toString());
//	    user.setLoggedin(true);
//	   
//	   return user;
//   }
//   
   
   
   public JSONObject MakeUserToJsonLoginResponse(User user) throws JSONException{
	   JSONObject ojson = new JSONObject();
	   if (user.isLoggedin()){
	   ojson.put("status","IN");
	   } else {
		   ojson.put("status","OUT");
	   }
	   
	   return ojson;
   }
   
   public JSONObject MakeSignUpStatusToJson(String signupstatus) throws JSONException{
	   JSONObject ojson = new JSONObject();
	   ojson.put("status", signupstatus);
	   return ojson;
	   
   } 
   
   
}
