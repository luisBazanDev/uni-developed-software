# Task Week 7

1. Ingrese un numero natural de dos cifras y muestre el mensaje “Es capicúa” o “No es capicúa” según sea el caso.
2. Crear una calculadora de división en pseudocódigo, que permita ingresar dos números y muestre el cociente. En caso de ingresar cero en el divisor nos debe decir: "No se puede dividir entre cero"
3. Realizar un algoritmo que pida dos números enteros, luego muestre el mayor. Considere que se ingresan valores diferentes.
4. Realizar un pseudocódigo que pida ingresar un número natural, en caso sea superior 100 se mostrará su 30% de no ser así visualice su 150%
5. Elaborar un pseudocódigo donde se ingrese por teclado un número natural de hasta 2 cifras, si tiene una cifra muestre lo mínimo que le falta para ser un número de 2 cifras; de lo contrario muestre lo mínimo que le falta para ser un número de 3 cifras. Considerar, que el usuario ingresa números de hasta dos cifras.

---

# Ejercicio 1

```psc
Algoritmo Ejer_1
	Definir num Como Entero
	Escribir "Ingrese un número de dos cifras"
	Leer num
	Si num MOD 11 = 0 Entonces
		Escribir num, " es capicúa"
	SiNo
		Escribir num, " no es capicúa"
	FinSi
FinAlgoritmo
```

# Ejercicio 2

```psc
Algoritmo Ejer_2
	Definir a, b Como Real
	Escribir "Ingrese dos números"
	Leer a, b
	Si b<>0 Entonces
		Escribir a , " ÷ ", b, " = ", (a/b)
	SiNo
		Escribir "No se puede dividir entre cero"
	FinSi
FinAlgoritmo
```

# Ejercicio 3

```psc
Algoritmo Ejer_3
	Definir a, b Como Real

	Escribir "Ingresar 2 números, para encontrar el mayor:"
	Leer a, b

	Si a > b Entonces
		Escribir a, " es mayor  que ", b
	SiNo
		Si a == b Entonces
			Escribir a, " es igual a ", b
		SiNo
			Escribir b, " es mayor que ", a
		FinSi
	FinSi
FinAlgoritmo
```

# Ejercicio 4

```psc
Algoritmo Ejer_4
	Definir num Como Real

	Escribir "Ingresar número"
	Leer num

	Si num - trunc(num) <> 0 o num < 0 Entonces
		Escribir "El número no es natural"
	SiNo
		Si num > 100 Entonces
			Escribir "El 30% de ", num, " es ", num * 0.3
		SiNo
			Escribir "El 150% de ", num, " es ", num * 1.5
		FinSi
	FinSi
FinAlgoritmo
```

# Ejercicio 5

```psc
Algoritmo Ejer_5
	Definir num Como Real

	Escribir "Ingresar número"
	Leer num

	Si num - trunc(num) <> 0 o num < 0 o num > 99 Entonces
		Escribir "El número no es naturales de 2 cifras"
	SiNo
		Si num < 10 Entonces
			Escribir "El número es de 1 cifra, sumale ", 10 - num
		SiNo
			Escribir "Número correcto"
		FinSi
	FinSi
FinAlgoritmo
```
