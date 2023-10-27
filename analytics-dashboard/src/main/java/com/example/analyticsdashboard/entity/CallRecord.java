package com.example.analyticsdashboard.entity;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection ="callRecords")
public class CallRecord {
	
	@MongoId(value=FieldType.OBJECT_ID)
	@Field("id")
	private ObjectId id;
	
	private LocalDateTime callStartTime;
    private LocalDateTime callEndTime;
    private int callDuration; 
    private String phoneNumber; 
    private boolean callActive;
    
	@Field("subscriberID")
    private String subscriberID;
    
    public CallRecord(String subscriberID,LocalDateTime callStartTime, LocalDateTime callEndTime, String phoneNumber) {
    	this.subscriberID = subscriberID;
        this.callStartTime = callStartTime;
        this.callEndTime = callEndTime;
        this.phoneNumber = phoneNumber;
        
    }
	public boolean isCallActive() {
		return callActive;
	}
	public void setCallActive(boolean callActive) {
		this.callActive = callActive;
	}
	
	public int calculateCallDuration() {
    	return callDuration = (int) java.time.Duration.between(callStartTime, callEndTime).getSeconds();	
    }
    
    public void setId(String id) {
		this.id = new ObjectId(id);
	}

	public ObjectId getId() {
		return id;
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
