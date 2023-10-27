import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CallRecordsComponent } from './call-records.component';

describe('CallRecordsComponent', () => {
  let component: CallRecordsComponent;
  let fixture: ComponentFixture<CallRecordsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CallRecordsComponent]
    });
    fixture = TestBed.createComponent(CallRecordsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
