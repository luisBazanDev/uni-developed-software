/*
Determina el área de un triángulo.
*/

#include<iostream>
#include<cmath>

int main(){
  double base, height, area;

  std::cout<<"Ingrese la base del triangulo: ";
  std::cin>>base;

  std::cout<<"Ingrese la altura del triangulo: ";
  std::cin>>height;

  area = base * height / 2;

  std::cout<<"El area del triangulo es: "<<area;

  return 0;
}