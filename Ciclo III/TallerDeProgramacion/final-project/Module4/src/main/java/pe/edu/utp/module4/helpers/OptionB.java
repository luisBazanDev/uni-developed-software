package pe.edu.utp.module4.helpers;

import pe.edu.utp.module4.domain.HospitalData;
import pe.edu.utp.provider.utils.FileExport;

/**
 * @author Luis Bazan
 */
public class OptionB {
    /**
     * Metodo para exportar los datos creados
     * @param data Datos preprocesados, del ModuleRequest
     */
    public static void processData(HospitalData[] data) {
        // Exportar resultados
        StringBuilder export = new StringBuilder("");

        for (HospitalData hospital : data) {
            export.append(String.format("%d;%s;%d;%.2f%n",
                    hospital.getIndex(),
                    hospital.getName(),
                    hospital.getAmounts(),
                    hospital.getPercentage()
                    ));
        }

        FileExport.queryFile(export.toString());
    }
}
