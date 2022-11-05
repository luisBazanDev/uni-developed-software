1. Realizar un pseudocódigo que imprima los números impares entre 0 y 50
2. Construir un programa que pida ingresar un número, luego muestre la tabla de multiplicar de dicho número del 1 al 12.
3. Desarrollar un pseudocódigo que luego de ingresar 2 números naturales imprima los números naturales que hay entre ambos empezando por el menor. Asumimos que el usuario ingresa dos números diferentes y el segundo es mayor que el primero.
4. Calcular el precio total de una compra de “n” productos (el valor “n” se ingresa por teclado) si se ingresa el precio de cada producto y la cantidad comprada de este.

---

# Ejercicio 1

```psc
Algoritmo Ejer1
	Definir final Como Real
	final = 50
	Para i = 0 Hasta 50 Hacer
		Si i mod 2 <> 0 Entonces
			Escribir "Numero impar: ", i
		FinSi
	FinPara
FinAlgoritmo
```

# Ejercicio 2

```psc
Algoritmo Ejer2
	Definir num Como Real
	Escribir "Ingresar número"
	Leer num

	Escribir "Tabla del ", num
	Para i = 1 Hasta 12 Hacer
		Escribir num, " x ", i, " = ", num * i
	FinPara
FinAlgoritmo
```

# Ejercicio 3

```psc
Algoritmo Ejer3
	Definir n1, n2, nmen, nmay Como Real
	Escribir "Ingresar números"
	Leer n1, n2

	Si n1 < n2 Entonces
		nmen = n1
		nmay = n2
	SiNo
		nmen = n2
		nmay = n1
	FinSi

	Escribir "Los números intermedios son:"
	Para i = nmen + 1 Hasta nmay - 1 Hacer
		Escribir i
	FinPara
FinAlgoritmo
```

# Ejercicio 4

```psc
Algoritmo Ejer4
	Definir cant, precio, total, productos Como Real
	Escribir "Ingrese la cantidad de productos a comprar:"
	Leer productos
	Para i = 1 Hasta productos Hacer
		Escribir "Ingrese precio de producto N°", i
		Leer precio

		Escribir "Ingrese cantidad de productos N°", i
		Leer cant

		total = total + (precio * cant)
	FinPara

	Escribir "La cantidad total fue de s/", total
FinAlgoritmo
```
