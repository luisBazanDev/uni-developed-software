Proceso Ejer3
	Definir n, fac Como Real
	
	Repetir
		Escribir "Ingrese número a calcular:"
		Leer n
		Si n < 0 Entonces
			Escribir "Número incorrecto"
		FinSi
	Hasta Que n >= 0
	
	Si n = 0 Entonces
		Escribir "El factorial es 0"
	SiNo
		fac = 1
		Para i = 1 Hasta n Hacer
			fac = fac * i
		FinPara
		Escribir "El factorial es ", fac
	FinSi
FinProceso