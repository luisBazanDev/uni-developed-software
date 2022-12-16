Proceso sin_titulo
	Definir cant_estudiantes, nota, suma_notas, contador Como Real
	
	Escribir "Ingrese cant estudiantes"
	Leer cant_estudiantes
	
	Para i = 1 Hasta cant_estudiantes Hacer
		Repetir
			Escribir "INGRESAR NOTA de estudiante ", i
			Leer nota
		Hasta Que nota >= 0 y nota <= 20
		
		suma_notas = suma_notas + nota
	FinPara
	Escribir suma_notas / cant_estudiantes
FinProceso
