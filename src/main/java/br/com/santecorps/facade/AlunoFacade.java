/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.facade;

import br.com.santecorps.dao.AlunoDao;
import br.com.santecorps.model.Aluno;
import java.util.List;

/**
 *
 * @author Wolverine
 */
public class AlunoFacade {
    
    AlunoDao alunoDao;
    
    public void salvar(Aluno aluno){
        alunoDao = new AlunoDao();
        alunoDao.salvar(aluno);
    }
    
    public List<Aluno> listar(String nome){
        alunoDao = new AlunoDao();
        return alunoDao.listar(nome);
    }
    
}
