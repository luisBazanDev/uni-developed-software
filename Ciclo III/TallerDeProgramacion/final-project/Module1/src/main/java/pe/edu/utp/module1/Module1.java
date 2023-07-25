package pe.edu.utp.module1;

import pe.edu.utp.module1.domain.MonthData;
import pe.edu.utp.module1.helpers.ModuleRequest;
import pe.edu.utp.module1.helpers.OptionA;
import pe.edu.utp.module1.helpers.OptionB;
import pe.edu.utp.provider.LogsManager;
import pe.edu.utp.provider.enums.LogsPriority;

import java.util.Scanner;

/**
 * @author Luis Bazan
 */
public class Module1 {
    /**
     *  Metodo llamado para ejecutar este modulo
     */
    public static void run() {
        boolean continues = true;
        Scanner scanner = new Scanner(System.in);

        // Bucle principal del modulo, una vez termina se regresa al menu principal
        do {
            System.out.println("""
                    --------------------------------------------------------
                    MÓDULO 01 – PACIENTES POR MES DADO UN RANGO DE MESES
                    --------------------------------------------------------
                    A. Imprimir por pantalla.
                    B. Exportar a archivo plano.
                    C. Volver al Menú Principal
                    --------------------------------------------------------
                    """);
            System.out.print("Selecciona una opción: ");
            String option = scanner.nextLine();
            // Selección de opciones para el módulo
            switch (option.toUpperCase()) {
                case "A":
                    LogsManager.print(LogsPriority.INFO, "Option A - Module 1");
                    MonthData[] data = ModuleRequest.requestData();
                    OptionA.processData(data);
                    break;
                case "B":
                    LogsManager.print(LogsPriority.INFO, "Option B - Module 1");
                    data = ModuleRequest.requestData();
                    OptionB.processData(data);
                    break;
                case "C":
                    LogsManager.print(LogsPriority.INFO, "Option C - Module 1");
                    continues = false;
                    continue;
                default:
                    LogsManager.print(LogsPriority.ERROR_LOW, "Invalid option - Module 1");
                    System.out.println("Opción invalida");
                    break;
            }
        } while (continues);
    }
}