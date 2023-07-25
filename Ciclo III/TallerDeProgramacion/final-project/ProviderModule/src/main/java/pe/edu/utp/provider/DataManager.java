package pe.edu.utp.provider;

import pe.edu.utp.provider.enums.LogsPriority;
import pe.edu.utp.provider.domain.DengueCase;
import pe.edu.utp.provider.domain.Location;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Luis Bazan
 */
public class DataManager {
    // Instancias estáticas donde se guardaran los datos cargados en memoria
    private static ArrayList<DengueCase> dengueCases = new ArrayList<>();
    private static ArrayList<Location> locations = new ArrayList<>();

    // Método para leer él data set de los recursos de la clase
    /**
     * Método para leer los datos desde el dataset en los recursos.
     */
    public static void readData() {
        File datasetFile = new File("assets/Casos Dengue Perú 2023 (DATASET).csv");
        FileReader dataset = null;
        try {
            dataset = new FileReader(datasetFile);
        } catch (FileNotFoundException e) {
            LogsManager.print(LogsPriority.ERROR_HIGH, "No se puede cargar el dataset, FIN DEL PROGRAMA");
            System.out.println("No se encontró el dataset, FIN DEL PROGRAMA");
            System.exit(0);
            throw new RuntimeException(e);
        }

        // Se instancia el scanner y se revisa que el dataset exista
        Scanner scanner;
        scanner = new Scanner(dataset);

        int counter = 0;
        int lineNumber = 1;
        boolean isHeader = true;

        // Bucle principal para leer el dataset, con la logica del mismo
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] dataItems = line.split(",");
            if (isHeader) {
                isHeader = false;
            } else {
                // Una vez se validan ciertos parametros se intenta instanciar un objeto DengueCase
                // En caso no se pueda, esto devolvera un error en los logs indicando el numero de linea erronea
                DengueCase dengueCase = DengueCase.createFromStringData(dataItems);
                if (dengueCase == null) {
                    LogsManager.print(LogsPriority.INFO, String.format(
                            "Error when analyzing dengue case, line %d in dataset%n%s",
                            lineNumber,
                            line
                    ));
                    continue;
                }
                dengueCases.add(dengueCase);
                registerLocates(dengueCase);
                counter++;
            }
            lineNumber++;
        }
        // Informa por terminal y por logs, la cantidad de casos correctos que se cargaron
        // en el programa para el posterior analizis.
        System.out.printf("%d dengue cases were uploaded to analyze.%n", counter);
        LogsManager.print(LogsPriority.INFO,String.format(
                "%d dengue cases were uploaded to analyze.",
                counter
        ));
    }

    // Metodo para registrar las localidades del caso, en el esquema arbol de locaciones
    /**
     * Metodo para registrar las localidades del caso, en el esquema arbol de locaciones
     * @param dengueCase Caso de dengue válido.
     */
    private static void registerLocates(DengueCase dengueCase) {
        int index = locations.stream().map(x -> x.getName()).toList().indexOf(dengueCase.getDepartamento());
        if (index == -1) {
            locations.add(new Location(dengueCase.getDepartamento(), new String[]{dengueCase.getProvincia(), dengueCase.getDistrito(), dengueCase.getHospital()}));
        } else {
            locations.get(index).registerChildrens(new String[]{dengueCase.getProvincia(), dengueCase.getDistrito(), dengueCase.getHospital()});
        }
    }

    /**
     * Getter de la lista de casos de dengue cargados
     * @return Lista de casos de dengue
     */
    public static ArrayList<DengueCase> getDengueCases() {
        return dengueCases;
    }

    /**
     * Getter de la lista locaciones cargadas
     * @return Lista de locaciones cargadas
     */
    public static ArrayList<Location> getLocations() {
        return locations;
    }
}
