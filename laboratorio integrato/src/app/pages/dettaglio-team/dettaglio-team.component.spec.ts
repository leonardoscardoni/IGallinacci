import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettaglioTeamComponent } from './dettaglio-team.component';

describe('DettaglioTeamComponent', () => {
  let component: DettaglioTeamComponent;
  let fixture: ComponentFixture<DettaglioTeamComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DettaglioTeamComponent]
    });
    fixture = TestBed.createComponent(DettaglioTeamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
