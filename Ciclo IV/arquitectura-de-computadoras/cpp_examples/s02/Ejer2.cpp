#include <iostream>

int main(){
  int n1, n2;
  int suma, resta, multiplicacion;
  float division = 0;

  std::cout<<"Ingresar primer número: ";
  std::cin>>n1;

  std::cout<<"Ingresar segundo número: ";
  std::cin>>n1;

  suma = n1 + n2;
  resta = n1 - n2;
  multiplicacion = n1 * n2;
  
  if (n2 == 0)
  {
    division = n1 / n2;
  } else {
    std::cout<<"Números ingresados invalidos";
  }

  std::cout<<"\nSuma: "<<suma;
  std::cout<<"\nResta: "<<resta;
  std::cout<<"\nMulti: "<<multiplicacion;
  std::cout<<"\nDiv: "<<division;

  return 0;
}