package pe.edu.utp.module3.helpers;

import pe.edu.utp.module3.domain.DepartamentoData;
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
    public static void processData(DepartamentoData[] data) {
        // Lógica para exportar los datos
        StringBuilder export = new StringBuilder(String.format("DEPARTAMENTO;CASOS;PORC%n"));
        for (DepartamentoData departamento : data) {
            export.append(String.format("%s;%d;%.2f%n", departamento.getName(), departamento.getAmount(), departamento.getPorcentage()));
        }

        // Lógica para solicitar la ruta del archivo a exportar
        if (FileExport.queryFile(export.toString())) {
            System.out.println("Archivo exportado correctamente!");
            LogsManager.print(LogsPriority.INFO, "Option B - Module 3: Archivo exportado correctamente");
        } else {
            System.out.println("Operacion cancelada.");
            LogsManager.print(LogsPriority.INFO, "Option B - Module 3: Exportacion cancelada");
        };
    }
}
