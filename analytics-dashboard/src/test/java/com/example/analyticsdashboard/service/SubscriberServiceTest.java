//package com.example.analyticsdashboard.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import com.example.analyticsdashboard.dto.SubscriberDTO;
//import com.example.analyticsdashboard.entity.Plan;
//import com.example.analyticsdashboard.entity.Subscriber;
//import com.example.analyticsdashboard.repository.PlanRepository;
//import com.example.analyticsdashboard.repository.SubscriberRepository;
//
//public class SubscriberServiceTest {
//
//    @Mock
//    private SubscriberRepository subscriberRepository;
//
//    @Mock
//    private PlanRepository planRepository;
//
//    private SubscriberService subscriberService;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        subscriberService = new SubscriberService(subscriberRepository, planRepository);
//    }
//
//    @Test
//    public void testGetSubscriberDetails() {
//        
//        Subscriber subscriber = new Subscriber();
//        subscriber.setSubscriberID("1");
//        subscriber.setPlanName("TestPlanName");
//        subscriber.setLocation("Hyderabad");
//
//        Plan plan = new Plan();
//        plan.setPlanName("TestPlanName");
//        plan.setLocationBasedPricing(Map.of("Hyderabad", 100));
//
//        when(subscriberRepository.findAll()).thenReturn(List.of(subscriber));
//        when(planRepository.findByPlanName("TestPlanName")).thenReturn(Optional.of(plan));
//
//        List<SubscriberDTO> result = subscriberService.getSubscriberDetails();
//
//        
//        assertEquals(1, result.size());
//        assertEquals("1", result.get(0).getSubscriber().getSubscriberID());
//        assertEquals("Hyderabad", result.get(0).getSubscriber().getLocation());
//        assertEquals(100, result.get(0).getLocationBasedPricing());
//        
//    }
//
//    @Test
//    public void testGetAllSubs() {
//        // Mock data
//        Subscriber subscriber1 = new Subscriber();
//        subscriber1.setName("1");
//        Subscriber subscriber2 = new Subscriber();
//        subscriber2.setName("2");
//
//        when(subscriberRepository.findAll()).thenReturn(List.of(subscriber1, subscriber2));
//
//        List<Subscriber> result = subscriberService.getAllSubs();
//
//        
//        assertEquals(2, result.size());
//        assertEquals("1", result.get(0).getName());
//        assertEquals("2", result.get(1).getName());
//       
//    }
//
//    @Test
//    public void testAddSubscriber() {
//        
//        Subscriber subscriber = new Subscriber();
//        subscriber.setName("1");
//        subscriber.setPlanName("a");
//
//        subscriberService.addSubscriber(subscriber);
//
//        
//    }
//}