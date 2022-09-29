# Task Week 2

1. Se debe permitir ingresar dos números, luego mostrar la suma y el producto de ambos.
2. Se debe permitir ingresar un número entero, luego mostrar el 20% de este número.
3. Se debe permitir ingresar un valor en metros, luego mostrar su valor en centímetros y en milímetros.
4. Ingresando la base y altura de un triángulo, luego mostrar su área.
5. Ingresar un valor en dólares, luego mostrar su equivalente en soles.
6. Leer una medida en pulgadas e imprimir su equivalente en milímetros.
7. Ingresar un número de 3 cifras y luego mostrar la suma de sus cifras elevada al cuadrado.
8. Se debe ingresar un monto de dinero, luego mostrar cuanto le toca a cada socio según la siguiente tabla:

---

# Ejercicio 1

```psc
Algoritmo Ejercicio_1
	Definir a, b, c, suma Como Real

	// Recibir primer n�mero
	Escribir "Dime el primer n�mero:"
	Leer a

	// Recibir segundo n�mero
	Escribir "Dime el segundo n�mero:"
	Leer b

	// Recibir tercer n�mero
	Escribir "Dime el tercer n�mero:"
	Leer c

	suma = a + b + c

	Escribir "La suma resulta:"
	Escribir suma
FinAlgoritmo
```

# Ejercicio 2

```psc
Algoritmo Ejercicio_2
	Definir lado, area Como Real

	Escribir "Dime cuanto mide el lado del cuadrado:"
	Leer lado

	area = lado * lado

	Escribir "El area es:"
	Escribir area
FinAlgoritmo
```

# Ejercicio 3

```psc
Algoritmo Ejercicio_3
	Definir base, altura, area Como Real

	Escribir "Dime la base del triangulo:"
	Leer base

	Escribir "Dime la altura del triangulo:"
	Leer altura

	area = base * altura / 2

	Escribir "El area del triangulo es:"
	Escribir area
FinAlgoritmo
```

# Ejercicio 4

```psc
Algoritmo Ejercicio_4
	Definir precio, descuento, precio_con_descuento Como Real

	Escribir "Dime el precio del producto:"
	Leer precio

	descuento = precio / 4

	Escribir "El descuento del producto es:"
	Escribir descuento

	precio_con_descuento = precio * 3 / 4

	Escribir "El final del producto es:"
	Escribir precio_con_descuento
FinAlgoritmo
```

# Ejercicio 5

```psc
Algoritmo Ejercicio_5
	Definir agregar_notas Como Texto
	Definir suma_notas, nota, numero_notas Como Real
	suma_notas = 0
	numero_notas = 0

	Mientras agregar_notas <> "no"
		Escribir "Dime tu nota"
		Leer nota

		suma_notas = suma_notas + nota
		numero_notas = numero_notas + 1

		Escribir "Quieres agregar notas? (si/no)"
		Leer agregar_notas
	FinMientras

	Escribir "Tu promedio es de:"
	Escribir suma_notas / numero_notas
FinAlgoritmo
```

# Ejercicio 6

```psc
Algoritmo Ejercicio_6
	Definir numero_meses Como Entero
	Definir precio, ganancia_mensual Como Real

	Escribir "Dime cuanto cuesta el celular:"
	Leer precio


	Escribir "Dime cuanto ganas mensualmente:"
	Leer ganancia_mensual

	numero_meses = redon(precio / ganancia_mensual)

	Escribir "Como minimo necesitas ahorrar por esta cantidad de meses:"
	Escribir numero_meses
FinAlgoritmo
```

# Ejercicio 7

```psc
Algoritmo Ejercicio_7
	Definir radio, area Como Real

	Escribir "Dime el radio del circulo"
	Leer radio

	area = 2 * PI * radio * radio

	Escribir "El area del circulo es:"
	Escribir area
FinAlgoritmo
```

# Ejercicio 8

```psc
Algoritmo Ejercicio_8
	Definir a, b, c, x Como Real

	Escribir "Dime el numero a en: ax^2 + bx + c"
	Leer a

	Escribir "Dime el numero b en: ax^2 + bx + c"
	Leer b

	Escribir "Dime el numero c en: ax^2 + bx + c"
	Leer c

	x = (-b + raiz(abs((b * b) - (4 * a * c)))) / (2 * a)

	Escribir "Seg�n los datos que me diste, x es igual a:"
	Escribir x
FinAlgoritmo
```
