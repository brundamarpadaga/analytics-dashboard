package com.example.analyticsdashboard.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "plans")
public class Plan {
	
	@Id
	@Field("planId")
	String planId;

	String planName;
	String planType;
	int validity;
	int totalSMS;           
	boolean callsUnlimited;//pre
	int talkTime;
	int dataPerDay;
	int dataPerPack;
	String dataUnit;
	
	private Map<String, Integer> locationBasedPricing = new HashMap<>();
	
	
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
	public int getTalkTime() {
		return talkTime;
	}
	public void setTalkTime(int talkTime) {
		this.talkTime = talkTime;
	}
	public int getDataPerDay() {
		return dataPerDay;
	}
	public void setDataPerDay(int dataPerDay) {
		this.dataPerDay = dataPerDay;
	}
	public int getDataPerPack() {
		return dataPerPack;
	}
	public void setDataPerPack(int dataPerPack) {
		this.dataPerPack = dataPerPack;
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

}