package pe.edu.utp.module2.helpers;

import pe.edu.utp.module2.domain.AgeData;
import pe.edu.utp.provider.LogsManager;
import pe.edu.utp.provider.enums.LogsPriority;
import pe.edu.utp.provider.utils.FileExport;

/**
 * @author Luis Bazan
 */
public class OptionB {
    /**
     * Metodo para exportar los datos creados
     * @param data Datos preprocesados, del ModuleRequest
     */
    public static void processData(AgeData[] data) {
        // Lógica para exportar los datos generados
        StringBuilder export = new StringBuilder(String.format("EDAD;TIPO_EDAD;CANTIDAD;PORC%n"));
        for (AgeData age : data) {
            export.append(String.format(
                    "%d;%s;%d;%.2f",
                    age.getAge(),
                    age.getAgeType(),
                    age.getAmount(),
                    age.getPorcentage()
            ));
        }

        // Lógica para solicitar la ruta del archivo a exportar
        if (FileExport.queryFile(export.toString())) {
            System.out.println("Archivo exportado correctamente!");
            LogsManager.print(LogsPriority.INFO, "Option B - Module 2: Archivo exportado correctamente");
        } else {
            System.out.println("Operacion cancelada.");
            LogsManager.print(LogsPriority.INFO, "Option B - Module 2: Exportacion cancelada");
        };
    }
}
