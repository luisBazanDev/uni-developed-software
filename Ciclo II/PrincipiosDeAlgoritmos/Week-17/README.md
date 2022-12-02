1. Una empresa requiere un sistema de cálculo de bonos de fin de año para los trabajadores, elabore un algoritmo que reciba el salario mensual de un trabajador. Luego calcule y muestre sus utilidades si este se asigna como un porcentaje de lo que ha ganado durante el año dependiendo de su antigüedad en la empresa de acuerdo con la siguiente tabla:
   | Tiempo | Utilidad |
   |---|---|
   | Menos de 1 año | 5% |
   | Desde 1 año hasta menos de 2 años | 7% |
   | Desde 2 años hasta menos de 5 años | 10% |
   | Desde 5 año hasta menos de 10 años | 15% |
   | 10 años o más | 20% |
2. Ingresar la cantidad de alumnos aprobados y desaprobados de un curso. Luego mostrar el porcentaje de estudiantes aprobados y el porcentaje de estudiantes desaprobados.
3. Escribir un programa que determine si un año es bisiesto. Un año es bisiesto si es múltiplo de 4 (por ejemplo 1984). Los años múltiplos de 100 no son bisiestos, salvo si ellos son también múltiplos de 400 (2000 es bisiesto, pero 1800 no lo es)

---

# Ejercicio 1

```psc
Proceso Ejer1
	Definir empleados, tiempo, salario, bono Como Real
	Repetir
		Escribir "Ingresar cantidad de empleados a calcular"
		Leer empleados
	Hasta Que empleados > 0

	Para i = 1 Hasta empleados Hacer
		Repetir
			Escribir "Ingresar tiempo en la empresa de empleado #", i
			Leer tiempo
		Hasta Que tiempo > 0
		Repetir
			Escribir "Ingresar salario de empleado #", i
			Leer salario
		Hasta Que salario > 0
		Si tiempo < 1 Entonces
			bono = salario * 0.05
		SiNo
			Si tiempo < 2 Entonces
				bono = salario * 0.07
			SiNo
				Si tiempo < 5 Entonces
					bono = salario * 0.1
				SiNo
					Si tiempo < 10 Entonces
						bono = salario * 0.15
					SiNo
						bono = salario * 0.2
					FinSi
				FinSi
			FinSi
		FinSi
		Escribir "Bono del empleado es de ", bono
	FinPara
FinProceso
```

# Ejercicio 2

```psc
Proceso Ejer2
	Definir aprobados, desaprobados, total Como Real
	Repetir
		Escribir "Ingresar cantidad de empleados a calcular"
		Leer aprobados
	Hasta Que aprobados >= 0
	Repetir
		Escribir "Ingresar cantidad de empleados a calcular"
		Leer desaprobados
	Hasta Que desaprobados >= 0

	total = aprobados + desaprobados

	Escribir "Porc de estudiantes aprobados es: ", trunc(aprobados * 100 / total), "%"
	Escribir "Porc de estudiantes desaprobados es: ", trunc(desaprobados * 100 / total), "%"
FinProceso
```

# Ejercicio 3

```psc
Proceso Ejer3
	Definir year Como Real
	Escribir "Ingresar el año a calcular"
	Leer year

	Si year % 4 == 0 y year % 100 <> 0 Entonces
		Escribir "El año ", year, " es biciesto"
	SiNo
		Si year % 400 == 0 Entonces
			Escribir "El año ", year, " es biciesto"
		SiNo
			Escribir "El año ", year, " no es biciesto"
		FinSi
	FinSi
FinProceso
```
