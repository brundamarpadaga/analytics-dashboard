import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Plan } from './plan';

@Injectable({
  providedIn: 'root'
})
export class PlansService {
  private baseUrl = 'http://localhost:8080'; // Update with your Spring Boot API URL.

  constructor(private http: HttpClient) {}

  getAllPlans(): Observable<Plan[]> {
    return this.http.get<Plan[]>(`${this.baseUrl}/plans`);
  }

  addPlan(plan: Plan): Observable<string> {
    return this.http.post<string>(`${this.baseUrl}/plan/add`, plan);
  }
}
