Proceso Ejer4
	Definir expresión Como Caracter
	Definir n, sum Como Real
	
	Repetir
		Escribir "Ingrese número a calcular:"
		Leer n
		Si n <= 0 Entonces
			Escribir "Número incorrecto"
		FinSi
	Hasta Que n > 0
	
	expresión = "S = "
	
	Para i = 1 Hasta n Hacer
		Si i = 1 Entonces
			expresión = expresión + ConvertirATexto(i)
		SiNo
			expresión = expresión + " + " + ConvertirATexto(i)
		FinSi
		sum = sum + i
	FinPara
	Escribir "La sumatoria es:"
	Escribir expresión + " = ", sum
FinProceso