import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LaSquadraComponent } from './la-squadra.component';

describe('LaSquadraComponent', () => {
  let component: LaSquadraComponent;
  let fixture: ComponentFixture<LaSquadraComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LaSquadraComponent]
    });
    fixture = TestBed.createComponent(LaSquadraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
