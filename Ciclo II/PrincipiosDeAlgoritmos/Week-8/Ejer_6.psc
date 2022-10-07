Algoritmo Ejer_6
	Definir year Como Entero
	
	Escribir "Ingresar año"
	Leer year
	
	Si year mod 400 == 0 Entonces
		Escribir "El año ", year, " es biciesto"
	SiNo
		Si year mod 4 == 0 y year mod 100 <> 0 Entonces
			Escribir "El año ", year, " es biciesto"
		SiNo
			Escribir "El año ", year, " no biciesto"
		FinSi
	FinSi
FinAlgoritmo
