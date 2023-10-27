package com.example.analyticsdashboard.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.analyticsdashboard.entity.Plan;

@Repository
public interface PlanRepository extends MongoRepository<Plan,String>{

	public Optional<Plan> findByPlanId(String planId);
	
	public Optional<Plan> findByPlanName(String planName);

}
