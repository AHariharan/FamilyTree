package com.umapus.internal.utilities;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UMapUSUserDetails extends User {


	private static final long serialVersionUID = -7886128638480822430L;

	private String firstName;
	private String lastName;
	private String graphId;
	

	
	public UMapUSUserDetails(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,String firstName,String lastName,String graphId) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);		
		this.firstName = firstName;
		this.lastName = lastName;
		this.graphId = graphId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGraphId() {
		return graphId;
	}

	

}
