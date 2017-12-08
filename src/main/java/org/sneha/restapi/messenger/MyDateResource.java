package org.sneha.restapi.messenger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("date/{dateString}") 
public class MyDateResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getRequestedDate(@PathParam("dateString") MyDate mydate) {
		
		return mydate.toString();
		
		/*have to implement paramconverter provider (whenever you see this scenario, use param converter) 
		 * and param converter(does actual conversion) 
		 */
	}
	

}
