package com.appdirect.subscription;

import java.util.ArrayList;
import java.util.List;

import com.appdirect.model.Service;
import com.appdirect.model.Subscription;

public interface SubscriptionService {
	
	List<Subscription> subscribe(int profileId, List<Service> services);
	
	void unSubscribe(List<Integer> subscriptionIds);
	
	List<Subscription> getSubscriptions(List<Integer>subscritionIds);
	
	

}
