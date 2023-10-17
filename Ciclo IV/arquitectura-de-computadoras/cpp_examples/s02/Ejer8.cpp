/*
  Ingrese nombre, 4 notas de un estudiante y calcular el promedio
  y mostrar si esta aprobado o no
*/

#include <iostream>

int main(){
  float initialPrice, finalPrice, desc1, desc2;

  std::cout<<"Ingresa el precio final: ";
  std::cin>>initialPrice;

  desc1 = initialPrice * 0.38;
  finalPrice = initialPrice - desc1;

  desc2 = finalPrice * 0.62;

  finalPrice = finalPrice - desc2;


  std::cout<<"Precio inicial: "<<initialPrice;
  std::cout<<"\nDescuento 1 (38%): "<<desc1;
  std::cout<<"\nPrecio 1: "<<finalPrice;
  std::cout<<"\nPrecio final: "<<desc2;


  return 0;
}