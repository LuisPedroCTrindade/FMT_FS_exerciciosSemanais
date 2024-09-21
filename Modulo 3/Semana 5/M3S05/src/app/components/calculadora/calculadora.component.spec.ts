import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalculadoraComponent } from './calculadora.component';

describe('CalculadoraComponent', () => {
  let component: CalculadoraComponent;
  let fixture: ComponentFixture<CalculadoraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CalculadoraComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CalculadoraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('deve validar se a variável num1 foi inicializada', () => {
    expect(component.num1).toBeDefined();
  });
  
  it('deve validar se a variável num2 foi inicializada', () => {
    expect(component.num2).toBeDefined();
  });

  it('deve somar 2 números corretamente', () => {
    component.num1 = 2;
    component.num2 = 6;
    component.somarValores();

    expect(component.result).toBe(8);
  });
  
  it('deve subtrair 2 números corretamente', () => {
    component.num1 = 10;
    component.num2 = 6;
    component.subtrairValores();

    expect(component.result).toBe(4);
  });
  
  it('deve multiplicar 2 números corretamente', () => {
    component.num1 = 10;
    component.num2 = 6;
    component.multiplicarValores();

    expect(component.result).toBe(60);
  });

  it('deve dividir 2 números corretamente', () => {
    component.num1 = 10;
    component.num2 = 5;
    component.dividirValores();

    expect(component.result).toBe(2);
  });

  it('deve retornar resultado correto da soma', () => {
    expect(component.result).toEqual(component.num1 + component.num2);
  });

});
