import { Component, OnInit } from '@angular/core';
import { Plan } from '../plan';
import { PlansService } from '../plans.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-plans',
  templateUrl: './plans.component.html',
  styleUrls: ['./plans.component.css']
})
export class PlansComponent implements OnInit {
  plans: Plan[] = [];
  selectedPlanType: string = 'Prepaid';
  selectedCity: string = 'Hyderabad';
  newPlan: Plan = { planId: 0,planName: '', planType: '', validity: 0, totalSMS: 0,
  callsUnlimited: false,
  talkTime: 0,
  dataPerDay: 0,
  dataPerPack: 0,
  dataUnit: '', locationBasedPricing: {} };

  constructor(private planService: PlansService, private router:Router) {}

  ngOnInit(): void {
    this.getPlans();
  }

  getPlans(): void {
    this.planService.getAllPlans().subscribe((plans) => {
      this.plans = plans;
    });
  }

  

  onCityChange(event: Event): void {
    this.selectedCity = (event.target as HTMLSelectElement).value;
  }

  onPlanTypeChange(event: Event): void {
    this.selectedPlanType = (event.target as HTMLSelectElement).value;
  }
  navigateToAddPlanPage() {
    this.router.navigate(['/add-plan']); // Use the appropriate route path
  }
  
  
}
