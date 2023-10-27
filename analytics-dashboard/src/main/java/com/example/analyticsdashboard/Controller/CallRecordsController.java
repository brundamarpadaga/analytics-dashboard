package com.example.analyticsdashboard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.analyticsdashboard.dto.CallRecordDTO;
import com.example.analyticsdashboard.dto.MessageDTO;
import com.example.analyticsdashboard.entity.CallRecord;
import com.example.analyticsdashboard.service.CallRecordService;


import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CallRecordsController {

    @Autowired
    private CallRecordService callRecordService;
    
    
    @GetMapping("/call-record/{callRecordId}")
    public CallRecordDTO getCallRecord(@PathVariable String callRecordId) {
    	return callRecordService.getCallRecord(callRecordId);
    }
    
    @GetMapping("/call-records/{subscriberId}")
    public List<CallRecord> getAllCallRecordsOfSubscriber(@PathVariable String subscriberId ){
    	return callRecordService.getAllCallRecordsBySubscriberId(subscriberId);
    }
    @GetMapping("/call-records-DTOs/{subscriberId}")
    public List<CallRecordDTO> getAllCallRecordsDTOsOfSubscriber(@PathVariable String subscriberId ){
    	return callRecordService.getAllCallRecordsDTOBySubscriberId(subscriberId);
    }
    
    @GetMapping("/call-records")
    public List<CallRecord> getAllCallRecords(){
    	return callRecordService.getAllCallrecords();
    }
    
    @GetMapping("/call-records-dto")
    public List<CallRecordDTO> getAllCallRecordsDTO(){
    	return callRecordService.getAllCallrecordsDTO();
    }
    
    
    
    @PostMapping("/start-call")
    public ResponseEntity<MessageDTO> startCall(@RequestParam String subscriberId , @RequestParam String phone) {
    	System.out.println("started call");
    	callRecordService.createCallRecord(subscriberId, phone);
    	MessageDTO msg = new MessageDTO();
    	msg.setStatusReport("Call Started");
    	return ResponseEntity.ok(msg);
    }
    @PostMapping("/end-call")
    public ResponseEntity<MessageDTO> endCall(@RequestParam String callRecordId) {
    	MessageDTO msg = new MessageDTO();
    	msg.setStatusReport(callRecordService.endCall(callRecordId));
    	return ResponseEntity.ok(msg);	
    }
    
    @GetMapping("/active-calls")
    public List<CallRecordDTO> getActiveCallRecords(){
    	return callRecordService.getActiveCalls();
    }
    

}
