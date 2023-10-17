/*
Ingresa tres numero distintos y muestra el mayor de ellos.
*/

#include<iostream>
#include<cmath>

int main(){
  int numbers[3];

  std::cout<<"Ingrese el numero #1: ";
  std::cin>>numbers[0];

  std::cout<<"Ingrese el numero #2: ";
  std::cin>>numbers[1];

  std::cout<<"Ingrese el numero #3: ";
  std::cin>>numbers[2];

  if (numbers[0] > numbers[1] && numbers[0] > numbers[2])
  {
    std::cout<<"El número mayor es: "<<numbers[0];
  } else if (numbers[1] > numbers[2] && numbers[1] > numbers[0])
  {
    std::cout<<"El número mayor es: "<<numbers[1];
  } else {
    std::cout<<"El número mayor es: "<<numbers[2];
  }

  return 0;
}