package com.example.analyticsdashboard.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection ="callRecords")
public class CallRecord {
	
	@Id
	private String id;
	
	private LocalDateTime callStartTime;
    private LocalDateTime callEndTime;
    private int callDuration; 
    private String phoneNumber; 
    
	@Field("subscriberID")
    private String subscriberID;
    
    public CallRecord(String subscriberID,LocalDateTime callStartTime, LocalDateTime callEndTime, String phoneNumber) {
    	this.subscriberID = subscriberID;
        this.callStartTime = callStartTime;
        this.callEndTime = callEndTime;
        this.phoneNumber = phoneNumber;

        // Calculate the call duration in seconds
        this.callDuration = (int) java.time.Duration.between(callStartTime, callEndTime).getSeconds();
    }
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getCallStartTime() {
		return callStartTime;
	}

	public void setCallStartTime(LocalDateTime callStartTime) {
		this.callStartTime = callStartTime;
	}

	public LocalDateTime getCallEndTime() {
		return callEndTime;
	}

	public void setCallEndTime(LocalDateTime callEndTime) {
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
