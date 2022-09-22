package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/Jukebox_Project";
        Connection connection = DriverManager.getConnection(url, "root", "Po@420srk");

        if(connection != null){

            // System.out.println("CONNECTED TO DATABASE SUCCESSFULLY");

        }
        return connection;
    }
}
