import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CallRecordsChartComponent } from './call-records-chart.component';

describe('CallRecordsChartComponent', () => {
  let component: CallRecordsChartComponent;
  let fixture: ComponentFixture<CallRecordsChartComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CallRecordsChartComponent]
    });
    fixture = TestBed.createComponent(CallRecordsChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
