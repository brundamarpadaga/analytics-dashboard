//package com.example.analyticsdashboard.Controller;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import com.example.analyticsdashboard.dto.SubscriberDTO;
//import com.example.analyticsdashboard.entity.Plan;
//import com.example.analyticsdashboard.entity.Subscriber;
//import com.example.analyticsdashboard.repository.PlanRepository;
//import com.example.analyticsdashboard.repository.SubscriberRepository;
//import com.example.analyticsdashboard.service.SubscriberService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@WebMvcTest(SubscriberController.class)
//@AutoConfigureMockMvc
//class SubscriberControllerTest {
//	
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private SubscriberService subscriberService;
//    
//    @MockBean
//    private PlanRepository planRepository;
//    
//    @MockBean
//    private SubscriberRepository subscriberRepository;
//
//    @Test
//    public void testGetAllSubs() throws Exception {
//        // Create some sample subscribers
//        Subscriber subscriber1 = new Subscriber();
//        subscriber1.setSubscriberID("1");
//        subscriber1.setName("Subscriber 1");
//        subscriber1.setPhoneNumber("1234567890");
//        subscriber1.setLocation("Location 1");
//        subscriber1.setPlanName("Plan A");
//
//        Subscriber subscriber2 = new Subscriber();
//        subscriber2.setSubscriberID("2");
//        subscriber2.setName("Subscriber 2");
//        subscriber2.setPhoneNumber("9876543210");
//        subscriber2.setLocation("Location 2");
//        subscriber2.setPlanName("Plan B");
//
//        // Mock the behavior of subscriberService.getAllSubs()
//        List<Subscriber> subscribers = Arrays.asList(subscriber1, subscriber2);
//        Mockito.when(subscriberService.getAllSubs()).thenReturn(subscribers);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/subscribers"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Subscriber 1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Subscriber 2"));
//    }
//    
//    @Test
//    public void testGetSubscriberDetails ()  throws Exception{
//        // Create some sample data
//        Subscriber subscriber = new Subscriber();
//        subscriber.setSubscriberID("1");
//        subscriber.setName("Subscriber 1");
//        subscriber.setPhoneNumber("1234567890");
//        subscriber.setLocation("Location 1");
//        subscriber.setPlanName("Plan A");
//
//        Plan planA = new Plan();
//        planA.setPlanName("Plan A");
//        planA.setPlanType("Prepaid");
//        planA.setLocationBasedPricing(Map.of("Location 1", 10));
//
//        // Mock the behavior of subscriberRepository and planRepository
//        Mockito.when(subscriberRepository.findAll()).thenReturn(Arrays.asList(subscriber));
//        Mockito.when(planRepository.findByPlanName("Plan A")).thenReturn(Optional.of(planA));
//
//        List<SubscriberDTO> subscribersWithPricing = new ArrayList<>();
//        subscribersWithPricing.add(new SubscriberDTO(subscriber, 10, "Prepaid"));
//        Mockito.when(subscriberService.getSubscriberDetails()).thenReturn(subscribersWithPricing);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/subscribersWithPlanPrice"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subscriber.name").value("Subscriber 1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].locationBasedPricing").value(10))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].planType").value("Prepaid"));
//        
//        
//    }
//    
//    @Test
//    void testAddSubscriber() throws Exception {
//        // Create a sample subscriber JSON
//        String subscriberJson = "{\n" +
//                "  \"name\": \"Sai\",\n" +
//                "  \"phoneNumber\": \"689-480-0982\",\n" +
//                "  \"location\": \"Mumbai\",\n" +
//                "  \"planName\": \"Truly Unlimited 60 days\"\n" +
//                "}";
//
//        // Convert JSON to a Subscriber object
//        ObjectMapper objectMapper = new ObjectMapper();
//        Subscriber subscriber = objectMapper.readValue(subscriberJson, Subscriber.class);
//
//        // Mock the behavior of subscriberService.addSubscriber
//        Mockito.doNothing().when(subscriberService).addSubscriber(subscriber);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/subscriber/add")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(subscriberJson))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//	
//
//}
