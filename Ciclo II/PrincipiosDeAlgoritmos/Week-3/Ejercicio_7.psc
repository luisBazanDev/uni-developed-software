Algoritmo Ejercicio_7
	Definir num, centenas, decenas, unidades, suma Como Entero
	
	Escribir "Ingrese el número de 3 cifras:"
	Leer num
	
	centenas = trunc(num / 100)
	decenas = trunc((num - (centenas*100)) / 10)
	unidades = num - (centenas * 100) - (decenas * 10)
	
	suma = (centenas ^ 2) + (decenas ^ 2) + (unidades ^ 2)
	
	Escribir "La suma de las cifras elevadas al cuadrado del número es: ", suma
FinAlgoritmo
