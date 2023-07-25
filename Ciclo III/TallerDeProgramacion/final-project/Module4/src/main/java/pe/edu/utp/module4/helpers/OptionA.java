package pe.edu.utp.module4.helpers;

import pe.edu.utp.module4.domain.HospitalData;
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
    public static void processData(HospitalData[] data) {
        // Almacena la tabla generada
        StringBuilder generatedTable = new StringBuilder();
        // Imprimir los resultados
        generatedTable.append("###############################################################################################\n");
        generatedTable.append(String.format("# %6s # %-60s # %8s #   PORC   #%n", "Indice", "Centro de salud", "Cantidad"));
        generatedTable.append("###############################################################################################\n");
        int total = 0;
        for (HospitalData hospital : data) {
            generatedTable.append(String.format(
                    "#   %2d   # %-60s # %,8d #  %05.2f%%  #%n",
                    hospital.getIndex() + 1,
                    hospital.getName(),
                    hospital.getAmounts(),
                    hospital.getPercentage()
            ));
            total += hospital.getAmounts();
        }
        generatedTable.append("###############################################################################################\n");
        generatedTable.append(String.format("#%-70s # %,8d            #%n", "          Total:", total));
        generatedTable.append("###############################################################################################");

        // Se muestra la tabla en consola
        System.out.println(generatedTable);
        LogsManager.print(LogsPriority.INFO, "Option A - Module 4: Imprimiendo resultados en pantalla");

        // Se consulta si se desea exportar la tabla
        LogsManager.print(LogsPriority.INFO, "Option A - Module 4: Usuario decidiendo si exportar la tabla o no");
        System.out.println("Desea exportar esta tabla? (S)... Enter para continuar.");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        // Logica de exportacion en caso se requiera
        if ("s".equalsIgnoreCase(option)) {
            FileExport.queryFile(generatedTable.toString());
            LogsManager.print(LogsPriority.INFO, "Option A - Module 4: Usuario decidio no exportar la tabla");
        } else {
            LogsManager.print(LogsPriority.INFO, "Option A - Module 4: Usuario decidio no exportar la tabla");
        }
    }


    /*
        _        __        _     _______
        \\      //\\      //    //-----\\
         \\    //  \\    //     ||     ||
          \\  //    \\  //      ||-----||
           \\//      \\//       ||     ||
        --------------------------------
     */
}
