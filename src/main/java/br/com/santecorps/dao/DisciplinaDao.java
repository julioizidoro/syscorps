/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.dao;

import br.com.santecorps.connection.ConectionFactory;
import br.com.santecorps.model.Disciplina;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Wolverine
 */
public class DisciplinaDao {
    
    public void salvar(Disciplina disciplina){
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        manager.merge(disciplina);
        manager.getTransaction().commit();
    }
    
    public List<Disciplina> listar(String nome){
        EntityManager manager =ConectionFactory.getConnection();
        manager.getTransaction().begin();
        Query q = manager.createQuery("select d from Disciplina d where d.nome like '%" + nome + "%' order by d.nome" );
        List<Disciplina> listaDisciplina = q.getResultList();
        return listaDisciplina;
    }

    public Disciplina getDisciplinaId(int idDisciplina) {
         EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        Disciplina disciplina = manager.find(Disciplina.class, idDisciplina);
        manager.getTransaction().commit();
        return disciplina;
    }
    
}
