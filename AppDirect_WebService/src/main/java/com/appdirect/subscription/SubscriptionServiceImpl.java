package com.appdirect.subscription;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.appdirect.data.DataService;
import com.appdirect.model.Service;
import com.appdirect.model.Subscription;

@Component
public class SubscriptionServiceImpl implements SubscriptionService {

	@Override
	public List<Subscription> subscribe(int profileId, List<Service> services) {

		 List<Subscription> subscriptions = new ArrayList<>();
		for(Service service : services)
		{
			Subscription sub = new Subscription();
			sub.setService(service);
			subscriptions.add(sub);
			DataService.getSubscriptions().put(sub.getSubscriptionId(), sub);
		}
		
		return subscriptions;
	}

	@Override
	public void unSubscribe(List<Integer> subscriptionIds) {
		for(Integer i:subscriptionIds)
	DataService.getSubscriptions().remove(i);
		
	}

	@Override
	public List<Subscription> getSubscriptions(List<Integer>subscritionIds) {
		List<Subscription> usrSubs= new ArrayList<>();
		for(Integer sub: subscritionIds){
			usrSubs.add(DataService.getSubscriptions().get(sub));
		}
		return usrSubs;
	}



}
