import { Component, OnInit } from '@angular/core';
import { SessionService } from './session.service';
import { RestaurantService } from './restaurant.service';
import { Session } from '../common/session';
import { RestaurantSubmission } from '../common/restaurantsubmission';
import { Router } from '@angular/router';



@Component({
  selector: 'app-session',
  templateUrl: './session.component.html',
  styleUrls: ['./session.component.css']
})
export class SessionComponent  {
  sessionStarted = false;
  sessionEnded = false;
  sessionJoin = false;
  sessionSubmitted = false;
  sessionUpdated = false;
  sessionId: number = 0;
  restaurantName: string ='';
  isRoutedUrl: boolean = false;

  session: Session | undefined;
  restaurantSubmissions: RestaurantSubmission []= [] // Update the type to RestaurantSubmission[] | undefined

  
  pickedRestaurant: string ='';
  
  stringList: string[] = [];
  constructor(private sessionService: SessionService, private restaurantService: RestaurantService,) {
   }

initiateSession() {
  this.sessionService.initiateSession().subscribe(session => {
    this.sessionStarted = true;

    this.session = session; // Store the returned session object
    this.sessionId = session.id; // Set the sessionId property
  });
}

copyUrl() {
  const url = window.location.href;
  const urlWithSessionId = `${url}app-joinpage`;
  navigator.clipboard.writeText(urlWithSessionId).then(() => {
    console.log('URL copied to clipboard:', urlWithSessionId);
  }, (error) => {
    console.error('Failed to copy URL:', error);
  });
}



joinSession() {
  this.sessionService.joinSession(this.sessionId).subscribe(restaurantSubmissions => {

    this.restaurantSubmissions = restaurantSubmissions;
    this.sessionJoin = true;

  });
}


submitRestaurant() {

  this.restaurantService.submitRestaurant(this.sessionId,this.restaurantName).subscribe(restaurantSubmissions => {
    this.restaurantSubmissions = restaurantSubmissions;
    
    this.sessionSubmitted = true;
  });
}

getRestaurants() {
  this.restaurantService.getRestaurants(this.sessionId).subscribe(restaurantSubmissions => {
    this.restaurantSubmissions = restaurantSubmissions;
  });
}

endSession() {
  this.restaurantService.pickRestaurant(this.sessionId).subscribe(pickedRestaurant => {
    this.pickedRestaurant = pickedRestaurant;
    this.sessionEnded = true;
    console.log(this.pickedRestaurant);
    
  });
}
}