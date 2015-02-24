/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.facade;

import br.com.santecorps.dao.ProfessorDao;
import br.com.santecorps.model.Professor;
import java.util.List;

/**
 *
 * @author Wolverine
 */
public class ProfessorFacade {
    
    ProfessorDao professorDao;
    
    public void salvar(Professor professor){
        professorDao = new ProfessorDao();
        professorDao.salvar(professor);
    }
    
    public List<Professor> listar(String nome){
        professorDao = new ProfessorDao();
        return professorDao.listar(nome);
    }
    
}
