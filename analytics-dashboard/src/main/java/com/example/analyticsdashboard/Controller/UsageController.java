package com.example.analyticsdashboard.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.analyticsdashboard.dto.DataLeftDTO;
import com.example.analyticsdashboard.dto.MessageDTO;
import com.example.analyticsdashboard.entity.SubscriberUsage;
import com.example.analyticsdashboard.service.UsageService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UsageController {
	
	@Autowired
	private UsageService usageService;
	
	@PostMapping("/plan-recharge")
	public String assignResourcesOnRecharge(@RequestParam String subscriberId,@RequestParam String planId) {
		usageService.assignResources(subscriberId,planId);	
		return "Recharge Successful";
	}

	@GetMapping("/usage-status")
	public List<SubscriberUsage> getAllUsages() {
		return usageService.getAllUsages();
	}
	
	@GetMapping("/subscriber-usage/{subscriberId}")
	public SubscriberUsage getSubscriberUsage(@PathVariable String subscriberId) {	
		return usageService.getSubscriberUsage(subscriberId);	
	}
	
	@PostMapping("/dataUsed")
	public ResponseEntity<MessageDTO> dataUsed(@RequestParam float dataUsed , @RequestParam String subscriberId) {
		MessageDTO msg = new MessageDTO();
	    msg.setStatusReport(usageService.dataUsed(dataUsed ,subscriberId));
		return ResponseEntity.ok(msg);
		
	}
	
	@GetMapping("/data-left-piechart")
	 public DataLeftDTO dataLeftPieChart(@RequestParam String usageId) {
		 
		 return usageService.dataLeftChart(usageId);
	 }
	 
	
	
	

}
