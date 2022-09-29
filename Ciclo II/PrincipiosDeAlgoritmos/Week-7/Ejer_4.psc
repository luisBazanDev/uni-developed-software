Algoritmo Ejer_4
	Definir num Como Real
	
	Escribir "Ingresar número"
	Leer num
	
	Si num - trunc(num) <> 0 o num < 0 Entonces
		Escribir "El número no es natural"
	SiNo
		Si num > 100 Entonces
			Escribir "El 30% de ", num, " es ", num * 0.3
		SiNo
			Escribir "El 150% de ", num, " es ", num * 1.5
		FinSi
	FinSi
FinAlgoritmo