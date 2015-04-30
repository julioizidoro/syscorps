/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.facade;

import br.com.santecorps.dao.MatriculaDao;
import br.com.santecorps.model.Matricula;

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
    
}
