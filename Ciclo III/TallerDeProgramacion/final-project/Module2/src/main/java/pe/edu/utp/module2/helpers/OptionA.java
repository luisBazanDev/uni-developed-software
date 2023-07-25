package pe.edu.utp.module2.helpers;

import pe.edu.utp.module2.domain.AgeData;
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
    public static void processData(AgeData[] data) {
        // Almacena la tabla generada
        StringBuilder generatedTable = new StringBuilder();
        // Lógica para imprimir las estadísticas generadas
        generatedTable.append("""
                #######################################
                # Edad # Tipo #  Cantidad  #   PORC   #
                #######################################
                """);
        int total = 0;
        for (AgeData age : data) {
            generatedTable.append(String.format("# %4d #  %2s  #  %,8d  #  %05.2f%%  #%n", age.getAge(), age.getAgeType(), age.getAmount(), age.getPorcentage()));
            total += age.getAmount();
        }
        generatedTable.append("#######################################\n");
        generatedTable.append(String.format("Total: %,7d%n", total));

        // Se muestra la tabla en consola
        System.out.println(generatedTable);
        LogsManager.print(LogsPriority.INFO, "Option A - Module 2: Imprimiendo resultados en pantalla");

        // Se consulta si se desea exportar la tabla
        LogsManager.print(LogsPriority.INFO, "Option A - Module 2: Usuario decidiendo si exportar la tabla o no");
        System.out.println("Desea exportar esta tabla? (S)... Enter para continuar.");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        // Logica de exportacion en caso se requiera
        if ("s".equalsIgnoreCase(option)) {
            FileExport.queryFile(generatedTable.toString());
            LogsManager.print(LogsPriority.INFO, "Option A - Module 2: Usuario decidio no exportar la tabla");
        } else {
            LogsManager.print(LogsPriority.INFO, "Option A - Module 2: Usuario decidio no exportar la tabla");
        }
    }
}
