import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSmsRecordComponent } from './add-sms-record.component';

describe('AddSmsRecordComponent', () => {
  let component: AddSmsRecordComponent;
  let fixture: ComponentFixture<AddSmsRecordComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddSmsRecordComponent]
    });
    fixture = TestBed.createComponent(AddSmsRecordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
