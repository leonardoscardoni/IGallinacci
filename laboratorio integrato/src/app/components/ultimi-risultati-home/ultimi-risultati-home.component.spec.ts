import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UltimiRisultatiHomeComponent } from './ultimi-risultati-home.component';

describe('UltimiRisultatiHomeComponent', () => {
  let component: UltimiRisultatiHomeComponent;
  let fixture: ComponentFixture<UltimiRisultatiHomeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UltimiRisultatiHomeComponent]
    });
    fixture = TestBed.createComponent(UltimiRisultatiHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
