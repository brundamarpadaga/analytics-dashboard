package com.example.analyticsdashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;


public class ScheduledTaskService {
	
	 @Autowired
	 private UsageService usageService;

	    // Schedule the task to run daily at midnight (1 minute past midnight)
	    @Scheduled(cron = "0 1 0 * * ?")
	    public void reduceValidityDaily() {
	        usageService.reduceValidityForAllSubscribers();
	        usageService.renewData();
	    }

}
