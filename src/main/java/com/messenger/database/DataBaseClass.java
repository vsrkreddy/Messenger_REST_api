package com.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.messenger.model.Message;
import com.messenger.model.Profile;

public class DataBaseClass {

	public static Map<Long, Message> messages = new HashMap<>();
	public static Map<String, Profile> profiles = new HashMap<>();
	
	
	public static Map<Long, Message> getMessage(){
		return messages;
	}
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
	
}
