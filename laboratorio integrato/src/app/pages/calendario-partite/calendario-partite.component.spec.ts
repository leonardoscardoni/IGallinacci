import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalendarioPartiteComponent } from './calendario-partite.component';

describe('CalendarioPartiteComponent', () => {
  let component: CalendarioPartiteComponent;
  let fixture: ComponentFixture<CalendarioPartiteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CalendarioPartiteComponent]
    });
    fixture = TestBed.createComponent(CalendarioPartiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
