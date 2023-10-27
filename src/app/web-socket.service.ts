import { Injectable } from '@angular/core';
import { Client, StompConfig } from '@stomp/stompjs';

@Injectable({
  providedIn: 'root'
})
export class WebSocketService {

  private stompClient!: Client;
  private connected = false;

  constructor() {
    this.initializeWebSocketConnection();
  }

  private initializeWebSocketConnection() {
    const stompConfig: StompConfig = {
      // Change the URL to match your WebSocket server endpoint
      brokerURL: 'ws://localhost:8080/call-records',
      connectHeaders: {
        // Add any necessary headers, e.g., authentication token
      },
      heartbeatIncoming: 0,
      heartbeatOutgoing: 20000,
      reconnectDelay: 5000,
      debug: (msg: string) => {
        console.log(msg);
      },
    };

    this.stompClient = new Client(stompConfig);

    this.stompClient.onConnect = () => {
      this.connected = true;
    };

    this.stompClient.onDisconnect = () => {
      this.connected = false;
    };
  
  }


  subscribeToCallRecords(callback: (message: any) => void) {
    this.stompClient.subscribe('/topic/call-records', (message) => {
      const callRecord = JSON.parse(message.body);
      callback(callRecord);
    });
  }

  connect() {
    this.stompClient.activate();
  }

  disconnect() {
    this.stompClient.deactivate();
    this.connected = false;
  }
}
