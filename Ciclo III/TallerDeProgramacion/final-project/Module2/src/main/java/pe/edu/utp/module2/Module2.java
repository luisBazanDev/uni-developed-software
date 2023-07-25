package pe.edu.utp.module2;

import pe.edu.utp.module2.domain.AgeData;
import pe.edu.utp.module2.helpers.ModuleRequest;
import pe.edu.utp.module2.helpers.OptionA;
import pe.edu.utp.module2.helpers.OptionB;
import pe.edu.utp.provider.LogsManager;
import pe.edu.utp.provider.enums.LogsPriority;

import java.util.Scanner;

/**
 * @author Luis Bazan
 */
public class Module2 {
    /**
     *  Metodo llamado para ejecutar este modulo
     */
    public static void run() {
        // Inicialización de variables para el programa
        boolean continues = true;
        Scanner scanner = new Scanner(System.in);

        // Bucle principal, una vez termina vuelve al menu principal
        do {
            System.out.println("""
                    --------------------------------------------------------
                    MÓDULO 02 – PACIENTES POR EDAD DADO UN RANGO DE EDADES
                    --------------------------------------------------------
                    A. Imprimir por pantalla.
                    B. Exportar a archivo plano.
                    C. Volver al Menú Principal
                    --------------------------------------------------------
                    """);
            System.out.print("Selecciona una opción: ");
            String option = scanner.nextLine();
            // Selección de opciones del módulo
            switch (option.toUpperCase()) {
                case "A":
                    LogsManager.print(LogsPriority.INFO, "Option A - Module 1");
                    AgeData[] data = ModuleRequest.requestData();
                    OptionA.processData(data);
                    break;
                case "B":
                    LogsManager.print(LogsPriority.INFO, "Option B - Module 2");
                    data = ModuleRequest.requestData();
                    OptionB.processData(data);
                    break;
                case "C":
                    LogsManager.print(LogsPriority.INFO, "Option C - Module 2");
                    continues = false;
                    continue;
                default:
                    LogsManager.print(LogsPriority.ERROR_LOW, "Invalid option - Module 2");
                    System.out.println("Opción invalida");
                    break;
            }
        } while (continues);
    }
}