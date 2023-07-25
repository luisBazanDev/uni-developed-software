package pe.edu.utp.module4.helpers;

import pe.edu.utp.module4.domain.HospitalData;
import pe.edu.utp.provider.DataManager;
import pe.edu.utp.provider.LogsManager;
import pe.edu.utp.provider.domain.DengueCase;
import pe.edu.utp.provider.domain.Location;
import pe.edu.utp.provider.enums.LogsPriority;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Luis Bazan
 */
public class ModuleRequest {
    /**
     * Metodo del modulo para pedir el ingreso de datos al usuario
     * @return Arreglo con los datos ya preprocesados
     */
    public static HospitalData[] requestData() {
        // Lógica para solicitar departamento, provincia y distrito
        Location dpto;
        Location prov;
        Location dist;
        dpto = query(DataManager.getLocations());
        prov = query(dpto.getChildrens());
        dist = query(prov.getChildrens());

        int[] counter = new int[dist.getChildrens().size()];
        int total = 0;

        for (DengueCase dengueCase : DataManager.getDengueCases()) {
            // Filtrar los casos de dengue que coinciden con el departamento, provincia y distrito seleccionados
            if (
                    !dengueCase.getDepartamento().equalsIgnoreCase(dpto.getName())
                            || !dengueCase.getProvincia().equalsIgnoreCase(prov.getName())
                            || !dengueCase.getDistrito().equalsIgnoreCase(dist.getName())
            ) {
                continue; // Saltar a la siguiente iteración si no coincide
            }
            // Contar los casos en función del centro de salud (hospital)
            int index = dist.getChildrens().stream().map(Location::getName).toList().indexOf(dengueCase.getHospital());
            if (index >= 0) {
                counter[index]++;
            }
            total++;
        }

        HospitalData[] data = new HospitalData[dist.getChildrens().size()];
        for (int i = 0; i < data.length; i++) {
            HospitalData hospitalData = new HospitalData(
                    i,
                    dist.getChildrens().get(i).getName(),
                    counter[i],
                    (double) counter[i] * 100 / total
            );
            data[i] = hospitalData;
        }

        return data;
    }

    private static Location query (ArrayList<Location> locations) {
        Scanner scanner = new Scanner(System.in);
        // Mostrar las opciones de ubicación para que el usuario seleccione
        for (int i = 0; i < locations.size(); i++) {
            System.out.printf("%d.%s%n", i+1, locations.get(i).getName());
        }
        int index;
        do {
            System.out.print("Ingresa el índice a buscar: ");
            try {
                index = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                LogsManager.print(LogsPriority.INFO, "Ingreso de dato erroneo: " + e);
                index = 0;
                scanner.nextLine();
            }
        } while (index > locations.size() || index <= 0);
        return locations.get(index-1);
    }
}
