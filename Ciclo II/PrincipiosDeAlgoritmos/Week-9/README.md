1. Elabore un programa que permita ingresar el número del mes e imprima en pantalla el nombre del mes correspondiente, si el usuario ingresa un valor fuera del rango de [1-12] mostrar una advertencia.
2. Construya un pseudocódigo, que permita calcular el valor de f(x) según la siguiente expresión:
3. Una empresa de telecomunicaciones canadiense ofrece servicio de callback a un precio atractivo. El costo de las llamadas telefónicas depende tanto del lugar de origen de la llamada como de la zona geográfica en la que se encuentre el país destino. En la siguiente tabla se presenta el costo por 60 segundos para las llamadas originadas en Perú.
   | Tiempo | Utilidad | Precio por minuto |
   | --- | --- | --- |
   | 1 | Estados Unidos | 0.13 |
   | 2 | Canadá | 0.11 |
   | 5 | América del Sur | 0.22 |
   | 6 | Améria Central | 0.19 |
   | 7 | México | 0.17 |
   | 9 | Europa | 0.17 |
   | 10 | Asia | 0.20 |
   | 15 | África | 0.39 |
   | 20 | Oceanía | 0.28 |
   Realice un programa que le permita calcular e imprimir el costo total de una llamada telefónica considerando tanto la zona como la duración de la llamada.
4. Realizar un algoritmo que nos permita determinar si un alumno tiene una nota de 0, 1 y 2 necesita reforzamiento 3, 4, Desaprobado, 5,6, 7 Aprobado, 8, 9 Excelente y 10 es Becado. Emplear una estructura condicional múltiple.
5. Realizar un algoritmo que permita representar los días de la semana correspondiente a los cuerpos celestes del Sistema solar, de tal forma que ingrese el nombre del día y el programa retorne el cuerpo celeste correspondiente según la siguiente tabla.
   | Día | Cuerpo celeste |
   | --- | --- |
   | Lunes | Luna |
   | Martes | Marte |
   | Miercoles | Mercurio |
   | Jueves | Júpiter |
   | Viernes | Venus |
   | Sábado | Saturno |
   | Domingo | Sol |

---

# Ejercicio 1

```psc
Proceso nombre_mes
  Definir mes Como Entero;
  Escribir "Ingrese el número del mes (1-12): ";
  Leer mes;
  Segun mes Hacer
    1: Escribir "Enero";
    2: Escribir "Febrero";
    3: Escribir "Marzo";
    4: Escribir "Abril";
    5: Escribir "Mayo";
    6: Escribir "Junio";
    7: Escribir "Julio";
    8: Escribir "Agosto";
    10: Escribir "Octubre";
    9: Escribir "Septiembre";
    11: Escribir "Noviembre";
    12: Escribir "Diciembre";
    De Otro Modo: Escribir "Ingrese un valor entre 1 y 12";
  Fin Segun
FinProceso
```

# Ejercicio 2

```psc
Proceso descuentos
  Definir x, fx Como Real
  Escribir "Ingresa x"
  Leer x
  Segun x MOD 4 Hacer
    0: fx<-x^3
    1: fx<-(x^2-14)/(x^3)
    2: fx<-x^3+5
    3: fx<-0
  FinSegun
  Escribir "f(", x, ") = ", fx
  Definir sueldo, dscto, sneto Como Real
  Escribir "Ingrese el sueldo"
  Leer sueldo
  Si sueldo <= 1000 Entonces
    dscto <- 0.1*sueldo
  SiNo
    Si sueldo <= 2000 Entonces
      dscto <- 0.05*(sueldo-1000)
    SiNo
      dscto <- 0.03*(sueldo-2000)
    FinSi
  FinSi
  sneto <- sueldo - dscto
  Escribir "Sueldo: S/", sueldo
  Escribir "Descuento: S/", dscto
  Escribir "Sueldo neto: S/", sneto
FinProceso
```

# Ejercicio 3

```psc
Algoritmo Ejer3
	Definir zona, duracion, precio Como Real
	Escribir "Zonas geograficas   Precio por minuto"
	Escribir "1. Estados Unidos   0.13 changuidolares"
	Escribir "2. Canadá           0.11 changuidolares"
	Escribir "5. América del Sur  0.22 changuidolares"
	Escribir "6. América Central  0.19 changuidolares"
	Escribir "7. México           0.17 changuidolares"
	Escribir "9. Europa           0.17 changuidolares"
	Escribir "10. Asia            0.20 changuidolares"
	Escribir "15. África          0.39 changuidolares"
	Escribir "20. Oceanía         0.28 changuidolares"
	Leer zona

	Escribir "Ingresa la cantidad de tiempo en minutos"
	Leer duracion

	Segun zona Hacer
		1:
			precio = 0.13
		2:
			precio = 0.11
		5:
			precio = 0.22
		6:
			precio = 0.19
		7:
			precio = 0.17
		9:
			precio = 0.17
		10:
			precio = 0.20
		15:
			precio = 0.39
		20:
			precio = 0.28
		De Otro Modo:
			Escribir "Zona geográfica errónea"
			precio = 0
	FinSegun

	Si precio <> 0 Entonces
		Escribir "El precio por minuto de llamada es de ", precio, " changuidolares"
		Escribir "Costo total es de ", precio * duracion, " changuidolares"
	FinSi
FinAlgoritmo
```

# Ejercicio 4

```psc
Algoritmo Ejer4
	Definir nota Como Entero
	Escribir "Ingresar nota del estudiante. (1-10)"
	Leer nota

	Segun nota Hacer
		0,1,2:
			Escribir "El estudiante necesita reforzamiento"
		3,4:
			Escribir "El estudiante está desaprobado"
		5,6,7:
			Escribir "El estudiante está aprobado"
		8,9:
			Escribir "El estudiante está excelente"
		10:
			Escribir "El estudiante está Becado"
		De Otro Modo:
			Escribir "La nota ingresada no existe :v"
	FinSegun
FinAlgoritmo
```

# Ejercicio 5

```psc
Algoritmo Ejer5
	Definir dia Como Real
	Escribir "Que día quieres consultar?"
	Escribir "1. Lunes"
	Escribir "2. Martes"
	Escribir "3. Miércoles"
	Escribir "4. Jueves"
	Escribir "5. Viernes"
	Escribir "6. Sábado"
	Escribir "7. Domingo"
	Leer dia

	Segun dia Hacer
		1:
			Escribir "El cuerpo celeste es: Luna"
		2:
			Escribir "El cuerpo celeste es: Marte"
		3:
			Escribir "El cuerpo celeste es: Mercurio"
		4:
			Escribir "El cuerpo celeste es: Júpiter"
		5:
			Escribir "El cuerpo celeste es: Venus"
		6:
			Escribir "El cuerpo celeste es: Saturno"
		7:
			Escribir "El cuerpo celeste es: Sol"
		De Otro Modo:
			Escribir "El día no existe"
	FinSegun
FinAlgoritmo
```
