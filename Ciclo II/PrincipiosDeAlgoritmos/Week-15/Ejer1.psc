Proceso Ejer1
	Definir nombre Como Caracter
	Definir n, nota, suma Como Real
	
	Repetir
		Escribir "Ingrese el número de estudiantes:"
		Leer n
	Hasta Que n >= 10 y n <= 20
	
	Para i = 1 Hasta n Hacer
		Escribir "Ingrese el nombre del estudiante N°", i
		Leer nombre
		
		suma = 0
		Para j = 1 Hasta 4 Hacer
			Escribir "Ingrese la nota de ", nombre, " para la materia #",j
			Leer nota
			suma = suma + nota
		FinPara
		
		Escribir "El promedio de ", nombre, " es ", suma / 4
	FinPara
FinProceso