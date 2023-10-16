import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SubscribersResponse } from './subscribers-response';


@Injectable({
  providedIn: 'root'
})
export class SubscribersService {

  private baseUrl = 'http://localhost:8080'; // Update with your Spring Boot API URL.

  constructor(private http: HttpClient) {}

  getAllSubscribersWithPlanPrice():Observable<SubscribersResponse[]> {
    return this.http.get<SubscribersResponse[]>(`${this.baseUrl}/subscribersWithPlanPrice`);
  }
}
