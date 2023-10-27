import { Component } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { Plan } from '../plan';
import { PlansService } from '../plans.service';

@Component({
  selector: 'app-edit-plan',
  templateUrl: './edit-plan.component.html',
  styleUrls: ['./edit-plan.component.css']
})
export class EditPlanComponent {

  planId!: string;
  plan: Plan = {
    planId: '',
    planName: '',
    planType: '',
    validity: 0,
    totalSMS: 0,
    callsUnlimited: true,
    talkTime: 0,
    dataPerDay: 0,
    dataPerPack: 0,
    dataUnit: '',
    locationBasedPricing: {},
  };
  //locationsAndPrices: Map<string, number> = new Map<string, number>();
  newLocation: string = '';
  newPrice: number = 0;
  locationsAndPrices: [string, number][] = [];

  constructor(
    private plansService: PlansService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.planId = params['planId'];
      this.getPlanDetails();
    });
  }

  getPlanDetails(): void {
    this.plansService.getPlan(this.planId).subscribe((plan) => {
      this.plan = plan;
      this.plan.locationBasedPricing = Object.fromEntries(this.locationsAndPrices);
      console.log(this.plan);
    });
  }

  editPlan(): void {

    this.plan.locationBasedPricing = Object.fromEntries(this.locationsAndPrices);
   
    this.plansService.editPlan(this.planId, this.plan).subscribe(() => {
      this.router.navigate(['/plans']); // Redirect to plans page after editing
    });
  }

  addLocationPrice(newLocation: string, newPrice: number): void {
    if (newLocation && newPrice > 0) { // Validate the input
      // Push the new location and price to the array
      this.locationsAndPrices.push([newLocation, newPrice]);
  
      // Clear the input fields
      this.newLocation = '';
      this.newPrice = 0;
    } else {
      // Handle invalid input, e.g., show an error message to the user
      // You can also use Angular's FormBuilder for better validation and error handling.
    }
  }
  

}
