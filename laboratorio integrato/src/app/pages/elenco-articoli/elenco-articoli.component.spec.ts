import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElencoArticoliComponent } from './elenco-articoli.component';

describe('ElencoArticoliComponent', () => {
  let component: ElencoArticoliComponent;
  let fixture: ComponentFixture<ElencoArticoliComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ElencoArticoliComponent]
    });
    fixture = TestBed.createComponent(ElencoArticoliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
