import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Status } from './status';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) {}

  private baseUrl = 'http://localhost:8080/api'; // Update with your Spring Boot API URL.

  


  useData(dataUsed: number, subscriberId: string): Observable<Status> {
    const url =`${this.baseUrl}/dataUsed?dataUsed=${dataUsed}&subscriberId=${subscriberId}`;
    const body = { dataUsed, subscriberId };
    return this.http.post<Status>(url , "");
  }

}
