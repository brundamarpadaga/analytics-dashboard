package com.example.analyticsdashboard.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.analyticsdashboard.entity.CallRecord;

public interface CallRecordRepository extends MongoRepository<CallRecord,String>{
	
	Optional<CallRecord> findById(String id);

	List<CallRecord> findAllBySubscriberID(String subscriberID);

	List<CallRecord> findByCallActive(boolean isActive);

}
