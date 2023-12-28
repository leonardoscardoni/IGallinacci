import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatiPrincipaliComponent } from './dati-principali.component';

describe('DatiPrincipaliComponent', () => {
  let component: DatiPrincipaliComponent;
  let fixture: ComponentFixture<DatiPrincipaliComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DatiPrincipaliComponent]
    });
    fixture = TestBed.createComponent(DatiPrincipaliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
