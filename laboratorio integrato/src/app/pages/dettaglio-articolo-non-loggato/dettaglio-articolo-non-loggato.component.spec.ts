import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettaglioArticoloNonLoggatoComponent } from './dettaglio-articolo-non-loggato.component';

describe('DettaglioArticoloNonLoggatoComponent', () => {
  let component: DettaglioArticoloNonLoggatoComponent;
  let fixture: ComponentFixture<DettaglioArticoloNonLoggatoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DettaglioArticoloNonLoggatoComponent]
    });
    fixture = TestBed.createComponent(DettaglioArticoloNonLoggatoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
