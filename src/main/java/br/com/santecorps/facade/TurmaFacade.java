/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.facade;

import br.com.santecorps.dao.TurmaDao;
import br.com.santecorps.model.Turma;
import java.util.List;

/**
 *
 * @author Wolverine
 */
public class TurmaFacade {
    
    TurmaDao turmaDao;
    
    public void salvar(Turma turma){
        turmaDao = new TurmaDao();
        turmaDao.salvar(turma);
    }
    
    public List<Turma> listar(String numero, int idUnidade){
        turmaDao = new TurmaDao();
        return turmaDao.listar(numero, idUnidade);
    }
    
    public List<Turma> listar(int idCurso, int idUnidade){
        turmaDao = new TurmaDao();
        return turmaDao.listar(idCurso, idUnidade);
    }

    public Turma getTurmaId(int idTurma) {
        turmaDao = new TurmaDao();
        return turmaDao.getTurmaId(idTurma);
    }
}
