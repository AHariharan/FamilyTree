package com.umapus.controller.infrastructure.dao;

import java.util.List;
import java.util.UUID;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.filter.Filter;
import org.springframework.ldap.query.LdapQuery;

import com.umapus.common.domain.entity.LoginRequest;
import com.umapus.common.domain.entity.LoginResponse;
import com.umapus.common.domain.entity.SignUpRequest;
import com.umapus.common.domain.entity.SignUpResponse;
import com.umapus.common.domain.entity.UMapUsConstants;

public class LdapDaoImpl implements LdapDao {
	private LdapTemplate ldapTemplate;

	@Autowired
	private UMapUsConstants umapsusConstants;

	@Autowired
	private SignUpResponse signUpResponse;
	
	@Autowired
	private LoginResponse loginResponse;

	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

	public String CreateLDAPUser(SignUpRequest signUpRequest)
			 {
        
         
		List userList = this.findUserByUserId(signUpRequest.getEmail());
		// DirContext ldapCtx = getDirContext(umapsusConstants.LDAP_JNDI);
        
		if (userList.size() != 0 )
		{
			System.out.println("User already exist");
			return signUpResponse.ALREADY_EXISTS.getStatus();
		}

		String assign_GraphId = UUID.randomUUID().toString();

		String entryDN = "uid=" + signUpRequest.getEmail() ;
				
		Attribute cn = new BasicAttribute(UMapUsConstants.CN,
				signUpRequest.getEmail());
		Attribute sn = new BasicAttribute(UMapUsConstants.SN,
				signUpRequest.getFamilyName());
		Attribute uid = new BasicAttribute(UMapUsConstants.UID,
				signUpRequest.getEmail());
		Attribute mail = new BasicAttribute(UMapUsConstants.MAIL,
				signUpRequest.getEmail());
		Attribute userPassword = new BasicAttribute(
				UMapUsConstants.USERPASSWORD, signUpRequest.getPassWord());
		Attribute graphid = new BasicAttribute(UMapUsConstants.GRAPHID,
				assign_GraphId);
		Attribute oc = new BasicAttribute(UMapUsConstants.OBJECTCLASS);

		oc.add(UMapUsConstants.TOP);
		oc.add(UMapUsConstants.PERSON);
		oc.add(UMapUsConstants.ORGANIZATIONALPERSON);
		oc.add(UMapUsConstants.INETORGPERSON);
		oc.add(UMapUsConstants.UMAPUSMEMBERS);

		BasicAttributes attributes = new BasicAttributes();
		attributes.put(cn);
		attributes.put(sn);
		attributes.put(mail);
		attributes.put(uid);
		attributes.put(userPassword);
		attributes.put(graphid);
		attributes.put(oc);

		//ldapCtx.createSubcontext(entryDN, entry);
		  ldapTemplate.bind(entryDN,null,attributes);

		return signUpResponse.SUCCESS.getStatus();

		// return null;
	}

//	private DirContext getDirContext(String jndiName) throws NamingException {
//		Context initCtx = null;
//		initCtx = new InitialContext();
//		Context envCtx = (Context) initCtx.lookup(umapsusConstants.ENV);
//		DirContext ldapCtx = (DirContext) envCtx
//				.lookup(umapsusConstants.LDAP_JNDI);
//		return ldapCtx;
//	}
//
//	private NamingEnumeration<SearchResult> findLDAPUserByUserId(
//			DirContext ctx, String ldapSearchBase, String userId)
//			throws NamingException {
//
//		String searchFilter = "(&(" + UMapUsConstants.OBJECTCLASS + "="
//				+ UMapUsConstants.UMAPUSMEMBERS + ")(" + UMapUsConstants.UID
//				+ "=" + userId + "))";
//
//		SearchControls searchControls = new SearchControls();
//		searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
//
//		NamingEnumeration<SearchResult> results = ctx.search(ldapSearchBase,
//				searchFilter, searchControls);
//
//		return results;
//	}

	private List findUserByUserId(String userId) {

		
		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter(UMapUsConstants.OBJECTCLASS,
				UMapUsConstants.UMAPUSMEMBERS));
		filter.and(new EqualsFilter(UMapUsConstants.UID, userId));
		return ldapTemplate.search("", filter.encode(), new AttributesMapper() {
			public Object mapFromAttributes(Attributes attrs)
					throws NamingException {
				return attrs.get("uid").get();
			}

		});
	}

	public LoginResponse AuthenticateUser(LoginRequest loginRequest) throws NamingException {
		loginResponse.setLoggedin(this.AuthenticateLDAPUser(loginRequest));
		
		
		return null;
	}
	private boolean AuthenticateLDAPUser(LoginRequest loginRequest) throws NamingException {
		Filter f = new EqualsFilter("uid", loginRequest.getuserName());
		boolean isLoggedin = ldapTemplate.authenticate("", f.toString(), 
				loginRequest.getPassWord());
		
		return isLoggedin;
	}
	private boolean lookupUserAttributesByUserId(String userId) {

//		Object obj = ldapTemplate.lookup(UMapUsConstants.UID + "=" + userId
//				+ "," + UMapUsConstants.LDAPSEARCHBASE);
		String[] attributes = {UMapUsConstants.SN,UMapUsConstants.GN,UMapUsConstants.GRAPHID};
		Object obj = ldapTemplate.lookup(UMapUsConstants.UID+"=" + userId);
		
	
		
		return true;
	}

}
