package com.umapus.web.controllers;

import java.util.ArrayList;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.umapus.common.domain.refdata.FamilyName;

@Controller
//@Path("UMapUSRef")
//@Produces({ MediaType.APPLICATION_JSON })
public class UMapUSRefData {

	
	
	@RequestMapping(value = { "/listoffamilies"},method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody FamilyName[] getListofFamilyNames()
	{
		ArrayList<FamilyName> familylist = new ArrayList<FamilyName>();
		FamilyName name = new FamilyName("Nattamai","Kholin");
		FamilyName name1 = new FamilyName("Solai","Solai");
		familylist.add(name);familylist.add(name1);
		FamilyName[] list = new FamilyName[familylist.size()];
		for(int i=0;i<familylist.size();i++)
			 list[i] = familylist.get(i);
		
		System.out.println("Get List invoked");
		return list;
	}
	
}
