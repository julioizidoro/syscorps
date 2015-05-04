/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.dao;

import br.com.santecorps.connection.ConectionFactory;
import br.com.santecorps.model.Aluno;
import br.com.santecorps.model.Matricula;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
    
    public List<Matricula> listar(int idTurma){
        EntityManager manager =ConectionFactory.getConnection();
        manager.getTransaction().begin();
        Query q = manager.createQuery("select m from Matricula m where m.turma.idturma=" + idTurma + " order by m.aluno.nome");
        List<Matricula> listaMatriculas = q.getResultList();
        manager.getTransaction().commit();
        return listaMatriculas;
    }
    
    public Matricula getMatricula(int idMatricula){
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        Matricula matricula = manager.find(Matricula.class, idMatricula);
        manager.getTransaction().commit();
        return matricula;
    }
    
    public List<Matricula> listar(int idTurma, int mes){
        EntityManager manager =ConectionFactory.getConnection();
        manager.getTransaction().begin();
        Query q = manager.createQuery("select m from Matricula m where m.turma.idturma=" + idTurma + " and m.aluno.mes=" + mes + " order by m.aluno.nome");
        List<Matricula> listaMatriculas = q.getResultList();
        manager.getTransaction().commit();
        return listaMatriculas;
    }
    
}
