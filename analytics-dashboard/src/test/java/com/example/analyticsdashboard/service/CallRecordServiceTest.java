package com.example.analyticsdashboard.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.analyticsdashboard.dto.CallRecordDTO;
import com.example.analyticsdashboard.entity.CallRecord;
import com.example.analyticsdashboard.repository.CallRecordRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CallRecordServiceTest {

    @InjectMocks
    private CallRecordService callRecordService;

    @Mock
    private CallRecordRepository callRecordRepository;

    @Mock
    private UsageService usageService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindCallRecordById() {
        String callRecordId = "123456789123456789123456"; // Provide a valid call record ID
        String subsId = "123456789123456789123455";
        CallRecord callRecord = new CallRecord(subsId,null,null,""); // Create a CallRecord instance as needed

        when(callRecordRepository.findById(callRecordId)).thenReturn(Optional.of(callRecord));

        CallRecord result = callRecordService.findCallRecordById(callRecordId);

        assertNotNull(result);
        // Add assertions to check if the result matches the expected call record
    }

    @Test
    public void testGetAllCallrecords() {
        List<CallRecord> callRecords = new ArrayList<>(); // Create a list of CallRecord instances as needed

        when(callRecordRepository.findAll()).thenReturn(callRecords);

        List<CallRecord> result = callRecordService.getAllCallrecords();

        assertNotNull(result);
        // Add assertions to check the contents of the result list
    }

    @Test
    public void testGetCallRecord() {
    	 String callRecordId = "123456789123456789123456"; // Provide a valid call record ID
    	    String subscriberId = "123456789123456789123456"; // Provide a valid subscriber ID
    	    LocalDateTime callStartTime = LocalDateTime.now(); // Provide a valid call start time
    	    CallRecord callRecord = new CallRecord(subscriberId, callStartTime, null, "1233456789");
    	    callRecord.setId(callRecordId);
    	    when(callRecordRepository.findById(callRecordId)).thenReturn(Optional.of(callRecord));

    	    CallRecordDTO result = callRecordService.getCallRecord(callRecordId);

    	    assertNotNull(result);
       
    }

    @Test
    public void testGetAllCallRecordsBySubscriberId() {
        String subscriberId = "123456789123456789123456"; // Provide a valid subscriber ID
        List<CallRecord> callRecords = new ArrayList<>(); // Create a list of CallRecord instances as needed

        when(callRecordRepository.findAllBySubscriberID(subscriberId)).thenReturn(callRecords);

        List<CallRecord> result = callRecordService.getAllCallRecordsBySubscriberId(subscriberId);

        assertNotNull(result);
        // Add assertions to check the contents of the result list
    }

    @Test
    public void testGetAllCallRecordsDTOBySubscriberId() {
        String subscriberId = "123456789123456789123456"; // Provide a valid subscriber ID
        List<CallRecord> callRecords = new ArrayList<>(); // Create a list of CallRecord instances as needed

        when(callRecordRepository.findAllBySubscriberID(subscriberId)).thenReturn(callRecords);

        List<CallRecordDTO> result = callRecordService.getAllCallRecordsDTOBySubscriberId(subscriberId);

        assertNotNull(result);
        // Add assertions to check the contents of the result list
    }

    @Test
    public void testCreateCallRecord() {
        String subscriberId = "123456789123456789123456"; // Provide a valid subscriber ID
        String phoneNumber = "phoneNumber"; // Provide a phone number

        LocalDateTime currentDateTime = LocalDateTime.now();
        when(callRecordRepository.save(any())).thenReturn(new CallRecord("",currentDateTime,null,""));

        CallRecord result = callRecordService.createCallRecord(subscriberId, phoneNumber);

        assertNotNull(result);
        // Add assertions to check if the result matches the expected CallRecord
    }

    @Test
    public void testEndCall() {
        String callRecordId = "123456789123456789123456"; // Provide a valid call record ID
        
        String subscriberId = "123456789123456789123456"; // Provide a valid subscriber ID
        CallRecord callRecord = new CallRecord(subscriberId,null,null,"123447826"); // Create a CallRecord instance as needed
        when(callRecordRepository.findById(callRecordId)).thenReturn(Optional.of(callRecord));

        String result = callRecordService.endCall(callRecordId);

        assertEquals("Call not found or already ended", result);
    }

    @Test
    public void testEndCallNonExistent() {
        String callRecordId = "nonExistentCallRecordId"; // Provide a call record ID that does not exist

        when(callRecordRepository.findById(callRecordId)).thenReturn(Optional.empty());
        
        String result = callRecordService.endCall(callRecordId);

        assertEquals("Call not found or already ended", result);
    }

    @Test
    public void testConvertToDTO() {
    	String callRecordId = "123456789123456789123456";
        CallRecord callRecord = new CallRecord("123456789123456789123456",LocalDateTime.now(),LocalDateTime.now(),"123456789"); // Create a CallRecord instance with sample data
        callRecord.setCallActive(true);
        callRecord.setId(callRecordId);
        when(callRecordRepository.findById(callRecordId)).thenReturn(Optional.of(callRecord));
        CallRecordDTO result = callRecordService.convertToDTO(callRecord);

        assertNotNull(result);
        // Add assertions to check if the result matches the expected CallRecordDTO
    }

    
    @Test
    public void testGetAllCallrecordsDTO() {
        List<CallRecord> callRecords = new ArrayList<>(); // Create a list of CallRecord instances as needed

        when(callRecordRepository.findAll()).thenReturn(callRecords);

        List<CallRecordDTO> result = callRecordService.getAllCallrecordsDTO();

        assertNotNull(result);
        // Add assertions to check the contents of the result list
    }

    @Test
    public void testGetActiveCalls() {
        List<CallRecord> callRecords = new ArrayList<>(); 

        when(callRecordRepository.findByCallActive(true)).thenReturn(callRecords);

        List<CallRecordDTO> result = callRecordService.getActiveCalls();

        assertNotNull(result);
        
    }
}
