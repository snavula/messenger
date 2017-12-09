package org.sneha.restapi.rest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class LoggingFilter  implements ContainerRequestFilter, ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) {
		System.out.print("Request Filter hedaers");
		System.out.println("Headers"+requestContext.getHeaders());
	}

	@Override
	public void filter(ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) throws IOException {
		
		System.out.print("Response Filter hedaers");
		System.out.print(responseContext.getHeaders());
		
	}
	
	
}
