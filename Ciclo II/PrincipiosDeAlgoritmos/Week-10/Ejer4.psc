Algoritmo Ejer4
	Definir peso, altura, sexo Como Real
	Escribir "Introducir peso del estudiante (lb)"
	Leer peso
	Escribir "Ingresar altura (m)"
	Leer altura
	Escribir "Ingresar el sexo del estudiante"
	Escribir "1. Varon"
	Escribir "2. Mujer"
	Leer sexo
	Segun sexo Hacer
		1:
			Si altura > 1.60 y peso >= 150 Entonces
				Escribir "Su dosis es de, 20% de la estatura y 80% de su peso."
			SiNo
				Escribir "Su dosis es de, 30% de la estatura y 70% de su peso."
			FinSi
		2:
			Si altura > 1.50 y peso >= 130 Entonces
				Escribir "Su dosis es de, 25% de la estatura y 75% de su peso."
			SiNo
				Escribir "Su dosis es de, 35% de la estatura y 65% de su peso."
			FinSi
		De Otro Modo:
			Escribir "Solo aceptamos generos binarios"
	FinSegun
FinAlgoritmo
