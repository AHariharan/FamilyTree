package com.umapus.controller.service;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.springframework.stereotype.Controller;


@Controller
@Path("umapuscontrollerservice")
public class UMapUsControllerService {

	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response Login(String jsonBody, String req)
			throws JSONException {
      return null;
	}
	
}
