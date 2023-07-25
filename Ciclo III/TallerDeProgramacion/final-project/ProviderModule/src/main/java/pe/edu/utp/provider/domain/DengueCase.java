package pe.edu.utp.provider.domain;

import pe.edu.utp.provider.enums.AgeType;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase principal del programa
 * Esta clase tiene metodos para una mejor accesibilidad de los
 * datos en el programa. El uso de esta clase es el poder representar
 * los datos del Dataset, es de solo lectura asi que no cuenta con setters.
 * @author Luis Bazan
 */
public class DengueCase {
    // Datos que almacena cada caso
    private final Date income;
    private final String departamento;
    private final String provincia;
    private final String distrito;
    private final String hospital;
    private final int age;
    private final AgeType ageType;
    private final boolean genre;

    // Constructor principal
    /**
     * Constructor completo de la clase
     * @param income Fecha del reporte.
     * @param departamento Nombre del departamento del caso registrado.
     * @param provincia Nombre de la provincia del caso registrado.
     * @param distrito Nombre del distrito del caso registrado.
     * @param hospital Nombre del hospital del caso registrado.
     * @param age Edad del paciente.
     * @param ageType Tipo de edad del paciente {@link AgeType}
     * @param genre Género del paciente, true = hombre, false = mujer.
     */
    public DengueCase(Date income, String departamento, String provincia, String distrito, String hospital, int age, AgeType ageType, boolean genre) {
        this.income = income;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.hospital = hospital;
        this.age = age;
        this.ageType = ageType;
        this.genre = genre;
    }

    // Getters
    /**
     * Getter de la fecha del caso
     * @return Fecha del caso
     */
    public Date getIncome() {
        return income;
    }

    /**
     * Getter del nombre del departamento del caso
     * @return Nombre del departamento del caso
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Getter del nombre de la provincia del caso
     * @return Nombre de la provincia del caso
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Getter del nombre del distrito del caso
     * @return Nombre del distrito del caso
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * Getter del nombre del hospital del caso
     * @return Nombre del hospital del caso
     */
    public String getHospital() {
        return hospital;
    }

    /**
     * Getter del valor de la edad del paciente.
     * @return Valor de la edad del paciente.
     */
    public int getAge() {
        return age;
    }

    // Método para convertir la edad del individuo a días, meses o años,
    // Según se requiera en el programa
    /**
     * Método para convertir la edad del individuo a días, meses o años.
     * @param formatType Tipo de edad requerido
     * @return Valor de la edad convertido
     */
    public int getAge(AgeType formatType) {
        return switch (formatType) {
            case A -> switch (this.ageType) {
                case A -> age;
                case M -> age / 12;
                case D -> age / 365;
            };
            case M -> switch (this.ageType) {
                case A -> age * 12;
                case M -> age;
                case D -> age / 30;
            };
            case D -> switch (this.ageType) {
                case A -> age * 365;
                case M -> age * 30;
                case D -> age;
            };
        };
    }

    /**
     * Getter del tipo de edad del paciente
     * @return Tipo de edad del paciente
     */
    public AgeType getAgeType() {
        return ageType;
    }

    /**
     * Getter del género del paciente
     * @return Género del paciente
     */
    public boolean getGenre() {
        return genre;
    }

    // Método toString, es usado principalmente para test en el desarrollo del programa
    /**
     * Método toString, es usado principalmente para test en el desarrollo del programa
     * @return Cadena de texto con los atributos del objeto
     */
    @Override
    public String toString() {
        return "DengueCase{" +
                "income=" + income +
                ", departamento='" + departamento + '\'' +
                ", provincia='" + provincia + '\'' +
                ", distrito='" + distrito + '\'' +
                ", hospital='" + hospital + '\'' +
                ", age=" + age +
                ", ageType=" + ageType +
                ", genre=" + genre +
                '}';
    }

    // Método que crea una instancia del objeto, a partir de los datos en un array
    /**
     * Método que crea una instancia del objeto, a partir de los datos en un array
     * @param data Lista de Strings de 8 de longitud
     * @return Un objeto de la clase {@link DengueCase} o un valor nulo
     */
    public static DengueCase createFromStringData(String[] data) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        try {
            String dateFormat = String.format("%s/%s/%s", data[0].substring(6, 8), data[0].substring(4, 6), data[0].substring(0, 4));
            date = simpleDateFormat.parse(dateFormat);
        } catch (Exception e) {
            return null;
        }

        Boolean genre = null;

        if (data[7].equalsIgnoreCase("MASCULINO")) genre = true;
        else if (data[7].equalsIgnoreCase("FEMENINO")) genre = false;
        else return null;

        return new DengueCase(
                date,
                data[1],
                data[2],
                data[3],
                data[4],
                Integer.parseInt(data[5]),
                AgeType.valueOf(data[6]),
                data[7].equalsIgnoreCase("MASCULINO")
        );
    }

    // Devuelve un string con el formato de la edad.
    /**
     * Devuelve un string con el formato predeterminado de la edad
     * @return Cadena de texto con el formato predeterminado de la edad
     */
    public String getFormatAge() {
        return switch (this.ageType) {
            case A -> String.format("%d %s", age, "años");
            case M -> String.format("%d %s", age, "meses");
            case D -> String.format("%d %s", age, "días");
        };
    }

    // Devuelve un string con el formato de la edad, pero según se requiera.
    /**
     * Devuelve un string con el formato de la edad, pero según se requiera indicando un {@link AgeType}.
     * @param formatType Tipo de edad requerido para el formato.
     * @return Una cadena de texto con edad formateada.
     */
    public String getFormatAge(AgeType formatType) {
        return switch (formatType) {
            case A -> switch (this.ageType) {
                    case A -> String.format("%d %s", age, "años");
                    case M -> String.format("%d %s", age / 12, "años");
                    case D -> String.format("%d %s", age / 365, "años");
                };
            case M -> switch (this.ageType) {
                    case A -> String.format("%d %s", age * 12, "meses");
                    case M -> String.format("%d %s", age, "meses");
                    case D -> String.format("%d %s", age / 30, "meses");
                };
            case D -> switch (this.ageType) {
                    case A -> String.format("%d %s", age * 365, "días");
                    case M -> String.format("%d %s", age * 30, "días");
                    case D -> String.format("%d %s", age, "días");
                };
        };
    }
}
