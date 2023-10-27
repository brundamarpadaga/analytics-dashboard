import { TestBed } from '@angular/core/testing';

import { SmsRecordsService } from './sms-records.service';

describe('SmsRecordsService', () => {
  let service: SmsRecordsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SmsRecordsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
