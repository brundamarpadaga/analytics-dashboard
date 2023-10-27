import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Plan } from './plan';
import { PlanDTO } from './plan-dto';
import { Status } from './status';

@Injectable({
  providedIn: 'root'
})
export class PlansService {
  private baseUrl = 'http://localhost:8080/api'; // Update with your Spring Boot API URL.

  constructor(private http: HttpClient) {}

  getAllPlans(): Observable<Plan[]> {
    return this.http.get<Plan[]>(`${this.baseUrl}/plans`);
  }

  addPlan(plan: PlanDTO): Observable<Status> {
    return this.http.post<Status>(`${this.baseUrl}/plan/add`, plan,{headers :new HttpHeaders({"Content-Type":"application/json"})});
  }
  editPlan(id: string, plan: Plan): Observable<string> {
    return this.http.put<string>(`${this.baseUrl}/plan/edit/${id}`, plan);
  }

  deletePlan(id: string): Observable<string> {
    return this.http.delete<string>(`${this.baseUrl}/plan/delete/${id}`);
  }
  getPlan(id: string): Observable<Plan> {
    return this.http.get<Plan>(`${this.baseUrl}/plan/${id}`);
  }
}
