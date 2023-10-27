import { Component } from '@angular/core';
import { SubscriberUsage } from '../subscriber-usage';
import { ActivatedRoute } from '@angular/router';
import { UsageService } from '../usage.service';
import { DataLeftDto } from '../data-left-dto';
import { ChartType, ChartOptions, ChartData } from 'chart.js';



@Component({
  selector: 'app-subscriber-usage-details',
  templateUrl: './subscriber-usage-details.component.html',
  styleUrls: ['./subscriber-usage-details.component.css']
})
export class SubscriberUsageDetailsComponent {
  subscriberId !: string;
  subscriberUsage !: SubscriberUsage;
  dataLeft! : DataLeftDto;

 

  public pieChartOptions: ChartOptions = {
    responsive: true,
    maintainAspectRatio: false, // Set this to false to control width and height
   
  };

  //public pieChartLabels: Label[] = ['Data Left (MB)', 'Total Data (MB)'];
  public pieChartData: ChartData = {datasets: [], labels: []};
  public pieChartType: ChartType = 'doughnut';
  public pieChartLegend = true;
  public pieChartPlugins = [];



  constructor(private route: ActivatedRoute, private usageService: UsageService) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.subscriberId = params['subscriberId'];
      this.loadSubscriberUsage();
      
    });
    
  }

  loadSubscriberUsage() {
    this.usageService.getSubscriberUsage(this.subscriberId).subscribe((usage) => {
      this.subscriberUsage = usage;
      this.loadDataLeft();
    });
  }

  loadDataLeft() {
    this.usageService.getDataLeft(this.subscriberUsage.id).subscribe((data:DataLeftDto) => {
      this.dataLeft = data;
      this.pieChartData = {datasets: [{data: [this.dataLeft.dataLeft,this.dataLeft.totalData - this.dataLeft.dataLeft]}],
                            labels: ['Data remaining', 'Data used']};
      console.log(this.dataLeft);
    });
  }

}
