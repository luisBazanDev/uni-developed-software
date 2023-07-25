package pe.edu.utp.provider.domain;

/**
 * Clase para almacenar los datos de usuario para iniciar sesion
 * @author Luis Bazan
 */
public class UserData {
    // Atributos de la clase
    final private String username;
    final private String password;

    // Constructor para la clase
    /**
     * Constructor principal de la clase para almacenar
     * @param username
     * @param password
     */
    public UserData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Metodo para comparar el usuario y contraseña interno de la clase
    // con los datos de los parametros

    /**
     * Método para comparar usuario o contraseña
     * @param username
     * @param password
     * @return
     */
    public boolean compareUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
