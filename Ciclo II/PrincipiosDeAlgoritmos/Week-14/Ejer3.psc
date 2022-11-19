Proceso Ejer3
	Definir total, tiro, cant Como Real
	Repetir
		Escribir "Ingrese el tiro del dado (1-6)"
		Leer tiro
		total = total + tiro
		cant = cant + 1
	Hasta Que tiro = 1
	Escribir "Se tiro el dado ", cant, " de veces"
	Escribir "La cantidad total es: ", total
FinProceso