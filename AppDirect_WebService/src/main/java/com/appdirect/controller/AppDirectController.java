package com.appdirect.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdirect.data.DataService;
import com.appdirect.model.Address;
import com.appdirect.model.AppDirectException;
import com.appdirect.model.Profile;
import com.appdirect.model.Service;
import com.appdirect.model.Subscription;
import com.appdirect.service.AppDirectProfileService;
import com.appdirect.service.ValidationService;
import com.appdirect.subscription.SubscriptionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "appDirect")
public class AppDirectController {
	
	private final Logger logger = LoggerFactory.getLogger(AppDirectController.class);
	
	@Autowired
	AppDirectProfileService appDirectProfileService;
	
	@Autowired
	SubscriptionService subscriptionService;
	
	@Autowired
	ValidationService validationService;
	
	 @ApiOperation(value = "Create Profile", nickname = "Create Profile")
	 @RequestMapping(method = RequestMethod.POST,  path="/createProfile/{name}")
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = String.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")}) 
	public ResponseEntity<?>  createProfile(@PathVariable(value="name") String name,@RequestBody Address address){
		 
		 Profile createdProfile = appDirectProfileService.saveProfile(new Profile(name,address));
		return ResponseEntity.status(HttpStatus.CREATED).body("Profile created successfully. Profile Id : "+ createdProfile.getProfileId());
	}
	 
	 @ApiOperation(value = "Get List of Services", nickname = "Get List of Services")
	 @RequestMapping(method = RequestMethod.GET,  path="/getServices")
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = List.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")}) 
	public 	ResponseEntity<?> getServices(){
		 List<Service> services = DataService.getServices();
		 Map map = new HashMap();map.put("success", "true");
		 map.put("message", services.toString());
			return ResponseEntity.status(200).body(map);
	//	return ResponseEntity.status(HttpStatus.OK).body(services);
	}
	 
	 
	 @ApiOperation(value = "Create Subscription", nickname = "Create Subscription")
	 @RequestMapping(method = RequestMethod.POST,  path="/createSubscription/{profileId}")
	    @ApiResponses(value = { 
	            @ApiResponse(code = 400, message = "Please create the Profile ID first"),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")}) 
	 public ResponseEntity<?> createSubscription(@PathVariable(value="profileId") int profileId,
			 @RequestBody List<Service> services){
		 if(validationService.checkIfProfileExists(profileId)){
			 List<Subscription> subs = subscriptionService.subscribe(profileId, services);
			 appDirectProfileService.saveProfileSubsMapping(profileId, subs);
			 return ResponseEntity.status(HttpStatus.CREATED).body(subs);
		 }else{
			 return ResponseEntity.status(400).body("Please create the Profile ID first");
		 }

	 }
	 
	 
	 @ApiOperation(value = "Get Subscriptions", nickname = "Get Subscriptions")
	 @RequestMapping(method = RequestMethod.GET,  path="/getSubscriptions/{profileId}")
	    @ApiResponses(value = { 
	            @ApiResponse(code = 400, message = "Please create the Profile ID first"),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")}) 
	public ResponseEntity<?> getSubscriptions(@PathVariable(value="profileId") int profileId){

		 if(validationService.checkIfProfileExists(profileId)){
			 List<Subscription> subsList =  subscriptionService.getSubscriptions(appDirectProfileService.getSubscriptions(profileId));
			 Map map = new HashMap();map.put("success", "true");
			 map.put("message", subsList.toString());
				return ResponseEntity.status(200).body(map);
			// return ResponseEntity.status(HttpStatus.CREATED).body(subsList);
		 }else{
			 Map map = new HashMap();map.put("success", "false");
			 map.put("message","Please create the Profile ID first" );
				return ResponseEntity.status(400).body(map);
			 //return ResponseEntity.status(400).body("Please create the Profile ID first");
		 }
		 
		  
		
	}
	 
	 @ApiOperation(value = "Delete Subscriptions", nickname = "Delete Subscriptions")
	 @RequestMapping(method = RequestMethod.DELETE,  path="/deleteSubscriptions/{profileId}")
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = String.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")}) 
	public String deleteSubscriptions(@PathVariable(value="profileId") int profileId,@RequestParam(value="subscriptionIds") List<Integer> subscriptionIds){

		
		  appDirectProfileService.removeSubscriptions(profileId, subscriptionIds);
		  subscriptionService.unSubscribe(subscriptionIds);
		  return "Subscriptions deleted successfully for profileID:" +profileId;
		
	}
	 
	 

}
