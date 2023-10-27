import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SmsRecordsComponent } from './sms-records.component';

describe('SmsRecordsComponent', () => {
  let component: SmsRecordsComponent;
  let fixture: ComponentFixture<SmsRecordsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SmsRecordsComponent]
    });
    fixture = TestBed.createComponent(SmsRecordsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
