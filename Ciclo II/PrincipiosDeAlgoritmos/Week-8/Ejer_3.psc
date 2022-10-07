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