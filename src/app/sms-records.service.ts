import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SmsRecord } from './sms-record';
import { Status } from './status';

@Injectable({
  providedIn: 'root'
})
export class SmsRecordsService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getAllSmsRecords(): Observable<SmsRecord[]> {
    const url = `${this.baseUrl}/api/sms-records`;
    return this.http.get<SmsRecord[]>(url);
  }

  getAllSmsRecordsDTO(): Observable<SmsRecord[]> {
    const url = `${this.baseUrl}/api/sms-records-dto`;
    return this.http.get<SmsRecord[]>(url);
  }

  getAllSmsRecordsBySubscriber(subscriberId: string): Observable<SmsRecord[]> {
    const url = `${this.baseUrl}/api/sms-records/${subscriberId}`;
    return this.http.get<SmsRecord[]>(url);
  }

  addSmsRecord(subscriberId: string, phoneNumber: string): Observable<any> {
    const url = `${this.baseUrl}/api/add-sms?subscriberId=${subscriberId}&phoneNumber=${phoneNumber}`;
    return this.http.post<Status>(url, null);
  }
}
