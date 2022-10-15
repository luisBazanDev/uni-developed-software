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
