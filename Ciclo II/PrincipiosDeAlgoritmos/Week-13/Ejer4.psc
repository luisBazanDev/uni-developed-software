Algoritmo Ejer4
	Definir total, i, productos, precio, cant Como Real
	
	Escribir "Ingresar la cantidad de productos a ingresar"
	Leer productos
	
	i = 1
	
	Mientras i <= productos Hacer
		Escribir "Ingresar precio de producto #", i
		Leer precio
		
		Escribir "Ingresar el percio de producto #", i
		Leer cant
		
		total = total + (precio * cant)
		i = i + 1
	FinMientras
	
	Escribir "El total a pagar es de s/", total
FinAlgoritmo