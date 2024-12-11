package com.akash.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
    public static Connection sqlConnection;
    public static Connection getSqlConnection(){
        if (sqlConnection == null){
            String url = "jdbc:mysql://localhost:3306/lift";
            String userName = "root";
            String password = "akash2002";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url,userName,password);
                System.out.println("Connected");
            }catch (Exception e){

            }
        }
        return sqlConnection;
    }
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
