#include <iostream>

int main(){
  int number;

  std::cout<<"Ingrese un número: ";
  std::cin>>number;

  if (number >= 10 && number<= 20)
  {
    std::cout<<"Esta dentro del rango";
  } else {
    std::cout<<"Esta afuera del rango";
  }
  
  
  return 0;
}