import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AnalyticsService {

  private baseUrl = 'http://localhost:8080'; // Replace with your API endpoint

  constructor(private http: HttpClient) { }

  

  getCallRecordsHourlyCount(): Observable<number[]> {
    return this.http.get<number[]>(`${this.baseUrl}/api/analytics/call-records-hourly-count`);
  }

  getAverageCallDuration(): Observable<number> {
    return this.http.get<number>(`${this.baseUrl}/api/analytics/average-call-duration`);
  }

}
