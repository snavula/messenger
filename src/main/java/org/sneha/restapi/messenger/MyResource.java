package org.sneha.restapi.messenger;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("{pathParam}/myresource")
//@Singleton when it is a singleton, pathparam and query param cant be applied to variables, only applicable to methods
public class MyResource {
	
	
	private int count;
	
	@PathParam("pathParam") private String pathParamExample;
	@QueryParam("query") private String queryParamExample;

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	count = count + 1;
        return "Got the count! "+count+"PATH PARAM VALUE: "+pathParamExample+"QUERY PARAM VALUE: "+queryParamExample;
    }   
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Date testMethod() {
    	return Calendar.getInstance().getTime();
    }
    
    @GET
    @Produces(value = { MediaType.TEXT_PLAIN, "text/shortdate" })
    public Date testMethodShortDate() {
    	return Calendar.getInstance().getTime();
    }
}
