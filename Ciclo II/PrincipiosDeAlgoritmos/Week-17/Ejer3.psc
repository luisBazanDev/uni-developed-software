Proceso Ejer3
	Definir year Como Real
	Escribir "Ingresar el año a calcular"
	Leer year
	
	Si year % 4 == 0 y year % 100 <> 0 Entonces
		Escribir "El año ", year, " es biciesto"
	SiNo
		Si year % 400 == 0 Entonces
			Escribir "El año ", year, " es biciesto"
		SiNo
			Escribir "El año ", year, " no es biciesto"
		FinSi
	FinSi
FinProceso