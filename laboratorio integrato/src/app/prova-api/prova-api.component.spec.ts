import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProvaApiComponent } from './prova-api.component';

describe('ProvaApiComponent', () => {
  let component: ProvaApiComponent;
  let fixture: ComponentFixture<ProvaApiComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProvaApiComponent]
    });
    fixture = TestBed.createComponent(ProvaApiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
