package com.appdirect.model;

public class Address {

	private String buildingNm;
	private String locality;
	private int pincode;
	public String getBuildingNm() {
		return buildingNm;
	}
	public void setBuildingNm(String buildingNm) {
		this.buildingNm = buildingNm;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [buildingNm=" + buildingNm + ", locality=" + locality + ", pincode=" + pincode + "]";
	}
}
