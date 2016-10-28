package com.appdirect.model;

public class Service {

	private String serviceNm;
	private String planType;
	public String getServiceNm() {
		return serviceNm;
	}
	public void setServiceNm(String serviceNm) {
		this.serviceNm = serviceNm;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	@Override
	public String toString() {
		return "Service [serviceNm=" + serviceNm + ", planType=" + planType + "]";
	}
	
}
