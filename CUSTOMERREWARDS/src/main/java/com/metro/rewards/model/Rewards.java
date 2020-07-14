package com.metro.rewards.model;


public class Rewards {

	private String customerId;
	private String month;
	private int rewardPoints;
	
	public Rewards() {
		super();
	}

	public Rewards(String customerId, String month, int rewardPoints) {
		super();
		this.customerId = customerId;
		this.month = month;
		this.rewardPoints = rewardPoints;
	}

	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	
	public String Sales() {
		return ("customerId=" + customerId + "; month=" + month + "; rewardPoints=" + rewardPoints);
	}

}