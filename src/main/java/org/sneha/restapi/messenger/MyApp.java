package org.sneha.restapi.messenger;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@ApplicationPath("webapi")
public class MyApp extends Application {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		return "It works";
	}

}
