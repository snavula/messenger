package org.sneha.restapi.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.sneha.restapi.messenger.database.DatabaseClass;
import org.sneha.restapi.messenger.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	 
	public ProfileService() {
		profiles.put("Snowy", new Profile(1, "Snowy", "sneha", "avula"));
		profiles.put("Snowy2", new Profile(2, "Snowy2", "avula", "sneha"));
	}
	public List<Profile> getAllProfiles() {
	    return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profilename) {
		return profiles.get(profilename);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profilename) {
		return profiles.remove(profilename);
	}

}
