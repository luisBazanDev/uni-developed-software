Proceso Practica
	Definir total_personas, h_derecho, m_administracion, otros Como Real
	Definir genero, estudio Como Caracter
	
	Escribir "Ingrese personas a encuestar"
	Leer total_personas
	
	Para i=1 Hasta total_personas Hacer
		Repetir
			Escribir "Ingrese Genero (H/M)"
			Leer genero
		Hasta Que genero="H" o genero="M"
		
		Escribir "Ingrese la carrera que estudia"
		Escribir "A. Administración"
		Escribir "B. Derecho"
		Escribir "C. otro"
		Leer estudio
		
		Si estudio="A" y genero="M" Entonces
			m_administracion=m_administracion+1
		SiNo
			Si estudio="B" y genero="H" Entonces
				h_derecho = h_derecho + 1
			SiNo
				otros = otros + 1
			FinSi
		FinSi
	FinPara
	
	Escribir "% de hombres que estudian derecho: ", h_derecho * 100/total_personas
	Escribir "% de mujeres que estudian adminis: ", m_administracion * 100/total_personas
	Escribir "% de otros: ", otros * 100/total_personas
FinProceso
