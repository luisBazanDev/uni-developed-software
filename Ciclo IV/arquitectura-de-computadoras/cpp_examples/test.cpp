#include <iostream>

int main(){
  char name[20];
  int cycle;
  char study[20];
  char race[20];

  std::cout<<"Introduce nombre: ";
  std::cin>>name;

  std::cout<<"Introduce ciclo: ";
  std::cin>>cycle;
  
  std::cout<<"Introduce estudio: ";
  std::cin>>study;
  
  std::cout<<"Introduce carrera: ";
  std::cin>>race;

  std::cout<<"\n";

  std::cout<<"Hola!. Mi nombre es "<<name;
  std::cout<<" estoy en "<<cycle;
  std::cout<<" ciclo y soy estuiante en "<<study;
  std::cout<<" de la carrerra de "<<race;

  return 0;
}