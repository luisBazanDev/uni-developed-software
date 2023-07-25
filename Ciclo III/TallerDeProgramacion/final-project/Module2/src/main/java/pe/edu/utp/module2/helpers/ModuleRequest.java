package pe.edu.utp.module2.helpers;

import pe.edu.utp.module2.domain.AgeData;
import pe.edu.utp.provider.DataManager;
import pe.edu.utp.provider.LogsManager;
import pe.edu.utp.provider.domain.DengueCase;
import pe.edu.utp.provider.enums.AgeType;
import pe.edu.utp.provider.enums.LogsPriority;

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
    public static AgeData[] requestData() {
        // Inicialización de variables para el programa
        Scanner scanner = new Scanner(System.in);
        int minAge = 0, maxAge = 0;
        AgeType ageType;

        // Lógica para seleccionar el tipo de edad a evaluar
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
                System.out.print("Ingrese el limite inferior a buscar: ");
                minAge = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Ingrese el limite superior a buscar: ");
                maxAge = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                LogsManager.print(LogsPriority.ERROR_MEDIUM, "Module 2\n"+e);
                scanner.nextLine();
                minAge = -1;
                maxAge = -1;
                continue;
            }

            if (minAge < 0 || maxAge < 0) {
                LogsManager.print(LogsPriority.ERROR_LOW, "Module 2: Usuario ingreso edades invalidas");
                System.out.println("Edades fuera de rango. Ingrese las edades nuevamente.");
                continue;
            }
            if (minAge > maxAge) {
                LogsManager.print(LogsPriority.ERROR_LOW, "Module 2: Usuario ingreso un rango de edades invalidas");
                System.out.println("Limites invalidos. Ingrese las edades nuevamente.");
                minAge = -1;
                maxAge = -1;
                continue;
            }
        } while (minAge < 0 || maxAge < 0);

        // Lógica para generar las estadísticas
        int[] amounts = new int[maxAge - minAge + 1];
        long total = 0;
        for (DengueCase dengueCase : DataManager.getDengueCases()) {
            if (dengueCase.getAge(ageType) < minAge || dengueCase.getAge(ageType) > maxAge) continue;
            amounts[dengueCase.getAge(ageType) - minAge]++;
            total++;
        }

        AgeData[] data = new AgeData[maxAge - minAge + 1];
        for (int i = 0; i < data.length; i++) {
            data[i] = new AgeData(
                    i + minAge,
                    amounts[i],
                    (double) amounts[i] * 100 / total,
                    ageType
            );
        }

        return data;
    }
}
