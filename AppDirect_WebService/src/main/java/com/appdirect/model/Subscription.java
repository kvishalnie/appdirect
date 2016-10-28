package com.appdirect.model;

public class Subscription {

	private static int count=1;
	
	private Integer subscriptionId;
	private Service service;
	
	public Subscription(){
		this.subscriptionId = count++;
	}
	public Integer getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(Integer subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	@Override
	public String toString() {
		return "Subscription [subscriptionId=" + subscriptionId + ", service=" + service + "]";
	}
}
