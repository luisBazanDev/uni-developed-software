package pe.edu.utp.dwi.s01;


import java.io.File;
import java.util.Scanner;

public class CounterWordsInFile {
    public static void main(String[] args) {
        boolean next = true;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Ingrese ruta del archivo:");
            String ruta = sc.nextLine();

            // Valid file
            File file = new File(ruta);

            if (file.exists() && file.isFile()) {
                Counter counter = new Counter(file.getPath());
                counter.count();
                System.out.println(counter);
            }

            System.out.println();

            System.out.println("Desea terminar? (y)");
            if(sc.nextLine().equalsIgnoreCase("y")){
                next = false;
            }
        } while (next);
    }
}
