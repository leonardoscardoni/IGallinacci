import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderBgTitoloComponent } from './header-bg-titolo.component';

describe('HeaderBgTitoloComponent', () => {
  let component: HeaderBgTitoloComponent;
  let fixture: ComponentFixture<HeaderBgTitoloComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HeaderBgTitoloComponent]
    });
    fixture = TestBed.createComponent(HeaderBgTitoloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
