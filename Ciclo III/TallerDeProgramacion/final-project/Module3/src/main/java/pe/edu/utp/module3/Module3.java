package pe.edu.utp.module3;

import pe.edu.utp.module3.domain.DepartamentoData;
import pe.edu.utp.module3.helpers.ModuleRequest;
import pe.edu.utp.module3.helpers.OptionA;
import pe.edu.utp.module3.helpers.OptionB;
import pe.edu.utp.provider.LogsManager;
import pe.edu.utp.provider.enums.LogsPriority;

import java.util.Scanner;

/**
 * @author Luis Bazan
 */
public class Module3 {
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
                    MÓDULO 03 – PACIENTES POR DEPARTAMENTO DADO UN SEXO Y RANGO DE EDADES
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
                    LogsManager.print(LogsPriority.INFO, "Option A - Module 3");
                    DepartamentoData[] data = ModuleRequest.requestData();
                    OptionA.processData(data);
                    break;
                case "B":
                    LogsManager.print(LogsPriority.INFO, "Option B - Module 3");
                    data = ModuleRequest.requestData();
                    OptionB.processData(data);
                    break;
                case "C":
                    LogsManager.print(LogsPriority.INFO, "Option C - Module 3");
                    continues = false;
                    continue;
                default:
                    LogsManager.print(LogsPriority.ERROR_LOW, "Invalid option - Module 3");
                    System.out.println("Opción invalida");
                    break;
            }
        } while (continues);
    }
}