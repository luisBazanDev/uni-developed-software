Algoritmo descuentos
  Definir sueldo, dscto, sneto Como Real
  Escribir "Ingrese el sueldo"
  Leer sueldo
  Si sueldo <= 1000 Entonces
    dscto <- 0.1*sueldo
  SiNo
    Si sueldo <= 2000 Entonces
      dscto <- 0.05*(sueldo-1000)
    SiNo
      dscto <- 0.03*(sueldo-2000)
    FinSi
  FinSi
  sneto <- sueldo - dscto
  Escribir "Sueldo: S/", sueldo
  Escribir "Descuento: S/", dscto
  Escribir "Sueldo neto: S/", sneto
FinAlgoritmo