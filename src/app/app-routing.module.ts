import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SubscribersComponent } from './subscribers/subscribers.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { PlansComponent } from './plans/plans.component';
import { AddPlanComponent } from './add-plan/add-plan.component';
import { CallRecordsComponent } from './call-records/call-records.component';
import { EditPlanComponent } from './edit-plan/edit-plan.component';
import { AddCallRecordComponent } from './add-call-record/add-call-record.component';
import { SmsRecordsComponent } from './sms-records/sms-records.component';
import { AddSmsRecordComponent } from './add-sms-record/add-sms-record.component';
import { SubscriberUsageDetailsComponent } from './subscriber-usage-details/subscriber-usage-details.component';
import { CallRecordsChartComponent } from './call-records-chart/call-records-chart.component';
import { DataUsageComponent } from './data-usage/data-usage.component';

const routes: Routes = [
  { path: 'subscribers', component: SubscribersComponent },
  { path : 'dashboard' , component: DashboardComponent},
  { path : 'plans' , component: PlansComponent},
  { path: 'add-plan', component: AddPlanComponent},
  { path : 'call-records', component: CallRecordsComponent},
  { path: 'edit-plan', component: EditPlanComponent },
  { path: 'call-records', component: CallRecordsComponent},
  { path: 'add-call-record', component: AddCallRecordComponent},
  { path: 'sms-records', component: SmsRecordsComponent},
  { path : 'add-sms-record', component:AddSmsRecordComponent},
  { path: 'subscriber-usage/:subscriberId', component: SubscriberUsageDetailsComponent},
  { path:'data-usage-record',component:DataUsageComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
