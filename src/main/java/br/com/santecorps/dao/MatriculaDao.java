/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.dao;

import br.com.santecorps.connection.ConectionFactory;
import br.com.santecorps.model.Matricula;
import javax.persistence.EntityManager;

/**
 *
 * @author Wolverine
 */
public class MatriculaDao {
    
    public void salvar(Matricula matricula){
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        manager.merge(matricula);
        manager.getTransaction().commit();
    }
    
}
