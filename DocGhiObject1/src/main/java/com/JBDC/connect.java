/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JBDC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erik
 */
public class connect {
    public static Connection getJBDCConnection() throws SQLException{
        final String url = "jbdc:mysql://127.0.0.1:3306/JDB";
        final String user = "root";
        final String password = "";
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            return DriverManager.getConnection(url,user,password);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args) throws SQLException {
        
        connect newConnect = new connect();
        
        if(newConnect.getJBDCConnection()!=null){
            
        }
    }
}
