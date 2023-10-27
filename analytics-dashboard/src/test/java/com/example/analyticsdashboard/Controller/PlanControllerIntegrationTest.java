//package com.example.analyticsdashboard.Controller;
//
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//import java.util.Arrays;
//
//
//import com.example.analyticsdashboard.entity.Plan;
//import com.example.analyticsdashboard.repository.PlanRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@AutoConfigureDataMongo
//class PlanControllerIntegrationTest {
//
//	@Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private PlanRepository planRepository;
//
//
//
//    @Test
//    public void testGetAllPlans() throws Exception {
//    	 Plan plan1 = new Plan();
//    	 plan1.setPlanName("Plan 1");
//    	 planRepository.save(plan1);
//
//    	 Plan plan2 = new Plan();
//    	 plan2.setPlanName("Plan 2");
//    	 planRepository.save(plan2);
//    	    
//    	when(planRepository.findAll()).thenReturn(Arrays.asList(plan1, plan2));
//    	    
//    	    mockMvc.perform(MockMvcRequestBuilders.get("/plans"))
//            .andExpect(status().isOk())
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//            .andExpect(jsonPath("$").isArray()) // Check if it's an array
//            .andExpect(jsonPath("$").isArray())
//            .andExpect(jsonPath("$[0].planName").exists())
//            .andExpect(jsonPath("$[1].planName").exists())
//            .andExpect(jsonPath("$[0].planName").value("Plan 1")) 
//            .andExpect(jsonPath("$[1].planName").value("Plan 2")); 
//            
//    	            
//    }
//
//    @Test
//    public void testAddPlan() throws Exception {
//    	Plan somePlan = new Plan();
//        somePlan.setPlanId("1");
//        somePlan.setPlanName("Test Plan");
//        somePlan.setCallsUnlimited(false);
//        somePlan.setDataPerDay(0);
//        somePlan.setDataUnit("MB");
//        somePlan.setPlanType("Prepaid");
//        somePlan.setValidity(99);
//        somePlan.setDataPerPack(12);
//        somePlan.setTotalSMS(0);
//        
//        
//
//        // Mock behavior of the planRepository
//        when(planRepository.save(any(Plan.class))).thenReturn(somePlan);
//
//
//        // Convert the Plan object to JSON
//        ObjectMapper objectMapper = new ObjectMapper();
//        String somePlanJson = objectMapper.writeValueAsString(somePlan);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/plan/add")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(somePlanJson))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Plan added successfully"));
//    }
//
//	
//}
//
//
//
