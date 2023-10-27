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

import com.example.analyticsdashboard.dto.MessageDTO;
import com.example.analyticsdashboard.dto.SmsRecordDTO;
import com.example.analyticsdashboard.entity.SmsRecord;
import com.example.analyticsdashboard.service.SmsService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SmsController {

    @Autowired
    private SmsService smsService;
    
    @GetMapping("/sms-records")
    public List<SmsRecord> getAllSmsRecords(){
    	return smsService.getAllSms();
    }
    
    @GetMapping("/sms-records-dto")
    public List<SmsRecordDTO> getAllSmsRecordsDTO(){
    	return smsService.getAllSmsDTO();
    }
    
    @GetMapping("/sms-records/{subscriberId}")
    public List<SmsRecordDTO> getAllSmsRecordsBySubscriber(@PathVariable String subscriberId) {
        return smsService.getAllSmsRecordsBySubscriber(subscriberId);
    }
    
    @PostMapping("/add-sms")
    public ResponseEntity<MessageDTO> addSmsRecord(@RequestParam String subscriberId, @RequestParam String phoneNumber) {
        MessageDTO msg = new MessageDTO();
    	msg.setStatusReport(smsService.addSmsRecord(subscriberId, phoneNumber));
    	return ResponseEntity.ok(msg);
    }
}
