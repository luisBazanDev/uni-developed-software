Proceso Ejer_4
	Definir nombre Como Caracter
	Definir hijos Como Entero
	Definir sueldo_base, sueldo_final, bonificacion Como Real
	
	Escribir "Ingrese nombre del trabajador"
	Leer nombre
	
	Escribir "Ingrese el número de hijos del trabajador"
	Leer hijos
	
	Escribir "Ingrese sueldo base"
	Leer sueldo_base
	
	Si hijos > 0 Entonces
		sueldo_final <- 1.07 * sueldo_base
		Escribir "Si recibe bonificación, Sueldo final: S/", sueldo_final
	SiNo
		Escribir "No recibe bonificación, Sueldo final: S/", sueldo_base
	FinSi
FinProceso
