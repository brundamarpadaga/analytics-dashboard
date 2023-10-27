package com.example.analyticsdashboard.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "usage")
public class SubscriberUsage {
	
	@MongoId
	@Field("id")
	private ObjectId id;
	
	private float dataLeft;
	private int smsLeft;
	private float talkTimeLeft;
	private boolean unlimitedCalls;
	private int validity;
	private String renewalType;
	
	@Field("subscriberID")
	private String subscriberID;
	

	
	public String getId() {
		return id.toHexString();
	}

	public void setId(String id) {
		this.id = new ObjectId(id);
	}

	public boolean isUnlimitedCalls() {
		return unlimitedCalls;
	}

	public String getSubscriberID() {
		return subscriberID;
	}

	public void setSubscriberID(String subscriberID) {
		this.subscriberID = subscriberID;
	}

	public void setUnlimitedCalls(boolean unlimitedCalls) {
		this.unlimitedCalls = unlimitedCalls;
	}

	public String getRenewalType() {
		return renewalType;
	}

	public void setRenewalType(String renewalType) {
		this.renewalType = renewalType;
	}

	public float getDataLeft() {
		return dataLeft;
	}

	public void setDataLeft(float dataLeft) {
		this.dataLeft = dataLeft;
	}

	public int getSmsLeft() {
		return smsLeft;
	}

	public void setSmsLeft(int smsLeft) {
		this.smsLeft = smsLeft;
	}

	public float getTalkTimeLeft() {
		return talkTimeLeft;
	}

	public void setTalkTimeLeft(float talkTimeLeft) {
		this.talkTimeLeft = talkTimeLeft;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	
}
