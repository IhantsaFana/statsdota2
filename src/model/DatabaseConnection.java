package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/dota2";
    private static final String USER = "oeka";
    private static final String PASSWORD = "OekaMikofo@123";
    private static Connection connection = null;

    private DatabaseConnection() {} // Empêche l'instanciation

    public static Connection connect() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                System.out.println("❌ Erreur de connexion !");
            }
        }
        return connection;
    }
}
