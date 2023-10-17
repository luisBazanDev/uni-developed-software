// Ingrese una edad de una persona e indica si es mayor o menor de edad

#include <iostream>

int main(){
  int edad;
  char nombre[20];

  std::cout<<"Ingresar el nombre de la persona: ";
  std::cin>>nombre;

  std::cout<<"Ingresar la edad de la persona: ";
  std::cin>>edad;

  if (edad >= 18)
  {
    std::cout<<nombre<<", es mayor de edad";
  } else {
    std::cout<<nombre<<", es menor de edad";
  }
  

  return 0;
}