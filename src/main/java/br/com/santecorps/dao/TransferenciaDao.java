/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.dao;

import br.com.santecorps.connection.ConectionFactory;
import br.com.santecorps.model.Transferencia;
import javax.persistence.EntityManager;

/**
 *
 * @author Wolverine
 */
public class TransferenciaDao {
    
    public Transferencia salvar(Transferencia transferencia) {
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        transferencia = manager.merge(transferencia);
        manager.getTransaction().commit();
        return transferencia;
    }
    
}
