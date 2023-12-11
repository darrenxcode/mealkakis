import { Injectable } from '@angular/core';
import { Client, Stomp, StompConfig } from '@stomp/stompjs';


@Injectable({
  providedIn: 'root'
})
export class SessionService {
  private stompClient: Client;
  constructor() {
    this.connect();
    this.stompClient = new Client();

  }
  
  public connect() {
    var val = Math.floor(1000 + Math.random() * 9000);
    var url :string = 'ws://localhost:8080/ws/123/'+val+'/websocket'

    const stompConfig: StompConfig = {
      brokerURL: url, // Replace with your WebSocket server URL
      connectHeaders: {},
      heartbeatIncoming: 0,
      heartbeatOutgoing: 20000,
      reconnectDelay: 5000

    };

    this.stompClient = new Client(stompConfig);
    console.log("WebsocketHandshake" , this.stompClient);

    this.stompClient.activate();
    
    } 
  


}

