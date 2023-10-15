package com.example.analyticsdashboard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.analyticsdashboard.dto.SubscriberDTO;
import com.example.analyticsdashboard.entity.Plan;
import com.example.analyticsdashboard.entity.Subscriber;
import com.example.analyticsdashboard.repository.PlanRepository;
import com.example.analyticsdashboard.repository.SubscriberRepository;

@Service
public class SubscriberService {
	
	@Autowired
	private SubscriberRepository subscriberRepository;
	
	@Autowired
	private PlanRepository planRepository;
	

	public List<SubscriberDTO> getSubsWithPlanPrice() {
		List<Subscriber> subscribers = subscriberRepository.findAll();
        List<SubscriberDTO> subscribersWithPricing = new ArrayList<>();

        for (Subscriber subscriber : subscribers) {
            Plan plan = planRepository.findByPlanId(subscriber.getPlanId()).orElse(null);

            if (plan != null) {
                subscribersWithPricing.add(new SubscriberDTO(subscriber, plan.getLocationBasedPricing().get(subscriber.getLocation())));
            } else {
                subscribersWithPricing.add(new SubscriberDTO(subscriber, 0)); // Handle when the plan is not found.
            }
        }

        return subscribersWithPricing;
	}


	public List<Subscriber> getAllSubs() {
		return subscriberRepository.findAll();
	}


	public void addSubscriber(Subscriber sub) {
		subscriberRepository.save(sub);
		
	}

}
