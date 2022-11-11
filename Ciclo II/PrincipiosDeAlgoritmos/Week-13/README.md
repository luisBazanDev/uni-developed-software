1. Crear un algoritmo en pseudocódigo que permita ingresar un número positivo y muestre el número de cifras de este.
2. Construir un programa que pida ingresar un número, luego muestre la tabla de multiplicar de dicho número del 1 al 12. Emplear la estructura repetitiva MIENTRAS.
3. Desarrollar un pseudocódigo que luego de ingresar 2 números naturales imprima los números naturales que hay entre ambos empezando por el menor. Asumimos que el usuario ingresa dos números diferentes y el segundo es mayor que el primero. Emplear la estructura repetitiva MIENTRAS.
4. Calcular el precio total de una compra de “n” productos (el valor “n” se ingresa por teclado) si se ingresa el precio de cada producto y la cantidad comprada de este. Emplear la estructura repetitiva MIENTRAS.

---

# Ejercicio 1

```psc
Algoritmo Ejer1
	Definir num, aux, cifras Como Real
	Escribir "Ingresar número positivo"
	Leer num
	aux = num
	Mientras aux > 0 Hacer
		aux = trunc(aux / 10)
		cifras = cifras + 1
	FinMientras
	Escribir "El número ", num, " tiene ", cifras, " cifras."
FinAlgoritmo
```

# Ejercicio 2

```psc
Algoritmo Ejer2
	Definir num, i Como Real
	Escribir "Ingresar número positivo"
	Leer num
	i = 1
	
	Mientras i <= 12 Hacer
		Escribir num, " x ", i, " = ", num * i
		i = i + 1
	FinMientras
FinAlgoritmo
```

# Ejercicio 3

```psc
Algoritmo Ejer3
	Definir sec Como Texto
	Definir a, b, n1, n2 Como Real
	
	Escribir "Ingresar 2 números"
	Leer a, b
	
	Si a > b Entonces
		n1 = b
		n2 = a
	SiNo
		n1 = a
		n2 = b
	FinSi
	
	sec = ConvertirATexto(n1)
	
	Mientras n1 < n2 Hacer
		n1 = n1 + 1
		sec = sec + ", " + ConvertirATexto(n1)
	FinMientras
	
	Escribir "Secuencia:"
	Escribir sec
FinAlgoritmo
```

# Ejercicio 4

```psc
Algoritmo Ejer4
	Definir total, i, productos, precio, cant Como Real
	
	Escribir "Ingresar la cantidad de productos a ingresar"
	Leer productos
	
	i = 1
	
	Mientras i <= productos Hacer
		Escribir "Ingresar precio de producto #", i
		Leer precio
		
		Escribir "Ingresar el percio de producto #", i
		Leer cant
		
		total = total + (precio * cant)
		i = i + 1
	FinMientras
	
	Escribir "El total a pagar es de s/", total
FinAlgoritmo
```