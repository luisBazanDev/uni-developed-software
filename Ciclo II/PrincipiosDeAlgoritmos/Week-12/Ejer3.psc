Algoritmo Ejer3
	Definir n1, n2, nmen, nmay Como Real
	Escribir "Ingresar números"
	Leer n1, n2
	
	Si n1 < n2 Entonces
		nmen = n1
		nmay = n2
	SiNo
		nmen = n2
		nmay = n1
	FinSi
	
	Escribir "Los números intermedios son:"
	Para i = nmen + 1 Hasta nmay - 1 Hacer
		Escribir i
	FinPara
FinAlgoritmo