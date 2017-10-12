package com.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.messenger.database.DataBaseClass;

import com.messenger.model.Profile;

public class ProfileService {
private Map<String, Profile> profiles = DataBaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("profile1", new Profile(1L, "ShivaRam","Shiva", "velma"));
		profiles.put("profile2", new Profile(2L, "Krishna","Krishna", "velagapudi"));
	}

	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String name){
		return profiles.get(name);
	}
	
	public Profile addProfile(Profile name){
		name.setId(profiles.size()+1);
		profiles.put(name.getProfileName(), name);
		return name;
		
	}
	
	public Profile updateProfile(Profile name){
		if(name.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(name.getProfileName(), name);
		return name;
	}
	
	public Profile removeProfile(String name){
		return profiles.remove(name);
		
	}


}
