Proceso Ejer_4
	Definir nombre Como Caracter
	Definir hijos Como Entero
	Definir sueldo_base, sueldo_final, bonificacion Como Real
	
	Escribir "Ingrese nombre del trabajador"
	Leer nombre
	
	Escribir "Ingrese el n�mero de hijos del trabajador"
	Leer hijos
	
	Escribir "Ingrese sueldo base"
	Leer sueldo_base
	
	Si hijos > 0 Entonces
		sueldo_final <- 1.07 * sueldo_base
		Escribir "Si recibe bonificaci�n, Sueldo final: S/", sueldo_final
	SiNo
		Escribir "No recibe bonificaci�n, Sueldo final: S/", sueldo_base
	FinSi
FinProceso
