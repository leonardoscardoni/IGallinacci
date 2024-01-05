import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticoloLoggatoTxtComponent } from './articolo-loggato-txt.component';

describe('ArticoloLoggatoTxtComponent', () => {
  let component: ArticoloLoggatoTxtComponent;
  let fixture: ComponentFixture<ArticoloLoggatoTxtComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ArticoloLoggatoTxtComponent]
    });
    fixture = TestBed.createComponent(ArticoloLoggatoTxtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
