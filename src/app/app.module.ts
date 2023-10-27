import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SubscribersComponent } from './subscribers/subscribers.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import {  HttpClientModule } from '@angular/common/http';
import { PlansComponent } from './plans/plans.component';
import { FormsModule } from '@angular/forms';
import { AddPlanComponent } from './add-plan/add-plan.component';
import { CallRecordsComponent } from './call-records/call-records.component';
import { EditPlanComponent } from './edit-plan/edit-plan.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { AddCallRecordComponent } from './add-call-record/add-call-record.component';
import { SmsRecordsComponent } from './sms-records/sms-records.component';
import { AddSmsRecordComponent } from './add-sms-record/add-sms-record.component';
import { SubscriberUsageDetailsComponent } from './subscriber-usage-details/subscriber-usage-details.component';
import { CallRecordsChartComponent } from './call-records-chart/call-records-chart.component';
import { NgChartsModule } from 'ng2-charts';
import { DataUsageComponent } from './data-usage/data-usage.component';



@NgModule({
  declarations: [
    AppComponent,
    SubscribersComponent,
    DashboardComponent,
    PlansComponent,
    AddPlanComponent,
    CallRecordsComponent,
    EditPlanComponent,
    NavBarComponent,
    AddCallRecordComponent,
    SmsRecordsComponent,
    AddSmsRecordComponent,
    SubscriberUsageDetailsComponent,
    CallRecordsChartComponent,
    DataUsageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgChartsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
