import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettGiocatoreIndipendenteComponent } from './dett-giocatore-indipendente.component';

describe('DettGiocatoreIndipendenteComponent', () => {
  let component: DettGiocatoreIndipendenteComponent;
  let fixture: ComponentFixture<DettGiocatoreIndipendenteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DettGiocatoreIndipendenteComponent]
    });
    fixture = TestBed.createComponent(DettGiocatoreIndipendenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
