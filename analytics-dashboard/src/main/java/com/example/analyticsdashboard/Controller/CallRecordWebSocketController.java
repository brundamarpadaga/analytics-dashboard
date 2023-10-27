package com.example.analyticsdashboard.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.analyticsdashboard.entity.CallRecord;
import com.example.analyticsdashboard.repository.CallRecordRepository;

@Controller
public class CallRecordWebSocketController {
	
	 @Autowired
	 private CallRecordRepository callRecordRepository;

	 @MessageMapping("/call-records")
	 @SendTo("/topic/call-records")
	 public CallRecord addCallRecord(CallRecord callRecord) 
	 {
		 CallRecord savedCallRecord = callRecordRepository.save(callRecord);
	     return savedCallRecord;    
	 }
}
