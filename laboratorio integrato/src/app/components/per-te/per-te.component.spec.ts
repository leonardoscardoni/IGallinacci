import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerTeComponent } from './per-te.component';

describe('PerTeComponent', () => {
  let component: PerTeComponent;
  let fixture: ComponentFixture<PerTeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PerTeComponent]
    });
    fixture = TestBed.createComponent(PerTeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
