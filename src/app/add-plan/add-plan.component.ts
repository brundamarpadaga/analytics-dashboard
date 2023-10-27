import { Component } from '@angular/core';
import { PlansService } from '../plans.service';
import { Plan } from '../plan';
import { PlanDTO } from '../plan-dto';

@Component({
  selector: 'app-add-plan',
  templateUrl: './add-plan.component.html',
  styleUrls: ['./add-plan.component.css']
})
export class AddPlanComponent {

  
  newPlan: PlanDTO = { planName: '', planType: '', validity: 0, totalSMS: 0,  
  callsUnlimited: true,
  talkTime: 0,
  dataPerDay: 0,
  dataPerPack: 0,
  dataUnit: '', locationBasedPricing: {},
 };

  selectedPlanType: string = 'Prepaid';
  selectedCallType : boolean = true;
  myJson: any ;

  locationPriceList: { location: string, price: number }[] = [];

  constructor(private plansService: PlansService) {}

  onPlanTypeChange(event: Event):void {
    this.newPlan.planType = (event.target as HTMLSelectElement).value;
  }

  onCallsTypeChange(event: Event): void {
    this.newPlan.callsUnlimited = (event.target as HTMLSelectElement).value === 'true';
  }

  addPlan(): void {
    
    const locationPricingMap = new Map<string, number>();

    this.locationPriceList.forEach((item) => {
      locationPricingMap.set(item.location, item.price);
    });

  
    this.newPlan.locationBasedPricing = Object.fromEntries(locationPricingMap);
    console.log(this.newPlan); 
    console.log (JSON.stringify(Object.fromEntries(locationPricingMap)));
    console.log(this.newPlan.locationBasedPricing);

    this.newPlan.planType = this.selectedPlanType;
    
    this.plansService.addPlan(this.newPlan).subscribe((res) =>{
      console.log(res);
      
    });
    
  }


  addLocationPrice(location: string, price:string): void {
    const numericPrice = parseInt(price); 
    if (!isNaN(numericPrice)) {
      
      this.locationPriceList.push({ location:location, price:numericPrice });
      
    } else {
     
      console.error('Invalid price input: ' + price);
    }
  }

}
