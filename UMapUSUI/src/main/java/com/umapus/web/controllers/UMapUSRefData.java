package com.umapus.web.controllers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

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
		String familyname = null;
		String aliasname = null;
		ArrayList<FamilyName> familylist = new ArrayList<FamilyName>();
		ArrayList<String> namelist = readFamilyNameConfigfile();
		for(int i=0;i<namelist.size();i++)
		{
			 
			if(namelist.get(i) != null)
			if(namelist.get(i).contains(","))
			{
				familyname = namelist.get(i).split(",")[0];
				aliasname = namelist.get(i).split(",")[1];
			}
			else
			{
				familyname = namelist.get(i);
				aliasname =null;
			}
			FamilyName name = new FamilyName(familyname,aliasname);
			familylist.add(name);
		}
		
		FamilyName[] list = new FamilyName[familylist.size()];
		for(int i=0;i<familylist.size();i++)
			 list[i] = familylist.get(i);
		
		System.out.println("Get List invoked");
		return list;
	}
	
	private ArrayList<String> readFamilyNameConfigfile()
	{
      
	  ArrayList<String> list = new ArrayList<String>();	
	  FileInputStream fis = null;
      BufferedReader reader = null;
      
      try
      {
       Map<String, String> env = System.getenv();
       String REF_FILE_PATH = env.get("REF_DATA_HOME");
       String filepath = REF_FILE_PATH+"/FamilyNames.txt";
       System.out.println("File Path : " + filepath);
           fis = new FileInputStream(filepath);
           reader = new BufferedReader(new InputStreamReader(fis));
         
           System.out.println("Reading File line by line using BufferedReader");
         
           String line = reader.readLine();
           while(line != null){
               System.out.println(line);
               line = reader.readLine();
               list.add(line);
               }
      }catch(Exception e)
      {
    	  e.printStackTrace();
      }
      finally
      {
    	  try
    	  {
    	  reader.close();
    	  fis.close();
    	  }catch(Exception e)
    	  {
    		  e.printStackTrace();
    	  }
      }
       return list;
	}
	
}
