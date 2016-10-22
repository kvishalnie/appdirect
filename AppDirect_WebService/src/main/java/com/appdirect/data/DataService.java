package com.appdirect.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.appdirect.model.Profile;
import com.appdirect.model.ProfileSubscriptionMapping;
import com.appdirect.model.Service;
import com.appdirect.model.Subscription;

public class DataService {
	
	private static Map<Integer, Profile>  profiles = new HashMap<>();
	
	private static Map<Integer, List<Integer>>  profileSubsMap = new HashMap<>();

	private static Map<Integer, Subscription>  subscriptions = new HashMap<>();
	
	private static List<Service> services = new ArrayList<>();
	

	public static Map<Integer, Profile> getProfiles() {
		return profiles;
	}

	public static void setProfiles(Map<Integer, Profile> profiles) {
		DataService.profiles = profiles;
	}

	public static Map<Integer, Subscription> getSubscriptions() {
		return subscriptions;
	}

	public static void setSubscriptions(Map<Integer, Subscription> subscriptions) {
		DataService.subscriptions = subscriptions;
	}

	public static Map<Integer, List<Integer>> getProfileSubsMap() {
		return profileSubsMap;
	}

	public static void setProfileSubsMap(Map<Integer, List<Integer>> profileSubsMap) {
		DataService.profileSubsMap = profileSubsMap;
	}

	public static List<Service> getServices() {
		Service service1 = new Service();
		service1.setServiceNm("BroadbandService");
		service1.setPlanType("Gold");
		
		Service service2 = new Service();
		service2.setServiceNm("BroadbandService");
		service2.setPlanType("Silver");
		
		Service service3 = new Service();
		service3.setServiceNm("BroadbandService");
		service3.setPlanType("Platinum");
		
		Service service4 = new Service();
		service4.setServiceNm("CallService");
		service4.setPlanType("Gold");
		
		Service service5 = new Service();
		service5.setServiceNm("CallService");
		service5.setPlanType("Silver");
		
		
		
		services.add(service1);
		services.add(service2);
		services.add(service3);
		services.add(service4);
		services.add(service5);
		return services;
	}

	

}
