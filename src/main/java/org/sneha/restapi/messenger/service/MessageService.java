package org.sneha.restapi.messenger.service;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.sneha.restapi.messenger.database.DatabaseClass;
import org.sneha.restapi.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
 
	public MessageService() {
		messages.put(1L, new Message(1, "Hello world", "sneha"));
		messages.put(2L, new Message(2, "Hello world", "avula"));
	}
	public List<Message> getAllMessages() {
	    return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar col = Calendar.getInstance();
		for(Message message : messages.values()) {
			col.setTime(message.getCreated());
			if(col.get(Calendar.YEAR) == year) {
			  messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		List<Message> list = new ArrayList<>(messages.values());
		if(start + size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start + size);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
