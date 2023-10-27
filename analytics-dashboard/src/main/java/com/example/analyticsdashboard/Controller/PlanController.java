package com.example.analyticsdashboard.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.analyticsdashboard.entity.Plan;
import com.example.analyticsdashboard.repository.PlanRepository;

@RestController
@CrossOrigin
public class PlanController {
	
	@Autowired
	private PlanRepository planRepository;	
	
	@GetMapping("/plans")
	public List<Plan> getAllPlans(){
		return planRepository.findAll();
	}
	
	
	@PostMapping("/plan/add")
	public String addPlan(@RequestBody Plan plan) {
		planRepository.save(plan);
		return "Plan added successfully";
	}

}
