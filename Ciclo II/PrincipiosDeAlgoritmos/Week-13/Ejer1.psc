Algoritmo Ejer1
	Definir num, aux, cifras Como Real
	Escribir "Ingresar número positivo"
	Leer num
	aux = num
	Mientras aux > 0 Hacer
		aux = trunc(aux / 10)
		cifras = cifras + 1
	FinMientras
	Escribir "El número ", num, " tiene ", cifras, " cifras."
FinAlgoritmo