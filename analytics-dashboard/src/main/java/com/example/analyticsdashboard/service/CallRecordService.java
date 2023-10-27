package com.example.analyticsdashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.analyticsdashboard.dto.CallRecordDTO;
import com.example.analyticsdashboard.entity.CallRecord;
import com.example.analyticsdashboard.repository.CallRecordRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CallRecordService {
	
	@Autowired
    private CallRecordRepository callRecordRepository;
	
	@Autowired
	private UsageService usageService;


    public CallRecord findCallRecordById(String callRecordId) {
        return callRecordRepository.findById(callRecordId).orElseGet(null);
    }
    public List<CallRecord> getAllCallrecords() {
        List<CallRecord> callRecords = callRecordRepository.findAll();
        return callRecords;
    }
    
    public CallRecordDTO getCallRecord(String callRecordId) {
    	CallRecord callRecord = callRecordRepository.findById(callRecordId).get();
    	if( callRecord != null) {
    		return convertToDTO( callRecord);
    	}
    	return null;
    }

    public List<CallRecord> getAllCallRecordsBySubscriberId(String subscriberId) {
        return callRecordRepository.findAllBySubscriberID(subscriberId);
    }
    public List<CallRecordDTO> getAllCallRecordsDTOBySubscriberId(String subscriberId) {
        List<CallRecord> callRecords =callRecordRepository.findAllBySubscriberID(subscriberId);
        List <CallRecordDTO> callRecordDTOs = new ArrayList<CallRecordDTO>();
        for( CallRecord callRecord: callRecords) {
			callRecordDTOs.add(convertToDTO(callRecord));
		}
		return callRecordDTOs;
    }

    public CallRecord createCallRecord(String subscriberId, String phoneNumber) {
        LocalDateTime callStartTime = LocalDateTime.now();
        CallRecord callRecord = new CallRecord(subscriberId, callStartTime, null, phoneNumber);
        callRecord.setCallActive(true);
        return callRecordRepository.save(callRecord);
    }

    public String endCall(String callRecordId) {
        CallRecord callRecord = callRecordRepository.findById(callRecordId).orElse(null);
        if(callRecord != null) {
        	String subscriberId = callRecord.getSubscriberID();
            if (callRecord.getCallEndTime() == null && callRecord.isCallActive()) {
    			LocalDateTime callEndTime = LocalDateTime.now();
    			callRecord.setCallEndTime(callEndTime);
    			callRecord.setCallActive(false);
    			int durationInSeconds = callRecord.calculateCallDuration();
    			callRecordRepository.save(callRecord);
    			usageService.callMade(subscriberId, durationInSeconds);
    			return "Call Ended";
    		} else {
    			return "Call not found or already ended";
    		}
            
        }
        return "Call not found or already ended";
        
        
    }
    
    public CallRecordDTO convertToDTO(CallRecord callRecord) {
    	CallRecordDTO dto = new CallRecordDTO();
    	
    	if(callRecord != null ) {
    		dto.setSubscriberID(callRecord.getSubscriberID());
        	dto.setCallStartTime(callRecord.getCallStartTime().toString());
        	dto.setId(callRecord.getId().toHexString());
        	dto.setCallActive(callRecord.isCallActive());
        	if(callRecord.getCallEndTime() != null) {
        		dto.setCallEndTime(callRecord.getCallEndTime().toString());
            	dto.setCallDuration(callRecord.getCallDuration());
        	}
        	dto.setPhoneNumber(callRecord.getPhoneNumber());
        	return dto;
    		
    	}
    	return null;
    	
    }

	public List<CallRecordDTO> getAllCallrecordsDTO() {
		List<CallRecord> callRecords = callRecordRepository.findAll();
		List<CallRecordDTO> callRecordDTOs = new ArrayList<>();
		for( CallRecord callRecord: callRecords) {
			callRecordDTOs.add(convertToDTO(callRecord));
		}
		return callRecordDTOs;
		
	}
	public List<CallRecordDTO> getActiveCalls() {
		List<CallRecord> callRecords = callRecordRepository.findByCallActive(true);
		List<CallRecordDTO> callRecordDTOs = new ArrayList<>();
		for( CallRecord callRecord: callRecords) {
			callRecordDTOs.add(convertToDTO(callRecord));
		}
		return callRecordDTOs;
	}
	
	
}
