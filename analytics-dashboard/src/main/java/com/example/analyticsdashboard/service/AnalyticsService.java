package com.example.analyticsdashboard.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.example.analyticsdashboard.entity.CallRecord;



@Service
public class AnalyticsService {
	
	
	
	public List<Integer> calculateHourlyCounts(List<CallRecord> callRecords) {
		   
	    Map<Integer, Integer> hourlyCounts = new HashMap<>();

	    for (CallRecord callRecord : callRecords) {
	        LocalDateTime startDateTime = callRecord.getCallStartTime();
	        LocalDateTime endDateTime = callRecord.getCallEndTime();

	     if(callRecord.isCallActive() == false) {
	    	 while (startDateTime.isBefore(endDateTime)) {
		            int hour = startDateTime.getHour();
		            hourlyCounts.put(hour, hourlyCounts.getOrDefault(hour, 0) + 1);
		            startDateTime = startDateTime.plusHours(1);
		        } 
	     	}   
	    }
	    List<Integer> hourlyCountList = new ArrayList<>();
	    for (int hour = 0; hour < 24; hour++) {
	        hourlyCountList.add(hourlyCounts.getOrDefault(hour, 0));
	    }
	    return hourlyCountList;
	}

	
}
