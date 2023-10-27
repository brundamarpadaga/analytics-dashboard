package com.example.analyticsdashboard.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.analyticsdashboard.entity.CallRecord;
import com.example.analyticsdashboard.service.AnalyticsService;
import com.example.analyticsdashboard.service.CallRecordService;

@RestController
@CrossOrigin
@RequestMapping("/api/analytics")
public class AnalyticsController {
	
	@Autowired
    private CallRecordService callRecordService;
    
    @Autowired
    private AnalyticsService analyticsService;

	 @GetMapping("/call-records-hourly-count")
	    public ResponseEntity<List<Integer>> getCallRecordsHourlyCount() {
	     List<CallRecord> callRecords = callRecordService.getAllCallrecords();
	     List<Integer> hourlyCounts = analyticsService.calculateHourlyCounts(callRecords);
	     return ResponseEntity.ok(hourlyCounts);   
	 }
	 
	 @GetMapping("/average-call-duration")
	 public ResponseEntity<Double> getAverageCallDuration() {
	     List<CallRecord> callRecords = callRecordService.getAllCallrecords();
	     double totalDuration = 0;
	     for (CallRecord callRecord : callRecords) {
	    	 
	         totalDuration += callRecord.getCallDuration();
	     }
	     double averageDuration = totalDuration / callRecords.size();
	     return ResponseEntity.ok(averageDuration);
	 }
	 
	 
	
	

}
