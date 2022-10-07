Algoritmo Ejer_5
	Definir val, imp1, imp2 Como Real
	
	Escribir "Ingresar valor de la casa: ($)"
	Leer val
	
	Escribir "Valor de la casa ------------------ $", val
	
	Si val > 25000 Entonces
		imp1 = 25000 * 0.3
		imp2 = (val - 25000) * 0.5
	SiNo
		imp1 = val * 0.3
	FinSi
	Escribir "-----------------------------------"
	Escribir "Importe por los primeros $25000 --- $", imp1
	Escribir "Importe por el restante ----------- $", imp2
	Escribir "Importe final total --------------- $", imp1 + imp2
FinAlgoritmo
