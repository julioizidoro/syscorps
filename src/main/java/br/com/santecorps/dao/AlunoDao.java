/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.dao;

import br.com.santecorps.connection.ConectionFactory;
import br.com.santecorps.model.Aluno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Wolverine
 */
public class AlunoDao {
    
    

    public AlunoDao() {
        
    }
    
    public void salvar(Aluno aluno){
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        manager.merge(aluno);
        manager.getTransaction().commit();
    }
    
    public List<Aluno> listar(String nome){
        EntityManager manager =ConectionFactory.getConnection();
        manager.getTransaction().begin();
        Query q = manager.createQuery("select a from Aluno a where a.nome like '%" + nome + "%' order by a.nome" );
        List<Aluno> listaAlunos = q.getResultList();
        return listaAlunos;
    }
}
