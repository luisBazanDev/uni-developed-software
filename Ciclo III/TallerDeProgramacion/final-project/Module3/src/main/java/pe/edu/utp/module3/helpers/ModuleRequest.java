package pe.edu.utp.module3.helpers;

import pe.edu.utp.module3.domain.DepartamentoData;
import pe.edu.utp.provider.DataManager;
import pe.edu.utp.provider.LogsManager;
import pe.edu.utp.provider.domain.DengueCase;
import pe.edu.utp.provider.enums.AgeType;
import pe.edu.utp.provider.enums.LogsPriority;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Luis Bazan
 */
public class ModuleRequest {
    /**
     * Metodo del modulo para pedir el ingreso de datos al usuario
     * @return Arreglo con los datos ya preprocesados
     */
    public static DepartamentoData[] requestData() {
        // variables a usar en este programa
        Scanner scanner = new Scanner(System.in);
        Boolean genre = null;
        int minAge = 0, maxAge = 0;
        AgeType ageType;

        // Lógica para solicitar el tipo de edades que se va a solicitar (dias/meses/años).
        String option;
        do {
            System.out.printf("Ingresa que tipo de edad a buscar%n");
            System.out.printf("D - Días%n");
            System.out.printf("M - Meses%n");
            System.out.printf("A - Años%n");
            System.out.print("Selecciona una opción: ");
            option = scanner.nextLine().toUpperCase();
        } while (!option.equals("D") && !option.equals("M") && !option.equals("A"));
        ageType = AgeType.valueOf(option);

        // Lógica para ingresar el rango de edades a buscar. Incluye manejo de errores
        do {
            try {
                System.out.print("Ingrese el limite de edad inferior a buscar: ");
                minAge = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Ingrese el limite de edad superior a buscar: ");
                maxAge = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                minAge = -1;
                maxAge = -1;
                scanner.nextLine();
                LogsManager.print(LogsPriority.ERROR_MEDIUM, "Module 3\n"+e);
                continue;
            }

            if (minAge < 0 || maxAge < 0) {
                LogsManager.print(LogsPriority.ERROR_LOW, "Module 3: Usuario ingreso edades invalidas");
                System.out.println("Edades fuera de rango. Ingrese las edades nuevamente.");
                continue;
            }
            if (minAge > maxAge) {
                LogsManager.print(LogsPriority.ERROR_LOW, "Module 3: Usuario ingreso un rango de edades invalidas");
                System.out.println("Limites invalidos. Ingrese las edades nuevamente.");
                minAge = -1;
                maxAge = -1;
                continue;
            }
        } while (minAge < 0 || maxAge < 0);

        // Lógica para solicitar el género a buscar. Incluye manejo de errores
        do {
            System.out.println("Ingrese el sexo a buscar - (H hombres/M mujeres)");
            option = scanner.nextLine().toUpperCase();
            if (option.equals("H")) {
                genre = true;
            } else if (option.equals("M")) {
                genre = false;
            } else {
                LogsManager.print(LogsPriority.ERROR_LOW, "Module 3: Usuario un genero invalido");
                System.out.println("El genero ingresado es erroneo");
            }
        } while (genre == null);

        // Inicializamos arrays para almacenar los datos y posteriormente mostrarlos en pantalla
        ArrayList<Integer> amounts = new ArrayList<>();
        ArrayList<String> dptos = new ArrayList<>();
        int total = 0;

        for (DengueCase dengueCase : DataManager.getDengueCases()) {
            // Filtro de casos dengue que no cumplen los requisitos
            if (
                    dengueCase.getGenre() != genre.booleanValue()
                            || dengueCase.getAge(ageType) < minAge
                            || dengueCase.getAge(ageType) > maxAge
            ) continue;

            // Lógica para almacenar los datos estadísticos
            int index = dptos.indexOf(dengueCase.getDepartamento());
            if (index == -1) {
                dptos.add(dengueCase.getDepartamento());
                amounts.add(1);
            } else {
                amounts.set(index, amounts.get(index) + 1);
            }
            total++;
        }

        DepartamentoData[] data = new DepartamentoData[amounts.size()];
        for (int i = 0; i < data.length; i++) {
            DepartamentoData departamentoData = new DepartamentoData(
                    dptos.get(i),
                    amounts.get(i),
                    (double) amounts.get(i) * 100 / total
            );
            data[i] = departamentoData;
        }
        return data;
    }
}
