import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCallRecordComponent } from './add-call-record.component';

describe('AddCallRecordComponent', () => {
  let component: AddCallRecordComponent;
  let fixture: ComponentFixture<AddCallRecordComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddCallRecordComponent]
    });
    fixture = TestBed.createComponent(AddCallRecordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
