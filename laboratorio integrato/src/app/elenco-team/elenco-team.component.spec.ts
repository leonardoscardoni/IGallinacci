import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElencoTeamComponent } from './elenco-team.component';

describe('ElencoTeamComponent', () => {
  let component: ElencoTeamComponent;
  let fixture: ComponentFixture<ElencoTeamComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ElencoTeamComponent]
    });
    fixture = TestBed.createComponent(ElencoTeamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
