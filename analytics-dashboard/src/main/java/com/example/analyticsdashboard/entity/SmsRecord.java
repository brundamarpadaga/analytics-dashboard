package com.example.analyticsdashboard.entity;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public class SmsRecord {
	
	@MongoId(value=FieldType.OBJECT_ID)
	@Field("id")
	private ObjectId id;
	
	@Field("subscriberID")
    private String subscriberID;
	
	private String phoneNumber; 
	private LocalDateTime sentTime;
	
	public ObjectId getId() {
		return id;
	}

	public void setId(String id) {
		this.id = new ObjectId(id);
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

	public LocalDateTime getSentTime() {
		return sentTime;
	}

	public void setSentTime(LocalDateTime sentTime) {
		this.sentTime = sentTime;
	}



}
