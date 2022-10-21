Algoritmo Ejer3
	Definir cantidad, precio, genero, talla, origen, desc, total Como Real
	Escribir "Ingresar cantidad de ropa"
	Leer cantidad
	Escribir "Ingresar precio de ropa"
	Leer precio
	Escribir "Ingresar genero de ropa"
	Escribir "1. Varones"
	Escribir "2. Mujeres"
	Leer genero
	Escribir "Ingresar talla de la ropa"
	Escribir "1. S"
	Escribir "2. M"
	Escribir "3. L"
	Leer talla
	Escribir "Ingresar tipo de la ropa"
	Escribir "1. Nacional"
	Escribir "2. Importado"
	Leer origen
	
	total = cantidad * precio
	Segun genero Hacer
		1:
			Segun origen Hacer
				1:
					Segun talla Hacer
						1:
							desc = total * 0.10
						2:
							desc = total * 0.12
						3:
							desc = total * 0.15
						De Otro Modo:
							Escribir "Talla no encontrada"
					FinSegun
				2:
					Segun talla Hacer
						1:
							desc = total * 0.05
						2:
							desc = total * 0.07
						3:
							desc = total * 0.10
						De Otro Modo:
							Escribir "Talla no encontrada"
					FinSegun
				De Otro Modo:
					Escribir "Origen desconocido"
			FinSegun
		2:
			Segun origen Hacer
				1:
					Segun talla Hacer
						1:
							desc = total * 0.15
						2:
							desc = total * 0.17
						3:
							desc = total * 0.20
						De Otro Modo:
							Escribir "Talla no encontrada"
					FinSegun
				2:
					Segun talla Hacer
						1:
							desc = total * 0.07
						2:
							desc = total * 0.09
						3:
							desc = total * 0.12
						De Otro Modo:
							Escribir "Talla no encontrada"
					FinSegun
				De Otro Modo:
					Escribir "Origen desconocido"
			FinSegun
		De Otro Modo:
			Escribir "Solo aceptamos generos binarios"
	FinSegun
	Escribir "Monto comprado -  s/", total
	Escribir "Descuento ------ -s/", desc
	Escribir "Monto a pagar --  s/", total - desc
FinAlgoritmo
