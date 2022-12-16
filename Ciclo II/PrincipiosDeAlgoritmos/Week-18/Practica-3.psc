Algoritmo practica
	Definir tipo_lic, licencia, años, desc, monto_final Como Real
	
	Escribir "Ingrese el tipo de licencia"
	Escribir "1. Bodega"
	Escribir "2. Ferretería"
	Escribir "3. Farmacia"
	Escribir "4. Restaurante"
	Leer tipo_lic
	
	Segun tipo_lic Hacer
		1: licencia = 50
		2: licencia = 60
		3: licencia = 70
		4: licencia = 80
	FinSegun
	
	Escribir "Ingrese los años de antiguedad"
	Leer años
	
	Si años >= 13 Entonces
		desc = licencia * 0.25
	SiNo
		Si años >= 9 Entonces
			desc = licencia * 0.20
		SiNo
			Si años >= 4 Entonces
				desc = licencia * 0.15
			SiNo
				Si años >= 0 Entonces
					desc = licencia * 0.10
				FinSi
			FinSi
		FinSi
	FinSi
	
	monto_final = licencia - desc
	
	
FinAlgoritmo