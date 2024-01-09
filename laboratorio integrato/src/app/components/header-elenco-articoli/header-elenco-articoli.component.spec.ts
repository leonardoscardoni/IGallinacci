import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderElencoArticoliComponent } from './header-elenco-articoli.component';

describe('HeaderElencoArticoliComponent', () => {
  let component: HeaderElencoArticoliComponent;
  let fixture: ComponentFixture<HeaderElencoArticoliComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HeaderElencoArticoliComponent]
    });
    fixture = TestBed.createComponent(HeaderElencoArticoliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
