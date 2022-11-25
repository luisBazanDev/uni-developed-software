Proceso Ejer6
	Definir acumulado, actual Como Real
	
	Para i = 1 Hasta 12 Hacer
		Escribir "El monto acumulado hasta ahora es de s/", acumulado
		Escribir "Ingrese el monto ahorrado en el mes #", i
		Leer actual
		
		acumulado = acumulado + actual
	FinPara
	
	Escribir "En 1 año el ahorro es de s/", acumulado
FinProceso