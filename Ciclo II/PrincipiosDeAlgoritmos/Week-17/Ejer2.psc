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