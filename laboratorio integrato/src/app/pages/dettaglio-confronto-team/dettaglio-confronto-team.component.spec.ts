import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettaglioConfrontoTeamComponent } from './dettaglio-confronto-team.component';

describe('DettaglioConfrontoTeamComponent', () => {
  let component: DettaglioConfrontoTeamComponent;
  let fixture: ComponentFixture<DettaglioConfrontoTeamComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DettaglioConfrontoTeamComponent]
    });
    fixture = TestBed.createComponent(DettaglioConfrontoTeamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
