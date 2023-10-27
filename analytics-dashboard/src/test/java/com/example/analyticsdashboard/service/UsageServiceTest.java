package com.example.analyticsdashboard.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.analyticsdashboard.entity.Plan;
import com.example.analyticsdashboard.entity.Subscriber;
import com.example.analyticsdashboard.entity.SubscriberUsage;
import com.example.analyticsdashboard.repository.PlanRepository;
import com.example.analyticsdashboard.repository.SubscriberRepository;
import com.example.analyticsdashboard.repository.UsageRepository;

public class UsageServiceTest {

    @InjectMocks
    private UsageService usageService;

    @Mock
    private PlanRepository planRepository;

    @Mock
    private SubscriberRepository subscriberRepository;

    @Mock
    private UsageRepository usageRepository;
    
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAssignResources() {
        String subscriberId = "123456789123456789123456";
        String subscriberId2 = "123456789123456789123458";
        String planId = "123456789123456789123457";
        String planId2 = "123456789123456789123458";
        

        Plan samplePlan = new Plan();
        samplePlan.setPlanId(planId);
        samplePlan.setPlanType("Prepaid");
        samplePlan.setDataUnit("GB");
        samplePlan.setPlanName("A");
        samplePlan.setDataPerDay(1);
        samplePlan.setDataPerPack(1);
        samplePlan.setTotalSMS(100);
        samplePlan.setTalkTime(100);
        samplePlan.setValidity(100);
        Plan samplePlan2 = new Plan();
        samplePlan2.setPlanId(planId2);
        samplePlan2.setPlanType("Postpaid");
        samplePlan2.setDataUnit("GB");
        samplePlan2.setPlanName("A");
        samplePlan2.setDataPerDay(1);
        samplePlan2.setDataPerPack(2);
        samplePlan2.setTotalSMS(100);
        Mockito.when(planRepository.findById(planId)).thenReturn(java.util.Optional.of(samplePlan));
        Mockito.when(planRepository.findById(planId2)).thenReturn(java.util.Optional.of(samplePlan2));
        Subscriber sampleSubscriber = new Subscriber();
        sampleSubscriber.setSubscriberID(subscriberId);
        Subscriber sampleSubscriber2 = new Subscriber();
        sampleSubscriber.setSubscriberID(subscriberId2);
        sampleSubscriber.setPlanName("B");
        sampleSubscriber2.setPlanName("C");
        Mockito.when(subscriberRepository.findBySubscriberID(subscriberId)).thenReturn(sampleSubscriber);
        Mockito.when(subscriberRepository.findBySubscriberID(subscriberId2)).thenReturn(sampleSubscriber2);
   
        SubscriberUsage sampleUsage = new SubscriberUsage();
        
        Mockito.when(planRepository.findByPlanName(sampleSubscriber.getPlanName())).thenReturn(java.util.Optional.of(samplePlan));
        
        Mockito.when(usageRepository.save(Mockito.any(SubscriberUsage.class))).thenReturn(sampleUsage);

        

        SubscriberUsage usage2 =  usageService.assignResources(subscriberId, planId);
        SubscriberUsage usage3 =  usageService.assignResources(subscriberId2, planId2);
        

        assertEquals(subscriberId, usage2.getSubscriberID());
        assertEquals("123456789123456789123457", samplePlan.getPlanId().toHexString());
        assertEquals("Prepaid", samplePlan.getPlanType());
        assertEquals("A", sampleSubscriber.getPlanName());
        assertEquals("Daily", usage2.getRenewalType());
        assertEquals(100, usage2.getTalkTimeLeft());
        assertEquals(100, usage2.getValidity());
        assertEquals("Pack", usage3.getRenewalType());

        assertEquals(1024,(int) usage2.getDataLeft());
        assertEquals(1024*2,(int) usage3.getDataLeft());
        assertEquals(100, usage2.getSmsLeft());


        
    } 

    @Test
    public void testReduceValidityForAllSubscribers() {
        SubscriberUsage s1 = new SubscriberUsage();
        s1.setValidity(20);
        SubscriberUsage s2 = new SubscriberUsage();
        s2.setValidity(20);
        List<SubscriberUsage> subsList = new ArrayList<>();
        subsList.add(s1);
        subsList.add(s2);
        Mockito.when(usageRepository.findAll()).thenReturn(subsList);

        // Call the method to be tested
        usageService.reduceValidityForAllSubscribers();

        assertEquals(19, s1.getValidity());
        assertEquals(19, s2.getValidity());
        
    }

    @Test
    public void testGetAllUsages() {
        // Implement this test method to test the getAllUsages method
    }

    @Test
    public void testSmsSent() {
        // Implement this test method to test the smsSent method
    }

    @Test
    public void testGetSubscriberUsage() {
        // Implement this test method to test the getSubscriberUsage method
    }

    @Test
    public void testCallMade() {
        // Implement this test method to test the callMade method
    }

    @Test
    public void testRenewData() {
        // Implement this test method to test the renewData method
    }

    @Test
    public void testDataUsed() {
        // Implement this test method to test the dataUsed method
    }

    @Test
    public void testDataLeftChart() {
        // Implement this test method to test the dataLeftChart method
    }

    // Add more test methods as needed for other functionalities in the service

    
}

