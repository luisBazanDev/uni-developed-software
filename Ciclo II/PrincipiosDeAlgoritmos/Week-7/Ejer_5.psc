Algoritmo Ejer_5
	Definir num Como Real
	
	Escribir "Ingresar número"
	Leer num
	
	Si num - trunc(num) <> 0 o num < 0 o num > 99 Entonces
		Escribir "El número no es naturales de 2 cifras"
	SiNo
		Si num < 10 Entonces
			Escribir "El número es de 1 cifra, sumale ", 10 - num
		SiNo
			Escribir "Número correcto"
		FinSi
	FinSi
FinAlgoritmo