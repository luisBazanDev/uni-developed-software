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