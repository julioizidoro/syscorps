/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.facade;

import br.com.santecorps.dao.TransferenciaDao;
import br.com.santecorps.model.Transferencia;

/**
 *
 * @author Wolverine
 */
public class TransferenciaFacade {
    
    TransferenciaDao transferenciaDao;
    
    public Transferencia salvar(Transferencia transferencia) {
        transferenciaDao = new TransferenciaDao();
        return transferenciaDao.salvar(transferencia);
    }
    
}
