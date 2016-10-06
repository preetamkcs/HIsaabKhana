package com.preetam.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class HkRestEngine {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("test")
	public String test(){
		return "helloow hooman!!\n seems like you have passed the test!";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("test1")
	public String test1(){
		return "helloow hooman!!\nseems like you have passed the test again!";
	}
	
}
