import { Component, OnInit } from '@angular/core';
import { SubscribersService } from '../subscribers.service';
import { SubscribersResponse } from '../subscribers-response';

@Component({
  selector: 'app-subscribers',
  templateUrl: './subscribers.component.html',
  styleUrls: ['./subscribers.component.css']
})
export class SubscribersComponent implements OnInit {
  subscriberResponse ?: SubscribersResponse[];

  constructor(private subscribersService : SubscribersService){}
  ngOnInit(): void {

    this.getSubscribers();
      
  }

  getSubscribers():void{
    this.subscribersService.getAllSubscribersWithPlanPrice().subscribe((data:SubscribersResponse[]) =>{
      this.subscriberResponse = data;
    });
  }
}
