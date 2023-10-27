package com.example.analyticsdashboard.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.analyticsdashboard.dto.SmsRecordDTO;
import com.example.analyticsdashboard.entity.SmsRecord;
import com.example.analyticsdashboard.repository.SmsRecordRepository;

class SmsServiceTest {

		 @InjectMocks
		 private SmsService smsService;

	    @Mock
	    private SmsRecordRepository smsRecordRepository;

	    @Mock
	    private UsageService usageService;

	    @BeforeEach
	    public void init() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    public void testGetAllSms() {
	        List<SmsRecord> expectedSmsRecords = new ArrayList<>();
	        when(smsRecordRepository.findAll()).thenReturn(expectedSmsRecords);

	        List<SmsRecord> result = smsService.getAllSms();

	        assertEquals(expectedSmsRecords, result);
	    }

	    @Test
	    public void testGetAllSmsDTO() {
	        List<SmsRecord> smsRecords = new ArrayList<>();
	        List<SmsRecordDTO> expectedSmsDtos = new ArrayList<>();
	        when(smsRecordRepository.findAll()).thenReturn(smsRecords);

	        List<SmsRecordDTO> result = smsService.getAllSmsDTO();

	        assertEquals(expectedSmsDtos, result);
	    }

	    @Test
	    public void testGetAllSmsRecordsBySubscriber() {
	        String subscriberId = "testSubscriberId";
	        List<SmsRecord> expectedSmsRecords = new ArrayList<>();
	        when(smsRecordRepository.findAllBySubscriberID(subscriberId)).thenReturn(expectedSmsRecords);

	        List<SmsRecordDTO> result = smsService.getAllSmsRecordsBySubscriber(subscriberId);

	        assertEquals(new ArrayList<SmsRecordDTO>(), result);
	    }

	    @Test
	    public void testAddSmsRecord() {
	        String subscriberId = "testSubscriberId";
	        String phoneNumber = "testPhoneNumber";
	        String expectedResult = "SMS record added";
	        SmsRecord smsRecord = new SmsRecord();
	        when(smsRecordRepository.save(any())).thenReturn(smsRecord);

	        String result = smsService.addSmsRecord(subscriberId, phoneNumber);
	        System.out.println(result);

	        assertEquals(expectedResult, result);
	    }

	    @Test
	    public void testConvertToDTO() {
	        SmsRecord smsRecord = new SmsRecord();
	        smsRecord.setId("123423726324274723243434");
	        smsRecord.setPhoneNumber("testPhoneNumber");
	        smsRecord.setSentTime(LocalDateTime.now());
	        smsRecord.setSubscriberID("testSubscriberId");

	        SmsRecordDTO result = smsService.convertToDTO(smsRecord);

	        assertEquals("123423726324274723243434", result.getId());
	        assertEquals("testPhoneNumber", result.getPhoneNumber());
	        // Add more assertions for other fields
	    }

}
