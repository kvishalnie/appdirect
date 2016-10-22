package com.appdirect.model;

import java.util.List;

public class ProfileSubscriptionMapping {

	private Integer profileId;
	private List<Integer> subscriptionIds;
	public Integer getProfileId() {
		return profileId;
	}
	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}
	public List<Integer> getSubscriptionIds() {
		return subscriptionIds;
	}
	public void setSubscriptionIds(List<Integer> subscriptionIds) {
		this.subscriptionIds = subscriptionIds;
	}
}
