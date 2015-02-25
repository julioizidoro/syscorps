/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.facade;

import br.com.santecorps.dao.DisciplinaDao;
import br.com.santecorps.model.Disciplina;
import java.util.List;

/**
 *
 * @author Wolverine
 */
public class DisciplinaFacade {
    
    DisciplinaDao disciplinaDao;
    
    public void salvar(Disciplina disciplina){
        disciplinaDao = new DisciplinaDao();
        disciplinaDao.salvar(disciplina);
    }
    
    public List<Disciplina> listar(String nome){
        disciplinaDao = new DisciplinaDao();
        return disciplinaDao.listar(nome);
    }
    
}
