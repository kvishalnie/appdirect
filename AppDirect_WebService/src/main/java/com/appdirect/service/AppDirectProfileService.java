package com.appdirect.service;

import java.util.List;

import com.appdirect.model.Profile;
import com.appdirect.model.Subscription;

public interface AppDirectProfileService {
	
	public Profile  saveProfile(Profile profile);
	
	public void saveProfileSubsMapping(Integer profileId, List<Subscription> subs);
	
	List<Integer>getSubscriptions(int profileId);
	
	void removeSubscriptions(int profileId,List<Integer>subscriptionIds);

}
