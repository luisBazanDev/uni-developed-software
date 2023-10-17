/*
  Hallar la raíz cuadrada de un número.
*/

#include<iostream>
#include<cmath>

int main(){
  double number, sqrt;

  std::cout<<"Ingrese un número: ";
  std::cin>>number;
  
  if (number > 0)
  {
    sqrt = std::sqrt(number);
    std::cout<<"La raiz es: "<<sqrt;
  } else {
    std::cout<<"El número no puede ser negativo";
  }
  

  return 0;
}