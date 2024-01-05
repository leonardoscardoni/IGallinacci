import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticoloLoggatoComponent } from './articolo-loggato.component';

describe('ArticoloLoggatoComponent', () => {
  let component: ArticoloLoggatoComponent;
  let fixture: ComponentFixture<ArticoloLoggatoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ArticoloLoggatoComponent]
    });
    fixture = TestBed.createComponent(ArticoloLoggatoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
