Algoritmo Ejer3
	Definir zona, duracion, precio Como Real
	Escribir "Zonas geograficas   Precio por minuto"
	Escribir "1. Estados Unidos   0.13 changuidolares"
	Escribir "2. Canadá           0.11 changuidolares"
	Escribir "5. América del Sur  0.22 changuidolares"
	Escribir "6. América Central  0.19 changuidolares"
	Escribir "7. México           0.17 changuidolares"
	Escribir "9. Europa           0.17 changuidolares"
	Escribir "10. Asia            0.20 changuidolares"
	Escribir "15. África          0.39 changuidolares"
	Escribir "20. Oceanía         0.28 changuidolares"
	Leer zona
	
	Escribir "Ingresa la cantidad de tiempo en minutos"
	Leer duracion
	
	Segun zona Hacer
		1:
			precio = 0.13
		2:
			precio = 0.11
		5:
			precio = 0.22
		6:
			precio = 0.19
		7:
			precio = 0.17
		9:
			precio = 0.17
		10:
			precio = 0.20
		15:
			precio = 0.39
		20:
			precio = 0.28
		De Otro Modo:
			Escribir "Zona geográfica errónea"
			precio = 0
	FinSegun
	
	Si precio <> 0 Entonces
		Escribir "El precio por minuto de llamada es de ", precio, " changuidolares"
		Escribir "Costo total es de ", precio * duracion, " changuidolares"
	FinSi
FinAlgoritmo
