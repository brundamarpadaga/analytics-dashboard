package com.example.analyticsdashboard.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="callRecords")
public class CallRecord {
	
	@Id
	private String id;
	
	private LocalDateTime callStartTime;
    private LocalDateTime callEndTime;
    private int callDuration; 
    private String phoneNumber; 
    
    public CallRecord(LocalDateTime callStartTime, LocalDateTime callEndTime, String phoneNumber) {
        this.callStartTime = callStartTime;
        this.callEndTime = callEndTime;
        this.phoneNumber = phoneNumber;

        // Calculate the call duration in seconds
        this.callDuration = (int) java.time.Duration.between(callStartTime, callEndTime).getSeconds();
    }

	

}
