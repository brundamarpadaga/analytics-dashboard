import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CallRecord } from './call-record';
import { Status } from './status';

@Injectable({
  providedIn: 'root'
})
export class CallRecordsService {

  private baseUrl = 'http://localhost:8080'; // Replace with your API endpoint

  constructor(private http: HttpClient) { }

  getAllCallRecords(): Observable<CallRecord[]> {
    const url = `${this.baseUrl}/api/call-records-dto`;
    return this.http.get<CallRecord[]>(url);
  }

  getActiveCallRecords(): Observable<CallRecord[]> {
    const url = `${this.baseUrl}/api/active-calls`;
    return this.http.get<CallRecord[]>(url);
  }

  createCallRecord(subscriberId: string, phoneNumber: string): Observable<Status> {
    const url = `${this.baseUrl}/api/start-call?subscriberId=${subscriberId}&phone=${phoneNumber}`;
    const body = { subscriberId, phone: phoneNumber };
    return this.http.post<Status>(url, "");
  }


  endCall(callRecordId: string): Observable<Status> {
    const url = `${this.baseUrl}/api/end-call?callRecordId=${callRecordId}`;
    return this.http.post<Status>(url, null);
  }

  getCallRecordsBySubscriberId(subscriberId: string): Observable<CallRecord[]> {
    const url = `${this.baseUrl}/api/call-records-DTOs/${subscriberId}`;
    return this.http.get<CallRecord[]>(url);
  }

  getAverageCallDuration(): Observable<number> {
    return this.http.get<number>(`${this.baseUrl}/api/analytics/average-call-duration`);
  }

}
