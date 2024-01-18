import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderDettaglioTeamComponent } from './header-dettaglio-team.component';

describe('HeaderDettaglioTeamComponent', () => {
  let component: HeaderDettaglioTeamComponent;
  let fixture: ComponentFixture<HeaderDettaglioTeamComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HeaderDettaglioTeamComponent]
    });
    fixture = TestBed.createComponent(HeaderDettaglioTeamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
