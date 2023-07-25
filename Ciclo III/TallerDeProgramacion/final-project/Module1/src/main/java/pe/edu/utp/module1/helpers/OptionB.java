package pe.edu.utp.module1.helpers;

import pe.edu.utp.module1.domain.MonthData;
import pe.edu.utp.provider.DataManager;
import pe.edu.utp.provider.LogsManager;
import pe.edu.utp.provider.enums.LogsPriority;
import pe.edu.utp.provider.domain.DengueCase;
import pe.edu.utp.provider.utils.FileExport;

import java.io.File;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Luis Bazan
 */
public class OptionB {
    /**
     * Metodo para exportar los datos creados
     * @param data Datos preprocesados, del ModuleRequest
     */
    public static void processData(MonthData[] data) {
        // Lógica para exportar los datos generados
        StringBuilder export = new StringBuilder(String.format("MES;CASOS;PORC%n"));

        for (MonthData month : data) {
            export.append(String.format("%s;%d;%.2f%n", month.getMoth(), month.getAmount(), month.getPercentage()));
        }

        // Lógica para solicitar la ruta del archivo a exportar
        if (FileExport.queryFile(export.toString())) {
            System.out.println("Archivo exportado correctamente!");
            LogsManager.print(LogsPriority.INFO, "Option B - Module 1: Archivo exportado correctamente");
        } else {
            System.out.println("Operacion cancelada.");
            LogsManager.print(LogsPriority.INFO, "Option B - Module 1: Exportacion cancelada");
        };
    }
}
