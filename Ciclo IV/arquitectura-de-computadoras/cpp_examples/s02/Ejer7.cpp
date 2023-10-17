/*
  Ingrese nombre, 4 notas de un estudiante y calcular el promedio
  y mostrar si esta aprobado o no
*/

#include <iostream>

int main(){
  int notas[4];
  float promedio;

  std::cout<<"Ingrese nota 1: ";
  std::cin>>notas[0];

  std::cout<<"Ingrese nota 2: ";
  std::cin>>notas[1];

  std::cout<<"Ingrese nota 3: ";
  std::cin>>notas[2];

  std::cout<<"Ingrese nota 4: ";
  std::cin>>notas[3];

  int total = 0;
  for (size_t i = 0; i < sizeof(notas); i++)
  {
    total += notas[i];
  }

  promedio = total / sizeof(notas);

  if (promedio >= 12)
  {
    std::cout<<"Aprobado";
  } else {
    std::cout<<"Jaladaso";
  }
  

  return 0;
}