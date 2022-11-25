1. Escribir un algoritmo que permita ingresar un número “n” de estudiantes (se cumple que: 10<=n<=20), cada uno de los cuáles cursa 4 materias. Para cada alumno se ingresa el nombre y sus calificaciones. Escriba un algoritmo para calcular el promedio de cada estudiante luego de ingresar sus notas.
2. Escribir un algoritmo que permita crear una matriz MxN donde el usuario ingresa los valores de M (filas) y N (columnas). Todos los elementos se rellenan con el símbolo *. Por ejemplo, si el usuario ingres M=2 y N=3 se debe mostrar: *** ***
3. Calcular el factorial de un número mayor o igual a 0.
4. Calcular la siguiente sumatoria de los “N” elementos: S = 1 + 4 + 9 + … N elementos
5. Dado un rango de números enteros, obtener la cantidad de números enteros que contiene.
6. Se requiere un algoritmo para determinar cuánto ahorrará una persona en un año, si al final de cada mes deposita variables cantidades de dinero; además, se requiere saber cuánto lleva ahorrado cada mes.
7. Escribir un programa que calcule el promedio de las notas ingresadas. Cuando el usuario ingrese una nota igual a cero se dejarán de ingresar las notas.
8. Escribir un programa que permita calcular la suma de los números enteros comprendidos entre 2 cantidades ingresadas por teclado..

---

# Ejercicio 1

```psc
Proceso Ejer1
	Definir nombre Como Caracter
	Definir n, nota, suma Como Real
	
	Repetir
		Escribir "Ingrese el número de estudiantes:"
		Leer n
	Hasta Que n >= 10 y n <= 20
	
	Para i = 1 Hasta n Hacer
		Escribir "Ingrese el nombre del estudiante N°", i
		Leer nombre
		
		suma = 0
		Para j = 1 Hasta 4 Hacer
			Escribir "Ingrese la nota de ", nombre, " para la materia #",j
			Leer nota
			suma = suma + nota
		FinPara
		
		Escribir "El promedio de ", nombre, " es ", suma / 4
	FinPara
FinProceso
```

# Ejercicio 2

```psc
Proceso Ejer2
	Definir fila Como Caracter
	Definir m, n Como Real
	
	Repetir
		Escribir "Ingrese número de columnas:"
		Leer m
		Si m < 0 Entonces
			Escribir "Número de columnas incorrecto"
		FinSi
	Hasta Que m > 0
	Repetir
		Escribir "Ingrese número de filas:"
		Leer n
		Si n < 0 Entonces
			Escribir "Número de filas incorrecto"
		FinSi
	Hasta Que n > 0
	
	Para i = 1 Hasta n Hacer
		fila = ""
		Para j = 1 Hasta m Hacer
			fila = fila + " *"
		FinPara
		Escribir fila
	FinPara
FinProceso
```

# Ejercicio 3

```psc
Proceso Ejer3
	Definir n, fac Como Real
	
	Repetir
		Escribir "Ingrese número a calcular:"
		Leer n
		Si n < 0 Entonces
			Escribir "Número incorrecto"
		FinSi
	Hasta Que n >= 0
	
	Si n = 0 Entonces
		Escribir "El factorial es 0"
	SiNo
		fac = 1
		Para i = 1 Hasta n Hacer
			fac = fac * i
		FinPara
		Escribir "El factorial es ", fac
	FinSi
FinProceso
```

# Ejercicio 4

```psc
Proceso Ejer4
	Definir expresión Como Caracter
	Definir n, sum Como Real
	
	Repetir
		Escribir "Ingrese número a calcular:"
		Leer n
		Si n <= 0 Entonces
			Escribir "Número incorrecto"
		FinSi
	Hasta Que n > 0
	
	expresión = "S = "
	
	Para i = 1 Hasta n Hacer
		Si i = 1 Entonces
			expresión = expresión + ConvertirATexto(i)
		SiNo
			expresión = expresión + " + " + ConvertirATexto(i)
		FinSi
		sum = sum + i
	FinPara
	Escribir "La sumatoria es:"
	Escribir expresión + " = ", sum
FinProceso
```

# Ejercicio 5

```psc
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
```

# Ejercicio 6

```psc
Proceso Ejer6
	Definir acumulado, actual Como Real
	
	Para i = 1 Hasta 12 Hacer
		Escribir "El monto acumulado hasta ahora es de s/", acumulado
		Escribir "Ingrese el monto ahorrado en el mes #", i
		Leer actual
		
		acumulado = acumulado + actual
	FinPara
	
	Escribir "En 1 año el ahorro es de s/", acumulado
FinProceso
```

# Ejercicio 7

```psc
Proceso Ejer7
	Definir i, suma, nota Como Real
	
	Repetir
		i = i + 1
		Escribir "Ingresar la nota #", i
		Leer nota
		suma = suma + nota
	Hasta Que nota = 0
	
	Escribir "El promedio fue de ", suma / i
FinProceso
```

# Ejercicio 8

```psc
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
```