Algoritmo Ejercicio_6
	Definir numero_meses Como Entero
	Definir precio, ganancia_mensual Como Real
	
	Escribir "Dime cuanto cuesta el celular:"
	Leer precio
	
	
	Escribir "Dime cuanto ganas mensualmente:"
	Leer ganancia_mensual
	
	numero_meses = redon(precio / ganancia_mensual)
	
	Escribir "Como minimo necesitas ahorrar por esta cantidad de meses:"
	Escribir numero_meses
FinAlgoritmo
