package com.example.analyticsdashboard.dto;

import com.example.analyticsdashboard.entity.Subscriber;

public class SubscriberDTO {
    private Subscriber subscriber;
    private int locationBasedPricing;
    private String planType;

    public SubscriberDTO(Subscriber subscriber, int locationBasedPricing,String planType) {
        this.subscriber = subscriber;
        this.locationBasedPricing = locationBasedPricing;
        this.planType = planType;
    }

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public Subscriber getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}

	public int getLocationBasedPricing() {
		return locationBasedPricing;
	}

	public void setLocationBasedPricing(int locationBasedPricing) {
		this.locationBasedPricing = locationBasedPricing;
	}

    
}