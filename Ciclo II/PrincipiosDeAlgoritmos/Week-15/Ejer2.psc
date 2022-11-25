Proceso Ejer2
	Definir fila Como Caracter
	Definir m, n Como Real
	
	Repetir
		Escribir "Ingrese número de columnas:"
		Leer m
		Si m < 0 Entonces
			Escribir "Número de columnas incorrecto"
		FinSi
	Hasta Que m > 0
	Repetir
		Escribir "Ingrese número de filas:"
		Leer n
		Si n < 0 Entonces
			Escribir "Número de filas incorrecto"
		FinSi
	Hasta Que n > 0
	
	Para i = 1 Hasta n Hacer
		fila = ""
		Para j = 1 Hasta m Hacer
			fila = fila + " *"
		FinPara
		Escribir fila
	FinPara
FinProceso