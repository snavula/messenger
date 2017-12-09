package org.sneha.restapi.rest;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.sneha.restapi.messenger.model.Message;

public class GenericDemo {

	public static void main(String args[]) {
		Client client = ClientBuilder.newClient();
		
		List<Message> messages = client.target("http://localhost:8080/messenger/webapi/")
							.path("messages")
							.queryParam("year", 2015)
							.request(MediaType.TEXT_XML)
							.get(new GenericType<List<Message>>() { });
		
		System.out.println(messages);
			
	}
}
