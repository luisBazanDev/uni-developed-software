package pe.edu.utp.provider;

import pe.edu.utp.provider.enums.LogsPriority;
import pe.edu.utp.provider.domain.UserProvider;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Luis Bazan
 */
public class LogsManager {
    // Instancia que contiene el archivo donde se iran escribiendo los logs
    private static File logDir = new File("./logs");
    private static File file = new File(logDir, String.format(
            "%s.log",
            new SimpleDateFormat("HH-mm-ss-dd-MM-yyyy").format(new Date())
    ));

    // Instancia donde se almacenaran las líneas de logs creadas en el programa
    private static ArrayList<String> lines = new ArrayList<>();

    // Método para imprimir un log en el archivo, recibe como parámetros
    // un log priority para mayor facilidad al momento de leerlos
    // además un mensaje que será el error en sí, este método hará el
    // formateo del error con fecha, hora y el usuario que cometió el mismo

    /**
     * Metodo para imprimir un log en el archivo de logs
     * @param errorPriority Prioridad del error, {@link LogsPriority}
     * @param message Mensaje o información a imprimir en los logs
     */
    public static void print(LogsPriority errorPriority, String message) {
        checkFiles();
        String line = String.format(
                "[%tT %1$td/%1$tm/%1$tY] [Priority %s - %s]%n%s",
                new Date(),
                errorPriority.toString(),
                UserProvider.getUsername(),
                message
        );
        lines.add(line);
        try {
            FileWriter logsWriter = new FileWriter(file);
            logsWriter.write(String.join("\n", lines));
            logsWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void checkFiles() {
        if (!logDir.exists()) logDir.mkdir();
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error creating log file");
        }
    }
}
