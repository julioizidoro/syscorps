/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.facade;

import br.com.santecorps.dao.AlunoDao;
import br.com.santecorps.model.Aluno;
import br.com.santecorps.model.Conjuge;
import br.com.santecorps.model.Localtrabalho;
import java.util.List;

/**
 *
 * @author Wolverine
 */
public class AlunoFacade {
    
    AlunoDao alunoDao;
    
    public Aluno salvar(Aluno aluno){
        alunoDao = new AlunoDao();
        return alunoDao.salvar(aluno);
    }
    
    public List<Aluno> listar(String nome){
        alunoDao = new AlunoDao();
        return alunoDao.listar(nome);
    }
    
    public Conjuge salvarConjuge(Conjuge conjuge){
        alunoDao = new AlunoDao();
        return alunoDao.salvarConjuge(conjuge);
    }
    
    public Localtrabalho salvarLocalTrabalho(Localtrabalho localtrabalho){
        alunoDao = new AlunoDao();
        return alunoDao.salvarLocalTrabalho(localtrabalho);
    }
    
    public Aluno getAlunoId(int idAluno){
        alunoDao = new AlunoDao();
        return alunoDao.getAlunoId(idAluno);
    }
    
    public Conjuge getConjugeId(int idConjuge){
        alunoDao = new AlunoDao();
        return alunoDao.getConjugeId(idConjuge);
    }
    
    public Localtrabalho getLocalTrabalhoId(int idLocaltrabalho){
        alunoDao = new AlunoDao();
        return alunoDao.getLocalTrabalhoId(idLocaltrabalho);
    }
    
}
