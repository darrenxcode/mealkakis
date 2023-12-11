import { Component,OnInit  } from '@angular/core';
import { SessionService } from '../session/session.service';
import { Client } from '@stomp/stompjs';


@Component({
  selector: 'app-session',
  templateUrl: './session.component.html',
  styleUrl: './session.component.css'
})
export class SessionComponent {
  sessionDetails: any = {
    // Session information (e.g., name, creator, status, etc.)
  };
  sessionName: string = '';
  hostName: string = '';
  showShareLink: boolean;
  stompClient : Client;

  joinedUsers: string[] = [];
  submittedRestaurants: string[] = [];
  pickedRestaurant: string = '';

  constructor(private sessionService: SessionService) {
    this.showShareLink = false;
    this.stompClient = new Client();

  }
  ngOnInit() {
    this.sessionService.connect();
  }



  initiateSession() {

    const message = {
      hostName: this.hostName,
      sessionName: this.sessionName,
    };

      this.stompClient.publish({
       destination: '/session.create',
        body: JSON.stringify(message),
      });
     
  }

  joinSession() {

    const message = {
      hostName: this.hostName,
      sessionName: this.sessionName,
    };

      this.stompClient.publish({
       destination: '/session.join',
        body: JSON.stringify(message),
      });
  }

  submitRestaurant(restaurant: string) {
    // Logic to submit a restaurant
    // Call the sessionService to submit the restaurant
  }

  endSession() {
    // Logic to end the session
    // Call the sessionService to end the session
  }


}
