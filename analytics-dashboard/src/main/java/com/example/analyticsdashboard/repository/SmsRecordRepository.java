package com.example.analyticsdashboard.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.analyticsdashboard.entity.SmsRecord;

public interface SmsRecordRepository extends MongoRepository<SmsRecord,String> {

	List<SmsRecord> findAllBySubscriberID(String subscriberId);

}
