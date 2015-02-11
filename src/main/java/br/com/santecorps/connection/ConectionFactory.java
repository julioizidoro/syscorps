/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.santecorps.connection;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Wolverine
 */
public class ConectionFactory {
    
    
    public static EntityManager getConnection() {
        EntityManagerFactory emf = null;
        EntityManager manager = null;
        emf = Persistence.createEntityManagerFactory("syscorpsPU");
        manager = emf.createEntityManager();
        if (!manager.isOpen()){
            JOptionPane.showMessageDialog(null, "Conexão fechada");
        }else System.out.println("Conexão Ok");
        return manager;
    }
}
