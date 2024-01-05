import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticoloLoggatoSectionComponent } from './articolo-loggato-section.component';

describe('ArticoloLoggatoSectionComponent', () => {
  let component: ArticoloLoggatoSectionComponent;
  let fixture: ComponentFixture<ArticoloLoggatoSectionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ArticoloLoggatoSectionComponent]
    });
    fixture = TestBed.createComponent(ArticoloLoggatoSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
