import { Component } from '@angular/core';
import { SmsRecordsService } from '../sms-records.service';
import { SmsRecord } from '../sms-record';

@Component({
  selector: 'app-sms-records',
  templateUrl: './sms-records.component.html',
  styleUrls: ['./sms-records.component.css']
})
export class SmsRecordsComponent {
  smsRecords: SmsRecord[] = [];
  filteredSmsRecords: SmsRecord[] = [];
  subscriberFilter: string = '';

  constructor(private smsRecordService: SmsRecordsService) { }

  ngOnInit(): void {
    this.smsRecordService.getAllSmsRecordsDTO().subscribe((data) => {
      this.smsRecords = data;
      this.applyFilter();
    });
  }

  applyFilter() {
    this.filteredSmsRecords = this.smsRecords.filter(
      (record) =>
        record.subscriberID.toLowerCase().includes(this.subscriberFilter.toLowerCase())
    );
  }

}
