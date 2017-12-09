package org.sneha.restapi.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.sneha.restapi.messenger.model.Message;

public class RestApiClient {
	
	public static void main(String args[]) {
		
		Client client = ClientBuilder.newClient();
		
		WebTarget basetarget = client.target("http://localhost:8080/messenger/webapi/");
		WebTarget messageTarget = basetarget.path("messages");
		WebTarget singleMessageTarget = messageTarget.path("{messageId}");
		Message message1 = singleMessageTarget
						.resolveTemplate("messageId", 1)
						  .request(MediaType.TEXT_XML)
						  .get(Message.class);
		Message message2 = singleMessageTarget
				.resolveTemplate("messageId", 2)
				  .request(MediaType.TEXT_XML)
				  .get(Message.class);
		
		Message newMessage = new Message(4, "MY new message from JAX_RS CLIEnt", "sneha");
		Response postResponse = messageTarget
				                .request()
				                .post(Entity.xml(newMessage));
		
		if(postResponse.getStatus() != 201) {
			System.out.println("Error");
		}
		
		Message createdMessage = postResponse.readEntity(Message.class);
		System.out.println(createdMessage.getMessage());
	}

}
