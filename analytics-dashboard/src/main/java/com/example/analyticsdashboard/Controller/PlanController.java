package com.example.analyticsdashboard.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.analyticsdashboard.dto.MessageDTO;
import com.example.analyticsdashboard.dto.PlanDTO;
import com.example.analyticsdashboard.entity.Plan;
import com.example.analyticsdashboard.service.PlanService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PlanController {
	
	@Autowired
	private PlanService planService;	
	
	@GetMapping("/plans")
	public List<PlanDTO> getAllPlans(){
		return planService.getAllPlans();
	}
	
	
	@PostMapping("/plan/add")
	public ResponseEntity<MessageDTO> addPlan(@RequestBody Plan plan) {
		MessageDTO msg = new MessageDTO();
    	msg.setStatusReport(planService.addPlan(plan));
		return ResponseEntity.ok(msg);
	}
	
	 @PutMapping("/plan/edit/{id}")
	 public ResponseEntity<MessageDTO> editPlan(@PathVariable String id, @RequestBody Plan plan) {
		 MessageDTO msg = new MessageDTO();
	     msg.setStatusReport(planService.editPlan(id, plan));
		 return ResponseEntity.ok(msg);
		 
	        
	 }

	    @DeleteMapping("/plan/delete/{id}")
	    public ResponseEntity<MessageDTO> deletePlan(@PathVariable String id) {
	    	MessageDTO msg = new MessageDTO();
	    	msg.setStatusReport(planService.deletePlan(id));
	        return ResponseEntity.ok(msg);
	    }
	    
	    @GetMapping("/plan/{id}")
	    public PlanDTO getPlan(@PathVariable String id) {
	    	return planService.getPlan(id);
	    	
	    }

}
