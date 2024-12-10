package com.akash.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
    public static Connection getConnection(){
        if (connection == null){
            try {
                Class.forName("org.postgresql.Driver");
            }catch (Exception e){
                e.printStackTrace();
            }
            String userName = "postgres";
            String password = "root";
            String url = "jdbc:postgresql://localhost:5432/lift";
            try {
                connection = DriverManager.getConnection(url,userName,password);
                System.out.println("Connected Successfully");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
