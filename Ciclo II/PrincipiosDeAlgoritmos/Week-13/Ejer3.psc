Algoritmo Ejer3
	Definir sec Como Texto
	Definir a, b, n1, n2 Como Real
	
	Escribir "Ingresar 2 números"
	Leer a, b
	
	Si a > b Entonces
		n1 = b
		n2 = a
	SiNo
		n1 = a
		n2 = b
	FinSi
	
	sec = ConvertirATexto(n1)
	
	Mientras n1 < n2 Hacer
		n1 = n1 + 1
		sec = sec + ", " + ConvertirATexto(n1)
	FinMientras
	
	Escribir "Secuencia:"
	Escribir sec
FinAlgoritmo