import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PosizioneInClassificaComponent } from './posizione-in-classifica.component';

describe('PosizioneInClassificaComponent', () => {
  let component: PosizioneInClassificaComponent;
  let fixture: ComponentFixture<PosizioneInClassificaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PosizioneInClassificaComponent]
    });
    fixture = TestBed.createComponent(PosizioneInClassificaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
