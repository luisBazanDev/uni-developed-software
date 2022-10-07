# Task Week 8

1. Construir un algoritmo que permita ingresar un número entero y muestre si es negativo, creo o positivo.
2. A un trabajador le descuentan de su sueldo el 10% si su sueldo es menor o igual a 1000, por encima de 1000 hasta 2000 el 5% del adicional, y por encima de 2000 el 3% del adicional. Calcular el descuento y sueldo neto que recibe el trabajador dado un sueldo
3. Una empresa requiere un sistema de cálculo de bonos de fin de año para los trabajadores, elabore un algoritmo que reciba el salario mensual de un trabajador. Luego calcule y muestre sus utilidades si este se asigna como un porcentaje de lo que ha ganado durante el año dependiendo de su antigüedad en la empresa de acuerdo con la siguiente tabla:
   | Tiempo | Utilidad |
   |---|---|
   | Menos de 1 año | 5% |
   | Desde 1 año hasta menos de 2 años | 7% |
   | Desde 2 años hasta menos de 5 años | 10% |
   | Desde 5 años hasta menos de 10 años | 15% |
   | 10 años o más | 20% |
4. Ingresar la cantidad de alumnos aprobados y desaprobados de un curso. Luego mostrar el porcentaje de estudiantes aprobados y el porcentaje de estudiantes desaprobados.
5. Elaborar un algoritmo para el siguiente caso: una empresa de seguros asegura una casa ante desastres cobrando una prima anual de acuerdo con el valor de la casa. Para los primeros $25000 cobra el 3% del valor y para el valor restante 5%. Por ejemplo, si una casa está valorizada en $30000, cobrará 3% sobre los $25000 y 5% al resto, es decir 5% a $500. Haga un programa que muestre el monto que un cliente debe pagar por asegurar su casa. Descarte casas con valores superiores a los $100000.
6. Escribir un programa que determine si un año es bisiesto. Un año es bisiesto si es múltiplo de 4 (por ejemplo 1984). Los años múltiplos de 100 no son bisiestos, salvo si ellos son también múltiplos de 400 (2000 es bisiesto, pero 1800 no lo es)

---

# Ejercicio 1

```psc
Algoritmo ceros
  Definir num Como Entero
  Escribir "Ingresa un número"
  Leer num
  Si num = 0 Entonces
    Escribir "Es nulo"
  SiNo
    Si num MOD 2 = 0 Entonces
      Escribir "Es par"
    SiNo
      Escribir "Es impar"
    FinSi
  FinSi
FinAlgoritmo
```

# Ejercicio 2

```psc
Algoritmo descuentos
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
FinAlgoritmo
```

# Ejercicio 3

```psc
Algoritmo Ejer_3
	Definir antiguedad Como Entero
	Definir salario, utilidades Como Real

	Escribir "Ingresar salario mensual: (s/)"
	Leer salario

	Escribir "Ingresar antiguedad en la empresa: (a�os)"
	Leer antiguedad

	Si salario >= 10 Entonces
		utilidades = salario * 0.2
	SiNo
		Si salario >= 5 Entonces
			utilidades = salario * 0.15
		SiNo
			Si salario >= 2 Entonces
				utilidades = salario * 0.1
			SiNo
				Si salario >= 1 Entonces
					utilidades = salario * 0.07
				SiNo
					utilidades = salario * 0.05
				FinSi
			FinSi
		FinSi
	FinSi

	Escribir "Salario base ----------- s/", salario
	Escribir "Utilidades ------------- s/", utilidades
	Escribir "Salario + Utilidades --- s/", salario + utilidades
FinAlgoritmo
```

# Ejercicio 4

```psc
Algoritmo Ejer_4
	Definir aprobados, desprobados, total Como Entero

	Escribir "Ingresar cantidad de estudiantes aprobados:"
	Leer aprobados

	Escribir "Ingresar cantidad de estudiantes desaprobados:"
	Leer desprobados

	total = aprobados + desprobados

	Escribir "Estudiantes aprobados ----- ", aprobados, " - ", redon(aprobados * 100 / total), "%"
	Escribir "Estudiantes desprobados --- ", desprobados, " - ", redon(desprobados * 100 / total), "%"
FinAlgoritmo
```

# Ejercicio 5

```psc

```

# Ejercicio 6

```psc

```
