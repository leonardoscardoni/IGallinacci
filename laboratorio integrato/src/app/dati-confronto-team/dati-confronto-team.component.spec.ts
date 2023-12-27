import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatiConfrontoTeamComponent } from './dati-confronto-team.component';

describe('DatiConfrontoTeamComponent', () => {
  let component: DatiConfrontoTeamComponent;
  let fixture: ComponentFixture<DatiConfrontoTeamComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DatiConfrontoTeamComponent]
    });
    fixture = TestBed.createComponent(DatiConfrontoTeamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
