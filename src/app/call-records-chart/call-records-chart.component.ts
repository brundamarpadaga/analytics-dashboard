import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Chart } from 'chart.js';
import { AnalyticsService } from '../analytics.service';

@Component({
  selector: 'app-call-records-chart',
  templateUrl: './call-records-chart.component.html',
  styleUrls: ['./call-records-chart.component.css']
})
export class CallRecordsChartComponent implements OnInit {

  

  public barChartOptions = {
    scaleShowVerticalLines: false,
    maintainAspectRatio: false,
    responsive: true,
    scales: {
      x: {
        beginAtZero: true,
        title: {
          display: true,
          text: 'At Hour', // Label for Y-axis
        }, // You can customize this option
      },
      y: {
        beginAtZero: true, // You can customize this option
        title: {
          display: true,
          text: 'Number of Calls', // Label for Y-axis
        },
      },
    },
  };

  public barChartLabels = Array.from({ length: 24 }, (_, i) => i.toString());
  public barChartType = 'bar';
  public barChartLegend = false;

  public barChartData : { head : string,data: number[], label: string }[]= [
    {head:"", data: [], label: 'Call Records Count' }
  ];

  constructor(private http: HttpClient, private analyticsService : AnalyticsService) {}

  ngOnInit() {
    this.analyticsService.getCallRecordsHourlyCount()
      .subscribe(hourlyCounts => {
        this.barChartData[0].head = 'at Time';
        this.barChartData[0].data = hourlyCounts;
      });
  }

}