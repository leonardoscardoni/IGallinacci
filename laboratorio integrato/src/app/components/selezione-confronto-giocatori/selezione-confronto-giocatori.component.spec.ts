import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelezioneConfrontoGiocatoriComponent } from './selezione-confronto-giocatori.component';

describe('SelezioneConfrontoGiocatoriComponent', () => {
  let component: SelezioneConfrontoGiocatoriComponent;
  let fixture: ComponentFixture<SelezioneConfrontoGiocatoriComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SelezioneConfrontoGiocatoriComponent]
    });
    fixture = TestBed.createComponent(SelezioneConfrontoGiocatoriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
