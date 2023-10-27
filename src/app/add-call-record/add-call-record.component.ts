import { Component } from '@angular/core';
import { CallRecordsService } from '../call-records.service';
import { Subscriber } from '../subscriber';
import { SubscribersService } from '../subscribers.service';
import { CallRecord } from '../call-record';
@Component({
  selector: 'app-add-call-record',
  templateUrl: './add-call-record.component.html',
  styleUrls: ['./add-call-record.component.css']
})
export class AddCallRecordComponent {
  subscribers: Subscriber[] = [];
  selectedSubscriberId!: string;
  phoneNumber: string = '';
  activeCalls: CallRecord[] = [];


  constructor(private callRecordService: CallRecordsService, private subscriberService: SubscribersService) { }

  ngOnInit(): void {
    this.getSubscribers();
    this.getActiveCallRecords();
  }

  getSubscribers() {
    this.subscriberService.getAllSubscribers().subscribe(subscribers => {
      this.subscribers = subscribers;
    });
  }

  getActiveCallRecords() {
    this.callRecordService.getActiveCallRecords().subscribe((data) => {
      this.activeCalls = data;
    });
  }

  loadActiveCalls() {
    this.getActiveCallRecords();
  }

  startCall() {
    if (this.selectedSubscriberId && this.phoneNumber) {
      this.callRecordService.createCallRecord(this.selectedSubscriberId, this.phoneNumber).subscribe((res) => {
        console.log(res);
        this.ngOnInit();
      });
    }
  }

  endCall(callRecordId: string) {
    this.callRecordService.endCall(callRecordId).subscribe((res) => {
      console.log(res);
      this.ngOnInit();
      
    });
  }
}
