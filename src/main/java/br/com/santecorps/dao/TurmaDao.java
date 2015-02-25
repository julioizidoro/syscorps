/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.dao;

import br.com.santecorps.connection.ConectionFactory;
import br.com.santecorps.model.Turma;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Wolverine
 */
public class TurmaDao {
    
    public void salvar(Turma turma){
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        manager.merge(turma);
        manager.getTransaction().commit();
    }
    
    public List<Turma> listar(String numero){
        EntityManager manager =ConectionFactory.getConnection();
        Query q = manager.createQuery("select t from Turma t where t.numero like '%" + numero + "%' order by t.numero" );
        List<Turma> listaTurma = q.getResultList();
        return listaTurma;
    }
    
}
