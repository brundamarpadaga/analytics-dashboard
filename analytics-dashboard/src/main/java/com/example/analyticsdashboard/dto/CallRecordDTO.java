package com.example.analyticsdashboard.dto;

public class CallRecordDTO {
    private String id;
    private String callStartTime;
    private String callEndTime;
    private int callDuration;
    private String phoneNumber;
    public boolean callActive;
    private String subscriberID;
    
	public boolean isCallActive() {
		return callActive;
	}
	public void setCallActive(boolean callActive) {
		this.callActive = callActive;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCallStartTime() {
		return callStartTime;
	}
	public void setCallStartTime(String callStartTime) {
		this.callStartTime = callStartTime;
	}
	public String getCallEndTime() {
		return callEndTime;
	}
	public void setCallEndTime(String callEndTime) {
		this.callEndTime = callEndTime;
	}
	public int getCallDuration() {
		return callDuration;
	}
	public void setCallDuration(int callDuration) {
		this.callDuration = callDuration;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSubscriberID() {
		return subscriberID;
	}
	public void setSubscriberID(String subscriberID) {
		this.subscriberID = subscriberID;
	}

    
}