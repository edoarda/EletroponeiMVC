/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edoarda
 */
public class Conector {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:derby://localhost:1527/Eletroponei", "adm", "adm");
            
        } catch (SQLException e) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return null;
    }
}