Proceso Ejer5
	Definir intermedio Como Caracter
	Definir n1, n2, men, may Como Real
	
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
	intermedio = ConvertirATexto(men)
	Para i = men + 1 Hasta may  Con Paso 1 Hacer
		intermedio = intermedio + " " + ConvertirATexto(i)
	FinPara
	Escribir "La secuencia es"
	Escribir intermedio
FinProceso