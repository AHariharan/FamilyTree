package com.umapus.internal.utilities;

public class TestPojo {

	private String firstname;
	private String lastname;
	private String email;
	private String graphid;
	
	
	
	public TestPojo() {
		super();
		
	}
	
	public TestPojo(String firstname, String lastname, String email,
			String graphid) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.graphid = graphid;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGraphid() {
		return graphid;
	}
	public void setGraphid(String graphid) {
		this.graphid = graphid;
	}
	
	
	
}
