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