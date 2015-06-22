/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.facade;

import br.com.santecorps.dao.CanceladosDao;
import br.com.santecorps.model.Cancelados;

/**
 *
 * @author Wolverine
 */
public class CanceladosFacade {
    
    CanceladosDao canceladosDao;
    
    public Cancelados salvar(Cancelados cancelados) {
        canceladosDao = new CanceladosDao();
        return canceladosDao.salvar(cancelados);
    }
    
}
