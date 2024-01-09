import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SceltaConfrontoGiocatoriComponent } from './scelta-confronto-giocatori.component';

describe('SceltaConfrontoGiocatoriComponent', () => {
  let component: SceltaConfrontoGiocatoriComponent;
  let fixture: ComponentFixture<SceltaConfrontoGiocatoriComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SceltaConfrontoGiocatoriComponent]
    });
    fixture = TestBed.createComponent(SceltaConfrontoGiocatoriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
