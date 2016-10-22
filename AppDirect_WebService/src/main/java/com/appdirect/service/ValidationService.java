package com.appdirect.service;

import org.springframework.stereotype.Component;

import com.appdirect.data.DataService;

@Component
public class ValidationService {

	
	public boolean checkIfProfileExists(int profileId){
		return (DataService.getProfiles().get(profileId) ==null) ? false : true;
	}
}
