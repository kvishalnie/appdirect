package com.appdirect.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.appdirect.data.DataService;
import com.appdirect.model.Profile;
import com.appdirect.model.Subscription;

@Component
public class AppDirectProfileServiceImpl implements AppDirectProfileService{
	
	
	@Override
	public Profile saveProfile(Profile profile) {
		DataService.getProfiles().put(profile.getProfileId(), profile);
		return profile;
	}

	@Override
	public void saveProfileSubsMapping(Integer profileId, List<Subscription> subscriptionList) {
		
		for(Subscription subs : subscriptionList)
		{
			if(DataService.getProfileSubsMap().get(profileId) != null){
				List<Integer> subscriptions = DataService.getProfileSubsMap().get(profileId);
				subscriptions.add(subs.getSubscriptionId());
				DataService.getProfileSubsMap().put(profileId, subscriptions);
			}else{
				List<Integer> subscriptions = new ArrayList<>();
				subscriptions.add(subs.getSubscriptionId());
				DataService.getProfileSubsMap().put(profileId, subscriptions);
			}
		}
		
	}

	@Override
	public List<Integer> getSubscriptions(int profileId) {
		
		return DataService.getProfileSubsMap().get(profileId);
		
		 
		
	}

	@Override
	public void removeSubscriptions(int profileId, List<Integer> subscriptionIds) {
		
		List<Integer> subcriptions= DataService.getProfileSubsMap().get(profileId);
		subcriptions.removeAll(subscriptionIds);
		DataService.getProfileSubsMap().put(profileId, subcriptions);
	}

}
