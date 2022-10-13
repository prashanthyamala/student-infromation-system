import { TestBed } from '@angular/core/testing';

import { SisappService } from './sisapp.service';

describe('SisappService', () => {
  let service: SisappService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SisappService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
