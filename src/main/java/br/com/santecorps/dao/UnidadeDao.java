/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.dao;

import br.com.santecorps.connection.ConectionFactory;
import br.com.santecorps.model.Curso;
import br.com.santecorps.model.Unidade;
import javax.persistence.EntityManager;

/**
 *
 * @author Wolverine
 */
public class UnidadeDao {
    
    public Unidade getUnidade(int idUnidade){
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        Unidade unidade = manager.find(Unidade.class, idUnidade);
        manager.getTransaction().commit();
        manager.close();
        return unidade;
    }
    
}
