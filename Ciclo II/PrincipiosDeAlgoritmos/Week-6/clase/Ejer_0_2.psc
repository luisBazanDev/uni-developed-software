Proceso Ejer_0_2
	Definir n1, n2, n3, prom Como Real
	Escribir "Ingrese las notas"
	Leer n1, n2, n3
	prom <- (n1 + n2 + n3) / 3
	Si prom >= 11.5 Entonces
		Escribir "Aprobó"
	SiNo
		Escribir "Reprobado :("
	FinSi
FinProceso
