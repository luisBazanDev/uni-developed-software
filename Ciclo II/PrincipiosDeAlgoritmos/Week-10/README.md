1. Construir un pseudocódigo que permita ingresar dos números y un símbolo (+, -, x, /) y dependiendo del operador devuelva la suma, la diferencia, el producto o la división. Nota: verificar que el divisor no sea cero y mostrar una advertencia si se ingresa un valor diferente a esos símbolos
2. Una agencia de seguros para autos asigna costos mensuales en base al sexo y edad del conductor. Los varones menores de 25 años pagan 1000 soles, los de 25 a más pagan 700 soles. Las mujeres de 21 años o menos pagan 500 y las que tienen más de 21 años paga 300 soles. Realizar un programa en pseudocódigo que solicite la edad y sexo de la persona, luego de acuerdo con lo mencionado muestre el costo mensual del seguro en pantalla.
3. Una tienda distribuidora de ropa ha establecido porcentajes de descuento sobre el monto comprado de la siguiente forma. Realizar un programa en pseudocódigo donde se ingresa el monto comprado (en soles), el género, talla y origen. Luego debe mostrar el monto comprado, el importe del descuento y el monto a pagar.
   | | VA | RO | NES | MU | JE | RES |
   |---|---|---|---|---|---|---|
   | Origen \ Talla | S | M | L | S | M | L |
   | Nacional | 10 | 12 | 15 | 15 | 17 | 20 |
   | Importado | 5 | 7 | 10 | 7 | 9 | 12 |
4. Dado el peso, la altura y el sexo, de unos estudiantes. Realizar un programa en pseudocódigo que determine la cantidad de vitaminas que deben consumir estos estudiantes, en base al siguiente criterio:
   - Si son varones, y su estatura es mayor a 1.60, y su peso es mayor o igual a 150 lb, su dosis, serán: 20% de la estatura y 80% de su peso. De lo contrario, la dosis será la siguiente: 30% de la estatura y 70% de su peso.
   - Si son mujeres, y su estatura es mayor de a 1.50 m y su peso es mayor o igual a 130 lb, su dosis será: 25% de la estatura y 75% de su peso. De lo contrario, la dosis será: 35% de la estatura y 65% de su peso. La dosis debe ser expresada en gramos

---

# Ejercicio 1

```psc
Proceso operadores
  Definir n1, n2 Como Real
  Definir simbolo Como Caracter
  Escribir "Ingrese los números"
  Leer n1, n2
  Escribir "Ingrese el símbolo (+,-,x,/)"
  Leer simbolo
  Segun simbolo hacer
    Caso "+":
      Escribir n1 , " + ", n2, " = ", (n1+n2)
    Caso "-":
      Escribir n1 , " - ", n2, " = ", (n1-n2)
    Caso "x":
      Escribir n1 , " x ", n2, " = ", (n1*n2)
    Caso "/":
      Si n2 <> 0 Entonces
        Escribir n1 , " ÷ ", n2, " = ", (n1/n2)
      SiNo
        Escribir "No se puede dividir entre cero"
      FinSi
  De Otro Modo:
    Escribir "ADVERTENCIA: Operador inválido"
  FinSegun
FinProceso
```

# Ejercicio 2

```psc
Proceso seguros
  Definir genero Como Caracter // V o M
  Definir edad Como Entero
  Definir precio Como Real
  Escribir "Ingrese el género V o M"
  Leer genero
  Escribir "Ingrese la edad"
  Leer edad
  Segun genero Hacer
    "V":
      Si edad < 25 Entonces
        precio <- 1000
      SiNo
        precio <- 700
      FinSi
    "M":
      Si edad >= 21 Entonces
        precio <- 500
      SiNo
        precio <- 300
      FinSi
    De Otro Modo:
      Escribir "ERROR"
  FinSegun
  Escribir "El pago es: S/", precio
FinProceso
```

# Ejercicio 3

```psc
Algoritmo Ejer3
	Definir cantidad, precio, genero, talla, origen, desc, total Como Real
	Escribir "Ingresar cantidad de ropa"
	Leer cantidad
	Escribir "Ingresar precio de ropa"
	Leer precio
	Escribir "Ingresar genero de ropa"
	Escribir "1. Varones"
	Escribir "2. Mujeres"
	Leer genero
	Escribir "Ingresar talla de la ropa"
	Escribir "1. S"
	Escribir "2. M"
	Escribir "3. L"
	Leer talla
	Escribir "Ingresar tipo de la ropa"
	Escribir "1. Nacional"
	Escribir "2. Importado"
	Leer origen

	total = cantidad * precio
	Segun genero Hacer
		1:
			Segun origen Hacer
				1:
					Segun talla Hacer
						1:
							desc = total * 0.10
						2:
							desc = total * 0.12
						3:
							desc = total * 0.15
						De Otro Modo:
							Escribir "Talla no encontrada"
					FinSegun
				2:
					Segun talla Hacer
						1:
							desc = total * 0.05
						2:
							desc = total * 0.07
						3:
							desc = total * 0.10
						De Otro Modo:
							Escribir "Talla no encontrada"
					FinSegun
				De Otro Modo:
					Escribir "Origen desconocido"
			FinSegun
		2:
			Segun origen Hacer
				1:
					Segun talla Hacer
						1:
							desc = total * 0.15
						2:
							desc = total * 0.17
						3:
							desc = total * 0.20
						De Otro Modo:
							Escribir "Talla no encontrada"
					FinSegun
				2:
					Segun talla Hacer
						1:
							desc = total * 0.07
						2:
							desc = total * 0.09
						3:
							desc = total * 0.12
						De Otro Modo:
							Escribir "Talla no encontrada"
					FinSegun
				De Otro Modo:
					Escribir "Origen desconocido"
			FinSegun
		De Otro Modo:
			Escribir "Solo aceptamos generos binarios"
	FinSegun
	Escribir "Monto comprado -  s/", total
	Escribir "Descuento ------ -s/", desc
	Escribir "Monto a pagar --  s/", total - desc
FinAlgoritmo
```

# Ejercicio 4

```psc
Algoritmo Ejer4
	Definir peso, altura, sexo Como Real
	Escribir "Introducir peso del estudiante (lb)"
	Leer peso
	Escribir "Ingresar altura (m)"
	Leer altura
	Escribir "Ingresar el sexo del estudiante"
	Escribir "1. Varon"
	Escribir "2. Mujer"
	Leer sexo
	Segun sexo Hacer
		1:
			Si altura > 1.60 y peso >= 150 Entonces
				Escribir "Su dosis es de, 20% de la estatura y 80% de su peso."
			SiNo
				Escribir "Su dosis es de, 30% de la estatura y 70% de su peso."
			FinSi
		2:
			Si altura > 1.50 y peso >= 130 Entonces
				Escribir "Su dosis es de, 25% de la estatura y 75% de su peso."
			SiNo
				Escribir "Su dosis es de, 35% de la estatura y 65% de su peso."
			FinSi
		De Otro Modo:
			Escribir "Solo aceptamos generos binarios"
	FinSegun
FinAlgoritmo
```
