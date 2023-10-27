import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SubscribersResponse } from './subscribers-response';
import { Subscriber } from './subscriber';


@Injectable({
  providedIn: 'root'
})
export class SubscribersService {

  private baseUrl = 'http://localhost:8080/api'; 

  constructor(private http: HttpClient) {}

  getAllSubscribersWithPlanPrice():Observable<SubscribersResponse[]> {
    return this.http.get<SubscribersResponse[]>(`${this.baseUrl}/subscribersWithPlanPrice`);
  }

  getAllSubscribers():Observable<Subscriber[]>{
    return this.http.get<Subscriber[]>(`${this.baseUrl}/subscribers`);
  }
}
