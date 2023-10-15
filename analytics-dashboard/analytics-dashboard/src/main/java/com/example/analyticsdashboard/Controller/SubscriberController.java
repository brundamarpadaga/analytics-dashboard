package com.example.analyticsdashboard.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.analyticsdashboard.dto.SubscriberDTO;
import com.example.analyticsdashboard.entity.Subscriber;
import com.example.analyticsdashboard.service.SubscriberService;

@RestController
public class SubscriberController {
	
	@Autowired
	private SubscriberService subscriberService;
	
	@GetMapping("/subscribers")
	public List<Subscriber> getAllSubs(){
		return subscriberService.getAllSubs();
	}
	
	@PostMapping("/subscriber/add")
	public void addSubscriber(@RequestBody Subscriber sub) {
		subscriberService.addSubscriber(sub);
	}
	
	@GetMapping("/subscribersWithPlanPrice")
    public List<SubscriberDTO> getAllSubscribers() {
        return subscriberService.getSubsWithPlanPrice();
    }

}
