Algoritmo Ejer4
	Definir cant, precio, total, productos Como Real
	Escribir "Ingrese la cantidad de productos a comprar:"
	Leer productos
	Para i = 1 Hasta productos Hacer
		Escribir "Ingrese precio de producto N°", i
		Leer precio
		
		Escribir "Ingrese cantidad de productos N°", i
		Leer cant
		
		total = total + (precio * cant)
	FinPara
	
	Escribir "La cantidad total fue de s/", total
FinAlgoritmo