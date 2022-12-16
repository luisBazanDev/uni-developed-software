Proceso Ejer1
	Definir rubro, antiguedad, costo, desc Como Real
	
	Escribir "Ingrese el rubro al cual pertenece"
	Escribir "1. Bodega"
	Escribir "2. Ferretería"
	Escribir "3. Farmacia"
	Escribir "4. Restaurante"
	Leer rubro
	Escribir "Ingrese la antiguedad del negocio"
	Leer antiguedad
	Segun rubro
		Caso 1:
			costo=50
		Caso 2:
			costo=60
		Caso 3:
			costo=70
		Caso 4:
			costo=80
	FinSegun
	Si antiguedad>13 Entonces
		desc=costo*0.25
	SiNo
		Si antiguedad>9 Entonces
			desc=costo*0.20
		SiNo
			Si antiguedad>4 Entonces
				desc=costo*0.15
			SiNo
				desc=costo*0.10
			FinSi
		FinSi
	FinSi
	Escribir "Descuento:",desc
	Escribir "Monto:",costo
	Escribir "Monto final:",costo-desc
FinProceso
