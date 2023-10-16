import { Component } from '@angular/core';
import { PlansService } from '../plans.service';
import { Plan } from '../plan';

@Component({
  selector: 'app-add-plan',
  templateUrl: './add-plan.component.html',
  styleUrls: ['./add-plan.component.css']
})
export class AddPlanComponent {

  newPlan: Plan = { planId: 0,planName: '', planType: '', validity: 0, totalSMS: 0,
  callsUnlimited: true,
  talkTime: 0,
  dataPerDay: 0,
  dataPerPack: 0,
  dataUnit: '', locationBasedPricing: {} };

  selectedPlanType: string = 'Prepaid';
  selectedCallType : boolean = true;

  constructor(private plansService: PlansService) {}

  onPlanTypeChange(event: Event):void {
    this.newPlan.planType = (event.target as HTMLSelectElement).value;
  }

  onCallsTypeChange(event: Event): void {
    this.newPlan.callsUnlimited = (event.target as HTMLSelectElement).value === 'true';
  }
  

  addPlan(): void {
    this.newPlan.planType = this.selectedPlanType;
    this.plansService.addPlan(this.newPlan).subscribe(() => {
      
    });
  }
}
