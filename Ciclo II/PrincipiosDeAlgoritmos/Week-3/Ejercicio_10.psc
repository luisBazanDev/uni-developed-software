Algoritmo Ejercicio_10
	Definir entrada_general, entrada_mayores, entrada_menores, total Como Real
	Definir monto_general, monto_mayores, monto_menores Como Real
	
	Escribir "Ingrese la cantidad de entradas generales (s/150) vendidas:"
	Leer entrada_general
	Escribir "Ingrese la cantidad de entradas para mayores de 65 años (s/50) vendidas:"
	Leer entrada_mayores
	Escribir "Ingrese la cantidad de entradas para menores de edad (s/80) vendidas:"
	Leer entrada_menores
	
	monto_general = entrada_general * 150
	monto_mayores = entrada_mayores * 50
	monto_menores = entrada_menores * 80
	total = monto_general + monto_mayores + monto_menores
	
	Escribir "El total a pagar es de s/", total
	Escribir "--------------------"
	Escribir "Detalles:"
	Escribir entrada_general, " - Entradas general (s/150)           --->  ", monto_general
	Escribir entrada_mayores, " - Entradas mayores de 65 años (s/50) --->  ", monto_mayores
	Escribir entrada_menores, " - Entradas menores de edad (s/80)    --->  ", monto_menores
FinAlgoritmo
