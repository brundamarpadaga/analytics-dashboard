import { TestBed } from '@angular/core/testing';

import { CallRecordsService } from './call-records.service';

describe('CallRecordsService', () => {
  let service: CallRecordsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CallRecordsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
