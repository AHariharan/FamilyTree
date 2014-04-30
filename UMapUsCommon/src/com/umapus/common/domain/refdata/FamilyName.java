package com.umapus.common.domain.refdata;

public class FamilyName {

	private String familyName;
	
	private String aliasName;
	
	public FamilyName(String name,String alias)
	{
		familyName = name;
		aliasName = alias;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	
	
}
