Proceso Practica
	Definir nombre, dni Como Caracter
	Definir personas, i, edad, sexo, cant_hombre, cant_mujeres, edad_hombre, edad_mujeres Como Real
	Escribir "Ingrese la cantidad de personas a evaluar"
	Leer personas
	i=1
	Mientras i<=personas Hacer
		Escribir "Ingresar nombres y apellidos de cliente ", i
		Leer nombre
		Escribir "Ingresar edad de cliente ", i
		Leer edad
		Escribir "Ingresar dni de cliente ", i
		Leer dni
		Escribir "Ingresar sexo de cliente ", i
		Escribir "1.Hombre"
		Escribir "2.Mujer"
		Leer sexo
		Si sexo=1 Entonces
			cant_hombre=cant_hombre+1
			edad_hombre=edad_hombre+edad
		SiNo
			cant_mujeres=cant_mujeres+1
			edad_mujeres=edad_mujeres+edad
		FinSi
		i=i+1
	FinMientras
	Escribir "Cantida de hombres:",cant_hombre
	Escribir "Cantidad de mujeres:",cant_mujeres
	Escribir "Edad promedio hombres:",edad_hombre/cant_hombre
	Escribir "Edad promedio mujeres:",edad_mujeres/cant_mujeres
FinProceso
