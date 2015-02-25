/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.dao;

import br.com.santecorps.connection.ConectionFactory;
import br.com.santecorps.model.Curso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Wolverine
 */
public class CursoDao {
    
    public void salvar(Curso curso){
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        manager.merge(curso);
        manager.getTransaction().commit();
    }
    
    public List<Curso> listar(String nome){
        EntityManager manager =ConectionFactory.getConnection();
        Query q = manager.createQuery("select c from Curso c where c.nome like '%" + nome + "%' order by c.nome" );
        List<Curso> listaCursos = q.getResultList();
        return listaCursos;
    }
    
    public Curso getCurso(int idCurso){
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        Curso curso = manager.find(Curso.class, idCurso);
        manager.getTransaction().commit();
        return curso;
    }
    
}
