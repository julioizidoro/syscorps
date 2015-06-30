/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.santecorps.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Wolverine
 */
public class ConectionFactory {

    private static EntityManager manager;
    private static Connection conn;


    public static EntityManager getConnection() {
        EntityManagerFactory emf = null;
        manager = null;
        emf = Persistence.createEntityManagerFactory("syscorpsPU");
        manager = emf.createEntityManager();
        if (!manager.isOpen()) {
            JOptionPane.showMessageDialog(null, "Conexão fechada");
        }
        return manager;
    }
    public static Connection getConexao(){
       
//        if (conn!=null){
//            try {
//                conn.close();
//                conn=null;
//            } catch (SQLException ex) {
//                Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        if (conn==null){
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            String driverName = "com.mysql.jdbc.Driver";
//            String serverName = "186.215.116.63";
//            String mydatabase ="syscorps";
//            String url = "jdbc:mysql://" + serverName + ":8081/" + mydatabase;
//            String username = "root";
//            String password = "simples";
//            try {
//                conn = DriverManager.getConnection(url, username, password);
//            } catch (SQLException ex) {
//                Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        return conn;
        
    }
}
