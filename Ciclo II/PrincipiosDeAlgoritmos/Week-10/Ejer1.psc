Proceso operadores
  Definir n1, n2 Como Real
  Definir simbolo Como Caracter
  Escribir "Ingrese los números"
  Leer n1, n2
  Escribir "Ingrese el símbolo (+,-,x,/)"
  Leer simbolo
  Segun simbolo hacer
    Caso "+":
      Escribir n1 , " + ", n2, " = ", (n1+n2)
    Caso "-":
      Escribir n1 , " - ", n2, " = ", (n1-n2)
    Caso "x":
      Escribir n1 , " x ", n2, " = ", (n1*n2)
    Caso "/":
      Si n2 <> 0 Entonces
        Escribir n1 , " ÷ ", n2, " = ", (n1/n2)
      SiNo
        Escribir "No se puede dividir entre cero"
      FinSi
  De Otro Modo:
    Escribir "ADVERTENCIA: Operador inválido"
  FinSegun
FinProceso
