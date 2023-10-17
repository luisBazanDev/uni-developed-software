/*
  Ingresa un npumero e indica si es par o impar
*/

#include <iostream>

int main(){
  int number;

  std::cout<<"Ingresar el número: ";
  std::cin>>number;
  if (number%2 == 0)
  {
    std::cout<<"Es un número par";
  } else {

    std::cout<<"Es un número impar";
  }
  
  return 0;
}