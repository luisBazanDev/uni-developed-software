Proceso Ejer_0_1
	Definir precio, cant Como Real
	Escribir "Cuantos productos quieres comprar?"
	Leer cant
	Escribir "Cuanto cuesta cada producto?"
	Leer precio
	Si precio * cant >= 100 Entonces
		Escribir "Monto final es de S/", precio * cant - (precio * 0.12)
	SiNo
		Escribir "Monto final es de S/", precio * cant
	FinSi
FinProceso
