import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubscriberUsageDetailsComponent } from './subscriber-usage-details.component';

describe('SubscriberUsageDetailsComponent', () => {
  let component: SubscriberUsageDetailsComponent;
  let fixture: ComponentFixture<SubscriberUsageDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SubscriberUsageDetailsComponent]
    });
    fixture = TestBed.createComponent(SubscriberUsageDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
