/*
El papá de José va al colegio de niños a preguntar por sus notas
de un curso a la docente y desarrolla el siguiente calculo:
Ingresa 4 notas y muestra el promedio e indica si el estudiante
según su promedio da un mensaje de aprobado o desaprobado. (nota 14)
*/

#include<iostream>
#include<cmath>

int main(){
  int n1, n2, n3, n4;
  double promedio;


  std::cout<<"Ingrese nota #1: ";
  std::cin>>n1;

  std::cout<<"Ingrese nota #2: ";
  std::cin>>n2;

  std::cout<<"Ingrese nota #3: ";
  std::cin>>n3;

  std::cout<<"Ingrese nota #4: ";
  std::cin>>n4;

  promedio = n1 + n2 + n3 +n4;
  promedio /= 4;

  std::cout<<"El promedio de la nota es: "<<promedio;

  return 0;
}