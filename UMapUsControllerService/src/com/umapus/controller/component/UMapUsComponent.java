package com.umapus.controller.component;

import java.util.HashMap;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;

import com.umapus.common.domain.entity.LoginRequest;
import com.umapus.common.domain.entity.LoginResponse;
import com.umapus.common.domain.entity.SignUpRequest;
import com.umapus.common.domain.entity.SignUpResponse;
import com.umapus.common.domain.entity.UMapUsConstants;
import com.umapus.controller.domain.entity.SignUpStatus;
import com.umapus.controller.domain.util.EmailHelper;
import com.umapus.controller.domain.util.HelperTools;
import com.umapus.controller.infrastructure.dao.DAOFactory;
import com.umapus.controller.redisoperations.CacheManager;

public class UMapUsComponent {

	@Autowired
	private SignUpRequest signUpRequest;
	@Autowired
	private DAOFactory dao;
	@Autowired
	private UMapUsConstants con;

	@Autowired
	private LoginResponse loginResponse;

	@Autowired
	private CacheManager cacheManager;
	@Autowired
	private EmailHelper emailHelper;
	@Autowired
	private HelperTools helper;

	// Dummy method used for testing the approach
	// TODO: To be deleted
	public void SetSignUpFirstName(String firstName) {

		signUpRequest.setFirstName(firstName);
		System.out.println("First name in component"
				+ signUpRequest.getFirstName() + " ClassName="
				+ this.getClass());

	}

	// End of the method to be deleted

	public boolean activateAccount(String emailid, String activationCode) {
		boolean result = dao.getLdapDao().activateUser(emailid, activationCode);
		
		return result;
	}

	public SignUpResponse SignUp(SignUpRequest signUpRequest) {
		SignUpStatus signupstatus = null;

		try {
			signupstatus = dao.getLdapDao().CreateLDAPUser(signUpRequest);
			// cacheManager.addActivationLink(signUpRequest.getEmail(),
			// activationCode);

			if (signupstatus.getActivationCode() != null) {

				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("activationurl", helper.generateActivationUrl(
						signUpRequest.getEmail(),
						signupstatus.getActivationCode()));
				map.put("fname", signUpRequest.getFirstName());
				dao.getEmailManagerDao().SendEmail(signUpRequest.getEmail(),
						emailHelper.CreateSignUpEmail(map),
						"UMapUs - Sign Up Confirmation");
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
