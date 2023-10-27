package com.example.analyticsdashboard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.analyticsdashboard.entity.SubscriberUsage;

public interface UsageRepository extends MongoRepository<SubscriberUsage, String>{
	
	public SubscriberUsage findBySubscriberID(String SubscriberID);

}
