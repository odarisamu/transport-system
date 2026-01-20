package com.projects.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
    private static String URL = "jdbc:mysql://localhost:3306/transportsystem";
    private static String USER = "root";
    private static String PASSWORD = "";

    public Connection getConnection( ) throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
