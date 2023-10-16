package com.example.analyticsdashboard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.analyticsdashboard.entity.Subscriber;

@Repository
public interface SubscriberRepository extends MongoRepository<Subscriber,String> {
	public Subscriber findBySubscriberID(String id);

}
