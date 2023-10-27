package com.example.analyticsdashboard.dto;


public class SmsRecordDTO {
	
	private String id;
    private String subscriberID;
	private String phoneNumber;
	private String sentTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubscriberID() {
		return subscriberID;
	}
	public void setSubscriberID(String subscriberID) {
		this.subscriberID = subscriberID;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSentTime() {
		return sentTime;
	}
	public void setSentTime(String sentTime) {
		this.sentTime = sentTime;
	}
	

}
