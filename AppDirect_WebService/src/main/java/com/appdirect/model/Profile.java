package com.appdirect.model;

import java.util.List;

public class Profile {
	
	private static int count=1;
	
	public Profile(){
		
	}
	
	public Profile(String name, Address address) {
		this.profileId=count++;
		this.name=name;
		this.address=address;
	}

	private int profileId;
	private String name;
	private Address address;

	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", name=" + name + ", address=" + address + "]";
	}
 
}
