package com.messenger.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.messenger.database.DataBaseClass;
import com.messenger.model.Message;

public class MessageService {
	private Map<Long, Message> messages = DataBaseClass.getMessage();
	
	
	public MessageService(){
		
		messages.put(1L, new Message(1L,"Message1","ShivaVelma"));
		messages.put(2L, new Message(2L,"Message2","Vsrkreddy"));
		
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessageForYear(int year){
		List<Message> messages = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message: messages){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)== year){
				messages.add(message);
			}
		}
		return messages;
		
	}
	
	public List<Message> getAllMessagesPagination(int start, int size){
		List<Message> messageList = new ArrayList<Message>(messages.values());
		if(start+size > messageList.size())
			return new ArrayList<>();
		else
			return messageList.subList(start, size);
		
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
		
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <=0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
		
	}

}
