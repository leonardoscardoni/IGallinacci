import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatiGeneraliComponent } from './dati-generali.component';

describe('DatiGeneraliComponent', () => {
  let component: DatiGeneraliComponent;
  let fixture: ComponentFixture<DatiGeneraliComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DatiGeneraliComponent]
    });
    fixture = TestBed.createComponent(DatiGeneraliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
