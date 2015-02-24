/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.dao;

import br.com.santecorps.connection.ConectionFactory;
import br.com.santecorps.model.Aluno;
import static br.com.santecorps.model.Conjuge_.aluno;
import br.com.santecorps.model.Professor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Wolverine
 */
public class ProfessorDao {
    
    public void salvar(Professor professor){
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        manager.merge(professor);
        manager.getTransaction().commit();
    }
    
    public List<Professor> listar(String nome){
        EntityManager manager =ConectionFactory.getConnection();
        manager.getTransaction().begin();
        Query q = manager.createQuery("select p from Professor p where p.nome like '%" + nome + "%' order by p.nome" );
        List<Professor> listaProfessor = q.getResultList();
        return listaProfessor;
    }
    
}
