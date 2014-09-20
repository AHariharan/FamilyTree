package com.umapus.internal.utilities;

import java.util.Collection;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;

public class UMapUSUserPropertyMapper implements UserDetailsContextMapper {

	/* The method below is for authentication so ignore Implementation */
	@Override
	public UserDetails mapUserFromContext(DirContextOperations ctx,
			String username, Collection<? extends GrantedAuthority> authorities) {
		
		String firstname = null;
		String lastname = null;
		String graphid = null;
		
		Attributes attributes = ctx.getAttributes();
        try {
        	firstname = (String) attributes.get("mail").get(); 
        	lastname = (String) attributes.get("sn").get(); 
        	graphid = (String) attributes.get("graphid").get(); 
        	
        	System.out.println( " EMail : " + firstname);
        	System.out.println( " LastName : " + lastname);
        	System.out.println( " graphid : " + graphid);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
        }
		UMapUSUserDetails userdetails = new UMapUSUserDetails(username, "", true, true, true, true, authorities, firstname, lastname, graphid);
		
		return userdetails;
	}

	@Override
	public void mapUserToContext(UserDetails arg0, DirContextAdapter arg1) {
		System.out.println("Inside MapUsertoContext" + arg0.getUsername());
		Attributes userattrs = arg1.getAttributes();
		NamingEnumeration<? extends Attribute> attrlist = userattrs.getAll();
		while(attrlist.hasMoreElements())
		{
			Attribute attr = userattrs.getAll().nextElement();
		    System.out.println("Attr : " + attr);
			
		}

	}

}
