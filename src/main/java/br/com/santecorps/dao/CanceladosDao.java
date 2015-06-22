/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.dao;

import br.com.santecorps.connection.ConectionFactory;
import br.com.santecorps.model.Cancelados;

import javax.persistence.EntityManager;

/**
 *
 * @author Wolverine
 */
public class CanceladosDao {
    
    public Cancelados salvar(Cancelados cancelados) {
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        cancelados = manager.merge(cancelados);
        manager.getTransaction().commit();
        return cancelados;
    }
}
