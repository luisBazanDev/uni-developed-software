package pe.edu.utp.dwi.s01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseDictionary {
    private final String uri = "jdbc:mysql://localhost:3306/S01";

    public static void main(String[] args) {
        new DatabaseDictionary();
    }

    public DatabaseDictionary() {
        executeQuery("SELECT * FROM dictionary");
    }

    private void executeQuery(String query) {
        Connection con = getConnection();

        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(uri, "root", "password");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
