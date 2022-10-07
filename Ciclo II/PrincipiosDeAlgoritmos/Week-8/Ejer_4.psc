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
