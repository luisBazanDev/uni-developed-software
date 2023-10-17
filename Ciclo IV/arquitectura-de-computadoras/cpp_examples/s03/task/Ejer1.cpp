/*
María se va de compras y la señorita cajera desarrolla lo siguiente:
Ingresa un producto, la cantidad de producto, el precio y luego mostrar
el total de producto comprado.
*/

#include<iostream>
#include<cmath>

int main(){
  char producto[20];
  int cantidad;
  double precio, total;

  std::cout<<"Ingrese el product a comprar: ";
  std::cin>>producto;

  std::cout<<"Ingrese cantidad de producto: ";
  std::cin>>cantidad;

  std::cout<<"Ingrese el precio del producto: ";
  std::cin>>precio;

  total = precio * cantidad;

  std::cout<<"Precio total de la compra de "<<producto;
  std::cout<<" es de s/"<<total;


  return 0;
}