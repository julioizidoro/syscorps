/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.facade;

import br.com.santecorps.dao.MatriculaDao;
import br.com.santecorps.model.Matricula;
import java.util.List;

/**
 *
 * @author Wolverine
 */
public class MatriculaFacade {
    
    MatriculaDao matriculaDao;
    
    public void salvar(Matricula matricula){
        matriculaDao = new MatriculaDao();
        matriculaDao.salvar(matricula);
    }
    
    public List<Matricula> listar(int idTurma){
        matriculaDao = new MatriculaDao();
        return matriculaDao.listar(idTurma);
    }
    
    public Matricula getMatricula(int idMatricula){
        matriculaDao = new MatriculaDao();
        return matriculaDao.getMatricula(idMatricula);
    }
    
}
