package org.sneha.restapi.rest;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFil implements ContainerRequestFilter {
	
 
	private static final String AUTHORIZATION_HEADER_KEY = "Authorization Header";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic";
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException
			throws IOException {
	List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
	if(authHeader.size() > 0) {	
		String authToken = authHeader.get(0);
		authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, ":");
		String decodedString = Base64.decodeAsString(authToken);
		StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
		String username = tokenizer.nextToken();
		String password = tokenizer.nextToken();
		
		if("user".equals(username) && "password".equals(password)) {
			return;
		}
		
		Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED)
									.entity("USER cannot access the resource")
									.build();
		requestContext.abortWith(unauthorizedStatus);
	}
	}
}