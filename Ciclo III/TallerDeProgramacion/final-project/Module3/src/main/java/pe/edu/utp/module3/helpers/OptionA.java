package pe.edu.utp.module3.helpers;

import pe.edu.utp.module3.domain.DepartamentoData;
import pe.edu.utp.provider.LogsManager;
import pe.edu.utp.provider.enums.LogsPriority;
import pe.edu.utp.provider.utils.FileExport;

import java.util.Scanner;

/**
 * @author Luis Bazan
 */
public class OptionA {
    /**
     * Metodo para generar una tabla con los datos
     * @param data Datos preprocesados, del ModuleRequest
     */
    public static void processData(DepartamentoData[] data) {
        // Almacena la tabla generada
        StringBuilder generatedTable = new StringBuilder();
        // Lógica para imprimir en pantalla con los formatos correspondientes
        generatedTable.append("""
                #######################################
                #  DEPARTAMENTO  #  CASOS  #   PORC   #
                #######################################\n""");

        for (DepartamentoData departamento : data) {
            generatedTable.append(String.format("#  %-12s  # %,6d  #  %05.2f%%  #%n", departamento.getName(), departamento.getAmount(), departamento.getPorcentage()));
        }

        generatedTable.append("#######################################");

        // Se muestra la tabla en consola
        System.out.println(generatedTable);
        LogsManager.print(LogsPriority.INFO, "Option A - Module 3: Imprimiendo resultados en pantalla");

        // Se consulta si se desea exportar la tabla
        LogsManager.print(LogsPriority.INFO, "Option A - Module 3: Usuario decidiendo si exportar la tabla o no");
        System.out.println("Desea exportar esta tabla? (S)... Enter para continuar.");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        // Logica de exportacion en caso se requiera
        if ("s".equalsIgnoreCase(option)) {
            FileExport.queryFile(generatedTable.toString());
            LogsManager.print(LogsPriority.INFO, "Option A - Module 3: Usuario decidio no exportar la tabla");
        } else {
            LogsManager.print(LogsPriority.INFO, "Option A - Module 3: Usuario decidio no exportar la tabla");
        }
    }
}
