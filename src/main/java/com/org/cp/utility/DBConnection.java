package com.org.cp.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection con;

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/PlacementPortal",
                    "root",
                    "arthi@9908");

        }
        catch(Exception e) {

            System.out.println(
                    "Database Connection Failed : "
                    + e.getMessage());
        }

        return con;
    }
}
