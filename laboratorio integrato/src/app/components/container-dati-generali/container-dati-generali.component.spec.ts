import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContainerDatiGeneraliComponent } from './container-dati-generali.component';

describe('ContainerDatiGeneraliComponent', () => {
  let component: ContainerDatiGeneraliComponent;
  let fixture: ComponentFixture<ContainerDatiGeneraliComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ContainerDatiGeneraliComponent]
    });
    fixture = TestBed.createComponent(ContainerDatiGeneraliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
