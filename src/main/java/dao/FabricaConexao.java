/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author acere
 */
public class FabricaConexao {
    private final static String url = "jdbc:mysql://localhost:3306/sempreemformatunado";
    //private final static String url = "jdbc:mysql://localhost:3306/sempreemforma";
    private final static String name = "root";
    private final static String pass = "acererak";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, name, pass);  
    }
}
