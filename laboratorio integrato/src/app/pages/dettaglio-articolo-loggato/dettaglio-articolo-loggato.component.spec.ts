import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettaglioArticoloLoggatoComponent } from './dettaglio-articolo-loggato.component';

describe('DettaglioArticoloLoggatoComponent', () => {
  let component: DettaglioArticoloLoggatoComponent;
  let fixture: ComponentFixture<DettaglioArticoloLoggatoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DettaglioArticoloLoggatoComponent]
    });
    fixture = TestBed.createComponent(DettaglioArticoloLoggatoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
