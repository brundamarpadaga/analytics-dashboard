package com.example.analyticsdashboard.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class smsRecord {
	
	@Id
	String id;
	
	@Field("subscriberID")
    private String subscriberID;
	
	private String phoneNumber; 
	
	private LocalDateTime sentTime;
	
	

}
