/*
  Calcular el sueldo de un empleado de horas diarias de trabajo y
  cada hora tiene un costo de 20 so, tiene horas extra costo 30

  Si el cueldo es mayor a 1000 so, pagar un impuesto de 9%
  
*/

#include <iostream>

int main(){
  int hours, extra_hours;
  double imp, total;

  std::cout<<"Ingrese la cantidad de horas trabajadas: ";
  std::cin>>hours;
  
  std::cout<<"Ingrese la cantidad de horas extra trabajadas: ";
  std::cin>>extra_hours;

  total = hours * 20 + extra_hours * 30;

  if (total > 1000)
  {
    imp = total * 0.9;
  }


  std::cout<<"Sueldo de:    s/"<<total;
  std::cout<<"\nImpuesto:    -s/"<<imp;
  std::cout<<"\nSueldo final: s/"<<total - imp;


  return 0;
}