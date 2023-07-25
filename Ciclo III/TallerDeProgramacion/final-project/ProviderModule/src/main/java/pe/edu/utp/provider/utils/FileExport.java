package pe.edu.utp.provider.utils;

import pe.edu.utp.provider.LogsManager;
import pe.edu.utp.provider.enums.LogsPriority;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Luis Bazan
 */
public class FileExport {
    /**
     * Solicitar una ruta de archivo al usuario  y guarda la data recibida
     * @param data String a guardar en el archivo solicitado
     * @return true cuando el archivo es exportado correctamente
     */
    public static boolean queryFile(String data) {
        File file;
        Scanner scanner = new Scanner(System.in);
        boolean continues = true;

        do {
            // Solicitar al usuario la ruta de destino para exportar el archivo
            System.out.println("Ingresa la ruta a exportar el archivo:");
            file = new File(scanner.nextLine());

            if (file.exists()) {
                // El archivo ya existe, preguntar al usuario si desea reescribirlo
                LogsManager.print(LogsPriority.ERROR_LOW, "Query file util: La ruta del archivo ingresado ya existe, y el usuario esta decidiendo si reescribir lo o no.");
                boolean ready = false;
                do {
                    System.out.println("El archivo ya existe, quieres reescribirlo? (S/N):");
                    String option = scanner.nextLine();
                    switch (option.toUpperCase()) {
                        case "S":
                            LogsManager.print(LogsPriority.INFO, "Query file util: Usuario eligio reescribir el archivo");
                            ready = true;
                            continues = false;
                            continue;
                        case "N":
                            LogsManager.print(LogsPriority.INFO, "Query file util: Usuario eligio no reescribir el archivo");
                            ready = true;
                    }
                } while (!ready);
            } else if (!createFile(file)) {
                // No se pudo crear el archivo
                LogsManager.print(LogsPriority.ERROR_LOW, "Queryfile util: El archivo no se pudo crear.");
                file = null;
                System.out.println("No se pudo crear el archivo, intentalo denuevo.");
                boolean ready = false;
                do {
                    System.out.println("quieres volver a intentar guardar el archivo? (S/N):");
                    String option = scanner.nextLine();
                    switch (option.toUpperCase()) {
                        case "S":
                            LogsManager.print(LogsPriority.INFO, "Query file util: Usuario eligio intentar denuevo la exportacion del archivo.");
                            ready = true;
                            break;
                        case "N":
                            LogsManager.print(LogsPriority.INFO, "Query file util: Usuario eligio no intentar denuevo la exportacion del archivo.");
                            ready = true;
                            return false;
                    }
                } while (!ready);
            } else {
                continues = false;
            }
        } while (continues);

        // Exportar la data creada al archivo
        try {
            FileWriter fileWriter = new FileWriter(file);

            fileWriter.write(data);
            fileWriter.close();
        } catch (IOException e) {
            // Ocurrió un error al exportar el archivo
            return false;
        }

        return true;
    }

    public static boolean createFile(File file) {
        try {
            // Crear un nuevo archivo
            LogsManager.print(LogsPriority.INFO, String.format("File export: Se creó el archivo \"%s\"", file.getAbsolutePath()));
            return file.createNewFile();
        } catch (IOException e) {
            LogsManager.print(LogsPriority.ERROR_MEDIUM, String.format("File export: No se puedo crear el archivo \"%s\"", file.getAbsolutePath()));
            return false;
        }
    }
}
