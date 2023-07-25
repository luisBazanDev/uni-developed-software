package pe.edu.utp.auth;

import pe.edu.utp.Main;
import pe.edu.utp.provider.LogsManager;
import pe.edu.utp.provider.enums.LogsPriority;
import pe.edu.utp.provider.domain.UserData;
import pe.edu.utp.provider.domain.UserProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase que ejecuta el programa
 * @author Luis Bazan
 */
public class AuthMain {
    // La única funcion de este atributo es almacenar la lista de usuarios del archivo de users
    private static UserData[] users = new UserData[0];

    /**
     * Metodo principal para ejecutar el programa
     * @param args Argumentos del IDE al ejecutar
     */
    public static void main(String[] args) {
        // Se cargan los usuarios en memoria desde el archivo accounts.txt
        loadUsers();
        // Se inicializan las variables para validar el login correcto y si se debe detener el programa
        Scanner scanner = new Scanner(System.in);
        boolean login = false;
        boolean breakProgram = false;
        // El bucle principal del programa, una vez termina, se detiene el programa
        do {
            int intents = 0;
            // El blucle del login, una vez termina este bucle no debe haber ningún usuario logueado
            do {
                login = false;
                System.out.println("""
                #####################
                Inicio de sesion
                # Escribe \"STOP\" para acabar el programa
                #####################
                Usuario:""");
                String username = scanner.nextLine();
                if (username.equalsIgnoreCase("stop")) {
                    breakProgram = true;
                    break;
                }
                System.out.println("Contraseña:");
                String password = scanner.nextLine();
                // Se comparan los datos ingresados por el usuario con los datos
                // extraídos del archivo accounts.txt
                for (UserData user : users) {
                    if (user.compareUser(username, password)) {
                        UserProvider.setUsername(username);
                        login = true;
                        System.out.printf("Bienvenido %s%n", username);
                        LogsManager.print(LogsPriority.INFO, String.format(
                                "Login of user %s",
                                username
                        ));
                        break;
                    }
                }
                if (!login) {
                    System.out.println("Usuario o contraseña invalidos.");
                    LogsManager.print(LogsPriority.INFO, "Usuario o contraseña invalidos.");
                    intents++;
                    if (intents < 3) {
                        System.out.printf("Te quedan %d intentos.%n", 3 - intents);
                    } else {
                        System.out.println("Excediste el limite de intentos.");
                        breakProgram = true;
                        break;
                    }
                }
            } while (!login);
            if (!breakProgram) Main.main();
        } while (UserProvider.getUsername() == null && !breakProgram);
    }

    /**
     * Método para cargar los usuarios en memoria desde el archivo accounts.txt
     */
    public static void loadUsers() {
        // Se carga el archivo desde los recursos de la clase
        File accounts = new File("./assets/accounts.txt");
        // Se valida que exista el archivo
        if (accounts == null) return;
        Scanner scanner = null;
        try {
            scanner = new Scanner(accounts);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Bucle principal para leer los usuarios desde el archivo
        int accountsNumber = 0;
        int errorLines = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = line.replaceAll(" ", "");
            line = line.replaceFirst(";", " ");
            String[] accountData = line.split(" ");
            if (accountData.length != 2) {
                LogsManager.print(LogsPriority.ERROR_MEDIUM, String.format(
                        "Error on load account data line %d%n",
                        accountsNumber + errorLines + 1
                ));
                errorLines++;
                continue;
            }
            users = Arrays.copyOf(users, users.length + 1);
            users[users.length - 1] = new UserData(accountData[0], accountData[1]);
            accountsNumber++;
        }
    }
}