import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Session } from '../common/session';
import { RestaurantSubmission } from '../common/restaurantsubmission';

@Injectable({
  providedIn: 'root'
})
export class SessionService {
  private readonly baseUrl = 'http://localhost:8080/api/sessions';

  private readonly headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': 'http://localhost:4200'
  });

  constructor(private http: HttpClient) { }

  initiateSession(): Observable<Session>  {
    const url = `${this.baseUrl}/initiate`;



    return this.http.post<Session>(url,  { headers: this.headers });
  }

  joinSession(sessionId: number) {
    const url = `${this.baseUrl}/${sessionId}/join`;

    return this.http.post<RestaurantSubmission[]>(url, { headers: this.headers });
  }

}