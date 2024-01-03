import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelezioneConfrontoSquadreComponent } from './selezione-confronto-squadre.component';

describe('SelezioneConfrontoSquadreComponent', () => {
  let component: SelezioneConfrontoSquadreComponent;
  let fixture: ComponentFixture<SelezioneConfrontoSquadreComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SelezioneConfrontoSquadreComponent]
    });
    fixture = TestBed.createComponent(SelezioneConfrontoSquadreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
