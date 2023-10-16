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

@NgModule({
  declarations: [
    AppComponent,
    SubscribersComponent,
    DashboardComponent,
    PlansComponent,
    AddPlanComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
