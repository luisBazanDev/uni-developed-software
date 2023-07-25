package pe.edu.utp;


import pe.edu.utp.module1.Module1;
import pe.edu.utp.module2.Module2;
import pe.edu.utp.module3.Module3;
import pe.edu.utp.module4.Module4;
import pe.edu.utp.provider.DataManager;
import pe.edu.utp.provider.LogsManager;
import pe.edu.utp.provider.enums.LogsPriority;
import pe.edu.utp.provider.domain.UserProvider;

import java.util.Scanner;

/**
 * @author Luis Bazan
 */
public class Main {
    /**
     * Menu principal de la aplicacion
     */
    public static void main() {
        // Se valida que exista un usuario logueado en la aplicacion
        if (UserProvider.getUsername() == null) return;
        // Variables principales
        boolean continues = true;
        Scanner scanner = new Scanner(System.in);
        DataManager.readData();

        // Bucle principal del menu principal, si este bucle termina
        // se cierra secion y en caso se necesite se acaba el programa completo
        do {
            System.out.println("""
                    --------------------------------------------------------
                                         MENU PRINCIPAL
                    --------------------------------------------------------
                    A. Número de pacientes atendidos por mes dado un rango de meses.
                    B. Número de pacientes atendidos por edad dado un rango de edades.
                    C. Número de pacientes atendidos por departamento dado sexo y rango de edades.
                    D. Número de pacientes atendidos por centro de salud, dado dpto. prov. Y dist.
                    E. Cerrar sesion.
                    F. Cerrar sesion y salir.
                    --------------------------------------------------------
                    """);
            System.out.print("Selecciona una opción: ");
            String option = scanner.nextLine();

            // Selector de opciones en el menu principal
            switch (option.toUpperCase()) {
                case "A":
                    LogsManager.print(LogsPriority.INFO, "Open module 1");
                    Module1.run();
                    break;
                case "B":
                    LogsManager.print(LogsPriority.INFO, "Open module 2");
                    Module2.run();
                    break;
                case "C":
                    LogsManager.print(LogsPriority.INFO, "Open module 3");
                    Module3.run();
                    break;
                case "D":
                    LogsManager.print(LogsPriority.INFO, "Open module 4");
                    Module4.run();
                    break;
                case "E":
                    LogsManager.print(LogsPriority.INFO, "Cerrando sesion de usuario");
                    continues = false;
                    UserProvider.setUsername(null);
                    continue;
                case "F":
                    LogsManager.print(LogsPriority.INFO, "Cerrando sesion y terminando el programa");
                    continues = false;
                    continue;
                default:
                    LogsManager.print(LogsPriority.ERROR_LOW, "Opcion invalida en el menu principal");
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                    break;
            }
        } while (continues);
    }
}
