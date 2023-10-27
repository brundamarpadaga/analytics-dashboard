package com.example.analyticsdashboard.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.analyticsdashboard.dto.SmsRecordDTO;
import com.example.analyticsdashboard.entity.SmsRecord;
import com.example.analyticsdashboard.repository.SmsRecordRepository;

@Service
public class SmsService {
	
	@Autowired
	private SmsRecordRepository smsRecordRepository;
	
	@Autowired
    private UsageService usageService;
	
	public List<SmsRecord> getAllSms() {
		return smsRecordRepository.findAll();
	}
	
	public List<SmsRecordDTO> getAllSmsDTO(){
		List<SmsRecord> smsRecords = smsRecordRepository.findAll();
		List <SmsRecordDTO> smsDtos = new ArrayList<>();
		for( SmsRecord smsRecord : smsRecords) {
			smsDtos.add(convertToDTO(smsRecord));	
		}
		return smsDtos;	
	}

	public List<SmsRecordDTO> getAllSmsRecordsBySubscriber(String subscriberId) {
		
		List<SmsRecord> smsRecords = smsRecordRepository.findAllBySubscriberID(subscriberId);
		List <SmsRecordDTO> smsDtos = new ArrayList<>();
		for( SmsRecord smsRecord : smsRecords) {
			smsDtos.add(convertToDTO(smsRecord));	
		}
		return smsDtos;
	}

	public String addSmsRecord(String subscriberId, String phoneNumber) {
		SmsRecord smsRecord = new SmsRecord();
		smsRecord.setSubscriberID(subscriberId);
		smsRecord.setPhoneNumber(phoneNumber);
		smsRecord.setSentTime(LocalDateTime.now());
		smsRecordRepository.save(smsRecord);
		usageService.smsSent(subscriberId);
		return "SMS record added";
	}
	
	public SmsRecordDTO convertToDTO(SmsRecord smsRecord) {
		SmsRecordDTO dto = new SmsRecordDTO();
		dto.setId(smsRecord.getId().toHexString());
		dto.setPhoneNumber(smsRecord.getPhoneNumber());
		dto.setSentTime(smsRecord.getSentTime().toString());
		dto.setSubscriberID(smsRecord.getSubscriberID());
		return dto;
		
	}

}
