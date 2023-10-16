import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SubscribersComponent } from './subscribers/subscribers.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { PlansComponent } from './plans/plans.component';
import { AddPlanComponent } from './add-plan/add-plan.component';

const routes: Routes = [
  { path: 'subscribers', component: SubscribersComponent },
  { path : 'dashboard' , component: DashboardComponent},
  { path : 'plans' , component: PlansComponent},
  { path: 'add-plan', component: AddPlanComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
