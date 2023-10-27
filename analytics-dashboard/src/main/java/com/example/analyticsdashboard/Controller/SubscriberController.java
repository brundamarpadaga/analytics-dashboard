package com.example.analyticsdashboard.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.analyticsdashboard.dto.SubscriberDTO;
import com.example.analyticsdashboard.entity.Subscriber;
import com.example.analyticsdashboard.service.SubscriberService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class SubscriberController {
	
	@Autowired
	private SubscriberService subscriberService;
	
	@GetMapping("/subscribers")
	public List<Subscriber> getAllSubs(){
		return subscriberService.getAllSubs();
	}
	
	@PostMapping("/subscriber/add")
	public String addSubscriber(@RequestBody Subscriber sub) {
		return subscriberService.addSubscriber(sub);
	}
	
	@GetMapping("/subscribersWithPlanPrice")
    public List<SubscriberDTO> getAllSubscribers() {
        return subscriberService.getSubscriberDetails();
    }

}
