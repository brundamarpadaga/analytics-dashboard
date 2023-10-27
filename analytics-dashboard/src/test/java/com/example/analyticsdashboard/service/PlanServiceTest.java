package com.example.analyticsdashboard.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.analyticsdashboard.dto.PlanDTO;
import com.example.analyticsdashboard.entity.Plan;
import com.example.analyticsdashboard.repository.PlanRepository;

class PlanServiceTest {

	@InjectMocks
    private PlanService planService;

    @Mock
    private PlanRepository planRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddPlan() {
        Plan plan = new Plan(); // Create a Plan instance as needed

        when(planRepository.save(any())).thenReturn(plan);

        String result = planService.addPlan(plan);

        assertEquals("Plan added successfully", result);
    }

    @Test
    public void testGetAllPlans() {
        List<Plan> plans = new ArrayList<>(); // Create a list of Plan instances as needed
        when(planRepository.findAll()).thenReturn(plans);

        List<PlanDTO> result = planService.getAllPlans();

        assertNotNull(result);
        // Add assertions for checking the contents of the result list
    }

    @Test
    public void testEditPlan() {
        String id = "planId"; // Provide a valid plan ID
        Plan plan = new Plan(); // Create a Plan instance with updated values

        when(planRepository.findById(id)).thenReturn(Optional.of(new Plan())); // Return an existing plan

        String result = planService.editPlan(id, plan);

        assertEquals("Plan added successfully", result);
    }

    @Test
    public void testEditPlanNonExistent() {
        String id = "nonExistentPlanId"; // Provide a plan ID that does not exist
        Plan plan = new Plan(); // Create a Plan instance with updated values

        when(planRepository.findById(id)).thenReturn(Optional.empty()); // Return no existing plan

        String result = planService.editPlan(id, plan);

        assertEquals("Plan does not exist", result);
    }

    @Test
    public void testDeletePlan() {
        String id = "planId"; // Provide a valid plan ID

        String result = planService.deletePlan(id);

        assertEquals("Plan deleted successfully", result);
    }

    @Test
    public void testGetPlan() {
        String id = "123456789123456789123456"; // Provide a valid plan ID
        Plan plan = new Plan(); // Create a Plan instance
        plan.setPlanId(id);
        when(planRepository.findByPlanId(id)).thenReturn(Optional.of(plan));

        PlanDTO result = planService.getPlan(id);

        assertNotNull(result);
        // Add assertions for checking the contents of the result PlanDTO
    }

    @Test
    public void testGetPlanNonExistent() {
        String id = "123456789123456789123456"; // Provide a plan ID that does not exist

        when(planRepository.findByPlanId(id)).thenReturn(Optional.empty());

        PlanDTO result = planService.getPlan(id);

        assertEquals(null, result);
    }
    
    @Test
    public void testConvertToPlanDTO() {
        // Create a Plan instance with sample data
        Plan plan = new Plan();
        plan.setPlanId("123456789123456789123456"); // Provide a valid plan ID
        plan.setPlanName("Sample Plan");
        plan.setPlanType("Type A");
        plan.setValidity(30);
        plan.setTotalSMS(1000);
        plan.setCallsUnlimited(true);
        plan.setTalkTime(600);
        plan.setDataPerDay(1);
        plan.setDataPerPack(10);
        plan.setDataUnit("GB");
        //plan.setLocationBasedPricing(false);

        // Create a PlanService instance (you might need to initialize it properly)
        PlanService planService = new PlanService();

        // Call the convertToPlanDTO method
        PlanDTO planDTO = planService.convertToPlanDTO(plan);

        // Assert that the returned PlanDTO is not null
        assertNotNull(planDTO);

        // Add more specific assertions based on your data and expectations
        assertEquals("123456789123456789123456", planDTO.getPlanId());
        assertEquals("Sample Plan", planDTO.getPlanName());
        assertEquals("Type A", planDTO.getPlanType());
        assertEquals(30, planDTO.getValidity());
        assertEquals(1000, planDTO.getTotalSMS());
        assertTrue(planDTO.isCallsUnlimited());
        assertEquals(600, planDTO.getTalkTime());
        assertEquals(1, planDTO.getDataPerDay());
        assertEquals(10, planDTO.getDataPerPack());
        assertEquals("GB", planDTO.getDataUnit());
        //assertFalse(planDTO.isLocationBasedPricing());
    }

}
