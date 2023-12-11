import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RestaurantSubmission } from '../common/restaurantsubmission';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {
  private readonly baseUrl = 'http://localhost:8080/api/sessions';

  private readonly headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': 'http://localhost:4200'
  });

  constructor(private http: HttpClient) { }

  submitRestaurant(sessionId: number, restaurantName: string) {
    const url = `${this.baseUrl}/${sessionId}/submit`;

    return this.http.post<RestaurantSubmission[]>(url, {restaurantName} , { headers: this.headers });
  }

  getRestaurants(sessionId: number) {
    const url = `${this.baseUrl}/${sessionId}/update`;

    return this.http.get<RestaurantSubmission[]>(url, { headers: this.headers });
  }

  pickRestaurant(sessionId: number) {
    const url = `${this.baseUrl}/${sessionId}/picked`;

    return this.http.post<string>(url, { headers: this.headers });
  }
}