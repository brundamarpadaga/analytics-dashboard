package com.example.analyticsdashboard.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.analyticsdashboard.dto.PlanDTO;
import com.example.analyticsdashboard.entity.Plan;
import com.example.analyticsdashboard.repository.PlanRepository;

@Service
public class PlanService {
	
	@Autowired
	private PlanRepository planRepository;
	
	public String addPlan(Plan plan) {
		planRepository.save(plan);
		return "Plan added successfully";
	}
	
	public List<PlanDTO> getAllPlans(){
		List<PlanDTO> planDTOs = new ArrayList<PlanDTO>();
		List<Plan> plans = planRepository.findAll();
		if(plans == null) {
			plans = new ArrayList<>();
		}
		for(Plan plan : plans) {
			planDTOs.add(convertToPlanDTO(plan));
		}
		return planDTOs;
	}

	public String editPlan(String id, Plan plan) {
		Plan existingPlan = planRepository.findById(id).orElse(null);

        if (existingPlan != null) {
            // Update the fields you want to modify
            existingPlan.setPlanName(plan.getPlanName());
            existingPlan.setPlanType(plan.getPlanType());
            existingPlan.setValidity(plan.getValidity());
            existingPlan.setTotalSMS(plan.getTotalSMS());
            existingPlan.setCallsUnlimited(plan.isCallsUnlimited());
            existingPlan.setTalkTime(plan.getTalkTime());
            existingPlan.setDataPerDay(plan.getDataPerDay());
            existingPlan.setDataPerPack(plan.getDataPerPack());
            existingPlan.setDataUnit(plan.getDataUnit());
            existingPlan.setLocationBasedPricing(plan.getLocationBasedPricing());

            // Save the updated plan
            planRepository.save(existingPlan);
            return "Plan added successfully";
        }
        return "Plan does not exist";
	}

	public String deletePlan(String id) {
		planRepository.deleteById(id);
		return "Plan deleted successfully";
		
	}

	public PlanDTO getPlan(String id) {
		Plan plan = planRepository.findByPlanId(id).orElse(null);
		return convertToPlanDTO(plan);
	}
	
	public PlanDTO convertToPlanDTO(Plan plan) {
        PlanDTO planDTO = new PlanDTO();
        if(plan != null) {
        	planDTO.setPlanId(plan.getPlanId().toHexString());
            planDTO.setPlanName(plan.getPlanName());
            planDTO.setPlanType(plan.getPlanType());
            planDTO.setValidity(plan.getValidity());
            planDTO.setTotalSMS(plan.getTotalSMS());
            planDTO.setCallsUnlimited(plan.isCallsUnlimited());
            planDTO.setTalkTime(plan.getTalkTime());
            planDTO.setDataPerDay(plan.getDataPerDay());
            planDTO.setDataPerPack(plan.getDataPerPack());
            planDTO.setDataUnit(plan.getDataUnit());
            planDTO.setLocationBasedPricing(plan.getLocationBasedPricing());
            return planDTO;
        }
        return null;
        
    }	

}
