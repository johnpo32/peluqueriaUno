/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.peluqueria;

/**
 *
 * @author john
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/mydb";
            String usuario = "root";
            String contrasena = "secret";
            return DriverManager.getConnection(url, usuario, contrasena);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

