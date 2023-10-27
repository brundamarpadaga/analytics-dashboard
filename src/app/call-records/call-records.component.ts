import { Component } from '@angular/core';
import { WebSocketService } from '../web-socket.service';
import { CallRecord } from '../call-record';
import { CallRecordsService } from '../call-records.service';

@Component({
  selector: 'app-call-records',
  templateUrl: './call-records.component.html',
  styleUrls: ['./call-records.component.css']
})
export class CallRecordsComponent {

  callRecords: CallRecord[] = [];
  searchSubscriberId: string = '';

  constructor(private callRecordService: CallRecordsService) { }

  ngOnInit(): void {
    this.getCallRecords();
  }

  getCallRecords() {
    this.callRecordService.getAllCallRecords().subscribe(records => {
      this.callRecords = records;
    });
  }

  // call-records.component.ts
searchCallRecords() {
  if (this.searchSubscriberId) {
    this.callRecordService.getCallRecordsBySubscriberId(this.searchSubscriberId)
      .subscribe(data => {
        this.callRecords = data;
      });
  } else {
    this.callRecordService.getAllCallRecords().subscribe(records => {
      this.callRecords = records;
    });
  }
}
  formatCallDuration(seconds: number): string {
    const hours = Math.floor(seconds / 3600);
    const minutes = Math.floor((seconds % 3600) / 60);
    const remainingSeconds = seconds % 60;
  
    // Use String padding to format hours, minutes, and seconds with leading zeros
    const formattedHours = hours.toString().padStart(2, '0');
    const formattedMinutes = minutes.toString().padStart(2, '0');
    const formattedSeconds = remainingSeconds.toString().padStart(2, '0');
  
    return `${formattedHours}:${formattedMinutes}:${formattedSeconds}`;
  }
}
