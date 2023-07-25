package pe.edu.utp.module1.helpers;

import pe.edu.utp.module1.domain.MonthData;
import pe.edu.utp.provider.DataManager;
import pe.edu.utp.provider.LogsManager;
import pe.edu.utp.provider.domain.DengueCase;
import pe.edu.utp.provider.enums.LogsPriority;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Luis Bazan
 */
public class ModuleRequest {
    /**
     * Metodo del modulo para pedir el ingreso de datos al usuario
     * @return Arreglo con los datos ya preprocesados
     */
    public static MonthData[] requestData() {
        // Inicializamos las variavles a usar
        Scanner scanner = new Scanner(System.in);
        int min = 0, max = 0;

        // Ingreso de rango de edades
        do {
            try {
                System.out.print("Ingresa el limite inferior del rango de meses(1-12): ");
                min = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Ingresa el limite superior del rango de meses(1-12): ");
                max = scanner.nextInt();
                scanner.nextLine();
                if (
                        min < 1 || min > 12
                        || max < 1 || max > 12
                ) {
                    System.out.println("Alguno de los limites sale del rango(1-12), vuelve a ingresarlos ");
                    LogsManager.print(LogsPriority.ERROR_LOW, "Module 1: valores ingresados fuera de rango");
                    continue;
                }
                if (min > max) {
                    System.out.println("Los limites invalidos, el limite inferior tiene que ser menor que el limite superior.");
                    min = 0;
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error de ingreso de datos, Solo ingresar valores númericos");
                min = 0;
                max = 0;
                scanner.nextLine();
                LogsManager.print(LogsPriority.ERROR_MEDIUM, "Module 1\n"+e);
            }
        } while (min < 1 || min > 12 || max < 1 || max > 12);

        // Bucle principal para crear las estadisticas
        int[] amounts = new int[max - min + 1];
        int total = 0;
        for (int i = min - 1; i < max; i++) {
            for (DengueCase dengueCase : DataManager.getDengueCases()) {
                if (dengueCase.getIncome().getMonth() == i) {
                    amounts[i - min + 1]++;
                    total++;
                }
            }
        }

        // Crea una interfaz para poder procesar los archivos posteriormente
        MonthData[] months = new MonthData[max - min + 1];
        for (int i = 0; i < months.length; i++) {
            months[i] = new MonthData(
                    Month.of(i + min).getDisplayName(TextStyle.SHORT, new Locale("es")).toUpperCase(),
                    amounts[i],
                    (double) (amounts[i] * 100) / total
            );
        }

        return months;
    }
}
