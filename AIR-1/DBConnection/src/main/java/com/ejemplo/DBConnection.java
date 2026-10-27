package com.ejemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // URL JDBC con el puerto correcto
    private static final String URL = "jdbc:postgresql://localhost:5433/MasterAnnonce";
    
    // Usuario y contraseña que funcionan en tu base
    private static final String USER = "postgres";          // tu usuario real
    private static final String PASSWORD = "123"; // tu contraseña real

    // Método que devuelve la conexión
    public static Connection getConnection() throws SQLException {
        try {
            // Forzar carga del driver PostgreSQL
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL driver not found");
            e.printStackTrace();
        }

        // Retorna la conexión
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
