import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AnalyticsService } from '../analytics.service';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {


  averageDuration!: number;

  constructor(private router: Router,private analyticsService: AnalyticsService) {}

  ngOnInit(): void {
    this.analyticsService.getAverageCallDuration().subscribe((duration) => {
      this.averageDuration = duration;
    });
  }


  goToSubscribersPage() {
    this.router.navigate(['/subscribers']);
  }
  goToPlansPage() {
    this.router.navigate(['/plans']);
  }
  goToCallRecordsPage() {
    this.router.navigate(['/call-records']);
  }




  
}
