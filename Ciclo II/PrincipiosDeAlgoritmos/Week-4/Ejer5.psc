Algoritmo Ejer5
	Definir aprobados, desaprobados, total Como Entero
	
	Escribir "Ingrese la cantidad de alumnos aprobados"
	Leer aprobados
	
	Escribir "Ingrese la cantidad de alumnos desaprobados"
	Leer desaprobados
	
	total <- aprobados + desaprobados
	
	Escribir "El total de alumnos -------> ", total
	Escribir "El total de aprobados -----> ", redon(aprobados * 100 / total), "%"
	Escribir "El total de desaprobados --> ", redon(desaprobados * 100 / total), "%"
FinAlgoritmo
