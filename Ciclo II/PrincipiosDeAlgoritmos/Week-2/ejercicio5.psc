Algoritmo Ejercicio_5
	Definir agregar_notas Como Texto
	Definir suma_notas, nota, numero_notas Como Real
	suma_notas = 0
	numero_notas = 0
	
	Mientras agregar_notas <> "no"
		Escribir "Dime tu nota"
		Leer nota
		
		suma_notas = suma_notas + nota
		numero_notas = numero_notas + 1
		
		Escribir "Quieres agregar notas? (si/no)"
		Leer agregar_notas
	FinMientras
	
	Escribir "Tu promedio es de:"
	Escribir suma_notas / numero_notas
FinAlgoritmo
