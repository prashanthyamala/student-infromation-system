import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrationsAddComponent } from './registrations-add.component';

describe('RegistrationsAddComponent', () => {
  let component: RegistrationsAddComponent;
  let fixture: ComponentFixture<RegistrationsAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistrationsAddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrationsAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
