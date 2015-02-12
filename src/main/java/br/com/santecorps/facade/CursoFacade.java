/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.facade;

import br.com.santecorps.dao.CursoDao;
import br.com.santecorps.model.Curso;
import java.util.List;

/**
 *
 * @author Wolverine
 */
public class CursoFacade {
    
    CursoDao cursoDao;
    
    public void salvar(Curso curso){
        cursoDao = new CursoDao();
        cursoDao.salvar(curso);
    }
    
    public List<Curso> listar(String nome){
        cursoDao = new CursoDao();
        return cursoDao.listar(nome);
    }
    
    public Curso getCurso(int idCurso){
        cursoDao = new CursoDao();
        return cursoDao.getCurso(idCurso);
    }
    
}
