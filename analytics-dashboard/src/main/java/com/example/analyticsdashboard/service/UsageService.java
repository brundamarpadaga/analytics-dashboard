package com.example.analyticsdashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.analyticsdashboard.dto.DataLeftDTO;
import com.example.analyticsdashboard.entity.Plan;
import com.example.analyticsdashboard.entity.Subscriber;
import com.example.analyticsdashboard.entity.SubscriberUsage;
import com.example.analyticsdashboard.repository.PlanRepository;
import com.example.analyticsdashboard.repository.SubscriberRepository;
import com.example.analyticsdashboard.repository.UsageRepository;

@Service
public class UsageService {
	
	@Autowired
	private PlanRepository planRepository;
	
	@Autowired
	private SubscriberRepository subscriberRepository;
	
	@Autowired
	private UsageRepository usageRepository;

	public SubscriberUsage assignResources(String subscriberId,String planId) {
		SubscriberUsage usage = new SubscriberUsage();
		usage.setSubscriberID(subscriberId);
		Plan newPlan = planRepository.findById(planId).orElseGet(null);
		Subscriber subscriber = subscriberRepository.findBySubscriberID(subscriberId);
		subscriber.setPlanName(newPlan.getPlanName());
		subscriberRepository.save(subscriber);
		if(newPlan.getPlanType().equals("Prepaid")) {
			usage.setRenewalType("Daily");
			if( newPlan.getDataUnit().equals("GB")) {
				float dataInMB = newPlan.getDataPerDay() * 1024;
			     usage.setDataLeft(dataInMB);
			}
			else {
				usage.setDataLeft(newPlan.getDataPerDay());
			}	
		}
		else {
			usage.setRenewalType("Pack");
			if(newPlan.getDataUnit().equals("GB")) {
				float dataInMB = newPlan.getDataPerPack() * 1024;
			     usage.setDataLeft(dataInMB);
			}
			else {
				usage.setDataLeft(newPlan.getDataPerPack());
			}
		}
		usage.setUnlimitedCalls(newPlan.isCallsUnlimited());
		if(newPlan.isCallsUnlimited()== false) {
			usage.setTalkTimeLeft(newPlan.getTalkTime());
		}
		
		usage.setSmsLeft(newPlan.getTotalSMS());
		usage.setValidity(newPlan.getValidity());
		usageRepository.save(usage);
		return usage;
		
	}

	public void reduceValidityForAllSubscribers() {
		List<SubscriberUsage> usages = usageRepository.findAll();
		for(SubscriberUsage usage : usages) {
			usage.setValidity(usage.getValidity()-1);
			usageRepository.save(usage);
		}
		
	}

	public List<SubscriberUsage> getAllUsages() {
		return usageRepository.findAll();
	}

	public void smsSent(String subscriberId) {
		SubscriberUsage usage = usageRepository.findBySubscriberID(subscriberId);
		usage.setSmsLeft(usage.getSmsLeft()-1);
		usageRepository.save(usage);
	}

	public SubscriberUsage getSubscriberUsage(String subscriberId) {
		 return usageRepository.findBySubscriberID(subscriberId);
	}
	
	public void callMade(String subscriberId,int seconds) {
		SubscriberUsage usage = usageRepository.findBySubscriberID(subscriberId);
		float durationInMinutes = seconds/60;
		if(usage.isUnlimitedCalls()==false) {
			usage.setTalkTimeLeft(usage.getTalkTimeLeft()- durationInMinutes);	
			usageRepository.save(usage);
		}
	}

	public void renewData() {
		List<SubscriberUsage> usages = usageRepository.findAll();
		for(SubscriberUsage usage : usages) {
			String subscriberId = usage.getSubscriberID();
			Subscriber subs = subscriberRepository.findBySubscriberID(subscriberId);
			String planName = subs.getPlanName();
			Plan plan = planRepository.findByPlanName(planName).get();
			float data = plan.getDataPerDay();
			if(usage.getRenewalType().equals("Daily")) {
				usage.setDataLeft(data);
			}
			usageRepository.save(usage);
		}	
	}
	
	public String dataUsed(float dataUsed, String subscriberId) {
		SubscriberUsage usage = usageRepository.findBySubscriberID(subscriberId);
		if(usage.getDataLeft()>0) {
			usage.setDataLeft(usage.getDataLeft()-dataUsed);
			usageRepository.save(usage);
			return dataUsed + " MB data used";
		}
		else {
			return "Data quota completed";
		}
	}
	
	public DataLeftDTO dataLeftChart(String usageId) {
		DataLeftDTO dto = new DataLeftDTO();
		SubscriberUsage usage = usageRepository.findById(usageId).get();
		String subscriberId = usage.getSubscriberID();
		Subscriber subscriber = subscriberRepository.findBySubscriberID(subscriberId);
		String planName = subscriber.getPlanName();
		Plan plan = planRepository.findByPlanName(planName).get();
		dto.setDataLeft(usage.getDataLeft());
		if(usage.getRenewalType().equals("Daily")) {
			if(plan.getDataUnit().equals("GB")) {
				dto.setTotalData(plan.getDataPerDay()*1024);
			}
			else {
				dto.setTotalData(plan.getDataPerDay());
			}
		}
		else {
			dto.setDataLeft(plan.getDataPerPack());
		}
		return dto;
	}

}
