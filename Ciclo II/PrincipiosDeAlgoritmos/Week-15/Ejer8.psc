Proceso Ejer8
	Definir n1, n2, men, may, suma Como Real
	
	Escribir "Ingresar el limite del rango"
	Leer n1
	Escribir "Ingresar el otro limite del rango"
	Leer n2
	
	Si n1 > n2 Entonces
		men = n2
		may = n1
	SiNo
		men = n1
		may = n2
	FinSi
	Para i = men + 1 Hasta may - 1  Con Paso 1 Hacer
		suma = suma + i
	FinPara
	Escribir "La suma de los numeros intermedios es ", suma
FinProceso