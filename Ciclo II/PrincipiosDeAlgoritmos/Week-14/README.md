1. Se desea crear un algoritmo para un sistema de votación. Supóngase en este caso que hay cuatro candidatos, con identificadores 1, 2, 3, 4. Usted habrá de calcular mediante un programa, el número de votos correspondiente a cada candidato. El usuario ingresara los votos de manera desorganizada, tal y como se obtuvieron en la elección. El conteo de votos se detiene si se ingresa el valor cero. Observe, como ejemplo, la siguiente lista: 1 3 1 4 4 1 2 4 4 0.
2. Construir un pseudocódigo que solo permita ingresar números positivos, en caso de que el número no sea positivo debe volver a pedir que se ingrese el número hasta que el usuario ingrese un número positivo, luego mostrar el número
3.  Se lanza un dado reiteradas veces hasta que el valor del tiro es 1. Determinar la cantidad de veces que se lanzó el dado y el puntaje acumulado, si lo que se acumula es el valor del tiro.
4. Desarrolle un algoritmo que calcule el promedio de los primeros 10 números naturales usando la estructura REPETIR – HASTA QUE
5. Construir un pseudocódigo que valide la nota de un estudiante, el programa debe pedir la nota y solo si esta se encuentra en el rango de 0 a 20 se debe mostrar. Debe pedir la nota mientras esta se encuentre fuera de ese rango.

---

# Ejercicio 1

```psc
Proceso votaciones
  Definir v,a,b,c,d Como Entero
  // Contadores para cada cantidato
  a<-0
  b<-0
  c<-0
  d<-0
  Repetir
    Escribir "ingrese voto"
    leer v
    Si v=1 Entonces
      a<-a+1
    FinSi
    Si v=2 Entonces
      b<-b+1
    FinSi
    Si v=3 Entonces
      c<-c+1
    FinSi
    Si v=4 Entonces
      d<-d+1
    FinSi
  Hasta Que v=0 //Se detiene si v es CERO
  Escribir "votos del candidato 1=", a
  Escribir "votos del candidato 2=", b
  Escribir "votos del candidato 3=", c
  Escribir "votos del candidato 4=", d
FinProceso
```

# Ejercicio 2

```psc
Proceso soloPositivo
  Definir num Como Real
  Repetir
    Escribir "Ingrese un número"
    Leer num
  Hasta Que num > 0
  Escribir "El número es: ", num
FinProceso
```

# Ejercicio 3

```psc
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
```

# Ejercicio 4

```psc
Proceso Ejer4
	Definir suma, i Como Real
	Repetir
		suma = suma + i
		i = i + 1
	Hasta Que i = 10
	Escribir "El promedio es: ", suma / i
FinProceso
```

# Ejercicio 5

```psc
Proceso Ejer5
	Definir nota Como Real
	Repetir
		Escribir "Ingrese nota"
		Leer nota
	Hasta Que nota <= 20 y nota >= 0
	Escribir "Nota valida"
FinProceso
```