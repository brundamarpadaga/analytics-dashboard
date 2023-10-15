package com.example.analyticsdashboard.dto;

import com.example.analyticsdashboard.entity.Subscriber;

public class SubscriberDTO {
    private Subscriber subscriber;
    private int locationBasedPricing;

    public SubscriberDTO(Subscriber subscriber, int locationBasedPricing) {
        this.subscriber = subscriber;
        this.locationBasedPricing = locationBasedPricing;
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