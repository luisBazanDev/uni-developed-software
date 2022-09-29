Proceso Ejer_2
	Definir nombre Como Caracter
	Definir practicas, parcial, final Como Entero
	Definir promedio Como Real
	Escribir "Ingrese el nombre"
	Leer nombre
	Escribir "Ingrese las notas de las prácticas"
	Leer practicas
	Escribir "Ingrese la nota del parcial y final"
	Leer parcial, final
	promedio <- (practicas + parcial + 2*final)/4
	Si promedio >= 11.5 Entonces
		Escribir "Nombre: ", nombre
		Escribir "Promedio: ", promedio
	SiNo
		Escribir "Aún eres Joven. Amen."
	FinSi
FinProceso
