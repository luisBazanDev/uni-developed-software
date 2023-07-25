package pe.edu.utp.provider.domain;

/**
 * Esta clase es unicamente para almacenar el usuario actual
 * @author Luis Bazan
 */
public class UserProvider {
    // Atributo del usuario
    private static String username = null;

    // Setter del usuario
    /**
     * Setter para el usuario actual
     * @param username
     */
    public static void setUsername(String username) {
        UserProvider.username = username;
    }

    // Getter del usuario
    /**
     * Getter para obtener el usuario actual en sesión
     * @return Retorna el usuario actual
     */
    public static String getUsername() {
        return username;
    }
}
