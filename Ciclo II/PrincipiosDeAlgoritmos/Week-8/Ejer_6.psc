Algoritmo Ejer_6
	Definir year Como Entero
	
	Escribir "Ingresar a�o"
	Leer year
	
	Si year mod 400 == 0 Entonces
		Escribir "El a�o ", year, " es biciesto"
	SiNo
		Si year mod 4 == 0 y year mod 100 <> 0 Entonces
			Escribir "El a�o ", year, " es biciesto"
		SiNo
			Escribir "El a�o ", year, " no biciesto"
		FinSi
	FinSi
FinAlgoritmo
