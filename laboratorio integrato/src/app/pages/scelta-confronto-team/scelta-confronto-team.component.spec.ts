import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SceltaConfrontoTeamComponent } from './scelta-confronto-team.component';

describe('SceltaConfrontoTeamComponent', () => {
  let component: SceltaConfrontoTeamComponent;
  let fixture: ComponentFixture<SceltaConfrontoTeamComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SceltaConfrontoTeamComponent]
    });
    fixture = TestBed.createComponent(SceltaConfrontoTeamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
