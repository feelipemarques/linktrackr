import { TestBed } from '@angular/core/testing';

import { ShortLink } from './short-link';

describe('ShortLink', () => {
  let service: ShortLink;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShortLink);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
