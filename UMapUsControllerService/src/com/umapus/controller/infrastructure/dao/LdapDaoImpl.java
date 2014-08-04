package com.umapus.controller.infrastructure.dao;

import java.util.UUID;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;

import com.umapus.common.domain.entity.SignUpRequest;
import com.umapus.common.domain.entity.SignUpResponse;
import com.umapus.common.domain.entity.UMapUsConstants;



public class LdapDaoImpl implements LdapDao {
	private LdapTemplate ldapTemplate;
	
	@Autowired
	private UMapUsConstants umapsusConstants;
	
	@Autowired
	private SignUpResponse signUpResponse;
   
	public void setLdapTemplate(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }
	
	public String CreateLDAPUser(SignUpRequest signuprequest) throws NamingException{
		
		DirContext ldapCtx            = getDirContext(UMapUsConstants.LDAP_JNDI);

		NamingEnumeration<SearchResult> result = findLDAPUserByUserId(ldapCtx,UMapUsConstants.LDAPSEARCHBASE,signuprequest.getEmail());

		if(result.hasMoreElements()) {
			System.out.println("User already exists");
			return signUpResponse.ALREADY_EXISTS.getStatus();
		}


		/*while (result.hasMore()){
    	    	  SearchResult sr = (SearchResult) result.next();  
                  System.out.println(sr.toString()+"\n");  

    	      }*/
		String assign_GraphId         = UUID.randomUUID().toString();

		String entryDN                = "uid="+signuprequest.getEmail()+","+UMapUsConstants.LDAPSEARCHBASE; 
		Attribute cn                  = new BasicAttribute(UMapUsConstants.CN, signuprequest.getEmail());  
		Attribute sn                  = new BasicAttribute(UMapUsConstants.SN, signuprequest.getFamilyName());  
		Attribute uid                 = new BasicAttribute(UMapUsConstants.UID, signuprequest.getEmail());  
		Attribute mail                = new BasicAttribute(UMapUsConstants.MAIL, signuprequest.getEmail());    
		Attribute userPassword        = new BasicAttribute(UMapUsConstants.USERPASSWORD, signuprequest.getPassWord());  
		Attribute graphid             = new BasicAttribute(UMapUsConstants.GRAPHID, assign_GraphId);  
		Attribute oc                  = new BasicAttribute(UMapUsConstants.OBJECTCLASS);

		oc.add(UMapUsConstants.TOP);  
		oc.add(UMapUsConstants.PERSON);  
		oc.add(UMapUsConstants.ORGANIZATIONALPERSON);  
		oc.add(UMapUsConstants.INETORGPERSON); 
		oc.add(UMapUsConstants.UMAPUSMEMBERS); 

		BasicAttributes entry         = new BasicAttributes();  
		entry.put(cn);  
		entry.put(sn);  
		entry.put(mail);  
		entry.put(uid); 
		entry.put(userPassword);
		entry.put(graphid);
		entry.put(oc);

		try {
			ldapCtx.createSubcontext(entryDN, entry);
		} catch (NamingException e) {
			//TODO add log statement
			return signUpResponse.FAILED.getStatus();
		} 

		return signUpResponse.SUCCESS.getStatus();
		
		//return null;
	}
	
	private DirContext getDirContext(String jndiName) throws NamingException{
		Context initCtx                = null;
		initCtx                        = new InitialContext();
		Context envCtx                 = (Context) initCtx.lookup(umapsusConstants.ENV);
		DirContext ldapCtx             = (DirContext) envCtx.lookup(umapsusConstants.LDAP_JNDI);
		return ldapCtx;
	}
	
	
	private NamingEnumeration<SearchResult> findLDAPUserByUserId(DirContext ctx, String ldapSearchBase, String userId) throws NamingException {

		String searchFilter                     = "(&(" 
		                                          +UMapUsConstants.OBJECTCLASS 
		                                          + "=" + 
		                                          UMapUsConstants.UMAPUSMEMBERS
		                                          + ")(" +
		                                          UMapUsConstants.UID 
		                                          +"=" 
		                                          + userId 
		                                          + "))";

		SearchControls searchControls           = new SearchControls();
		searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);

		NamingEnumeration<SearchResult> results = ctx.search(ldapSearchBase, searchFilter, searchControls);

		return results;
	}
}
