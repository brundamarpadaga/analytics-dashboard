package com.example.analyticsdashboard.dto;

import java.util.Map;


public class PlanDTO {
    private String planId; // Changed to string
    private String planName;
    private String planType;
    private int validity;
    private int totalSMS;
    private boolean callsUnlimited;
    private int talkTime;
    private float dataPerDay;
    private float dataPerPack;
    private String dataUnit;
    private Map<String, Integer> locationBasedPricing;

    public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}



	public String getPlanType() {
		return planType;
	}



	public void setPlanType(String planType) {
		this.planType = planType;
	}



	public int getValidity() {
		return validity;
	}



	public void setValidity(int validity) {
		this.validity = validity;
	}



	public int getTotalSMS() {
		return totalSMS;
	}



	public void setTotalSMS(int totalSMS) {
		this.totalSMS = totalSMS;
	}



	public boolean isCallsUnlimited() {
		return callsUnlimited;
	}



	public void setCallsUnlimited(boolean callsUnlimited) {
		this.callsUnlimited = callsUnlimited;
	}
	public float getDataPerDay() {
		return dataPerDay;
	}

	public void setDataPerDay(float dataPerDay) {
		this.dataPerDay = dataPerDay;
	}

	public float getDataPerPack() {
		return dataPerPack;
	}

	public void setDataPerPack(float dataPerPack) {
		this.dataPerPack = dataPerPack;
	}

	public int getTalkTime() {
		return talkTime;
	}



	public void setTalkTime(int talkTime) {
		this.talkTime = talkTime;
	}



	






	public String getDataUnit() {
		return dataUnit;
	}



	public void setDataUnit(String dataUnit) {
		this.dataUnit = dataUnit;
	}



	public Map<String, Integer> getLocationBasedPricing() {
		return locationBasedPricing;
	}



	public void setLocationBasedPricing(Map<String, Integer> locationBasedPricing) {
		this.locationBasedPricing = locationBasedPricing;
	}



	
}
