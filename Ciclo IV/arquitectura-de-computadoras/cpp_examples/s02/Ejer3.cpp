#include <iostream>

int main(){
  int edad;
  char nombre[20], sexo[20];
  float height;

  std::cout<<"Ingresar tu nombre: ";
  std::cin>>nombre;

  std::cout<<"Ingresar tu sexo: ";
  std::cin>>sexo;

  std::cout<<"Ingresar tu edad: ";
  std::cin>>edad;

  std::cout<<"Ingresar tu altura (metros): ";
  std::cin>>height;

  std::cout<<"Ya sé todo de ti, tú nombre es "<<nombre;
  std::cout<<", te consideras de sexo \""<<sexo<<"\"\n";
  std::cout<<"tu edad es "<<edad;
  std::cout<<" y mides "<<height<<" metos";

  return 0;
}