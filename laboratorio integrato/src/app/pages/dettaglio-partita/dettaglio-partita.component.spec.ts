import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettaglioPartitaComponent } from './dettaglio-partita.component';

describe('DettaglioPartitaComponent', () => {
  let component: DettaglioPartitaComponent;
  let fixture: ComponentFixture<DettaglioPartitaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DettaglioPartitaComponent]
    });
    fixture = TestBed.createComponent(DettaglioPartitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
