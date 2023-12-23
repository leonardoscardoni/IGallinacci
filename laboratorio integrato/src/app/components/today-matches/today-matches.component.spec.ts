import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TodayMatchesComponent } from './today-matches.component';

describe('TodayMatchesComponent', () => {
  let component: TodayMatchesComponent;
  let fixture: ComponentFixture<TodayMatchesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TodayMatchesComponent]
    });
    fixture = TestBed.createComponent(TodayMatchesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
