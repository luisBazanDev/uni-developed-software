Algoritmo practica
	Definir tipo_lic, licencia, a�os, desc, monto_final Como Real
	
	Escribir "Ingrese el tipo de licencia"
	Escribir "1. Bodega"
	Escribir "2. Ferreter�a"
	Escribir "3. Farmacia"
	Escribir "4. Restaurante"
	Leer tipo_lic
	
	Segun tipo_lic Hacer
		1: licencia = 50
		2: licencia = 60
		3: licencia = 70
		4: licencia = 80
	FinSegun
	
	Escribir "Ingrese los a�os de antiguedad"
	Leer a�os
	
	Si a�os >= 13 Entonces
		desc = licencia * 0.25
	SiNo
		Si a�os >= 9 Entonces
			desc = licencia * 0.20
		SiNo
			Si a�os >= 4 Entonces
				desc = licencia * 0.15
			SiNo
				Si a�os >= 0 Entonces
					desc = licencia * 0.10
				FinSi
			FinSi
		FinSi
	FinSi
	
	monto_final = licencia - desc
	
	
FinAlgoritmo