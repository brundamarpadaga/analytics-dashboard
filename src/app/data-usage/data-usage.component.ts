import { Component } from '@angular/core';
import { Subscriber } from '../subscriber';
import { SubscribersService } from '../subscribers.service';
import { OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-data-usage',
  templateUrl: './data-usage.component.html',
  styleUrls: ['./data-usage.component.css']
})

export class DataUsageComponent implements OnInit {
  selectedSubscriberId: string = '';
  dataUsed: number = 0;
  message: string = '';
  subscribers: Subscriber[] = []; // You need to fetch this list from your backend

  constructor(private dataService: DataService,private subscribersService:SubscribersService) {}

  ngOnInit(): void {
    // Fetch the list of subscribers from your backend service.
    this.subscribersService.getAllSubscribers().subscribe((subscribers) => {
      this.subscribers = subscribers;
    });
  }

  useData() {
    // Call your service to use data.
    this.dataService.useData(this.dataUsed, this.selectedSubscriberId).subscribe((res) => {
      console.log(res);
      
    });
  }
}
