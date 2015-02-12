/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.facade;

import br.com.santecorps.dao.UnidadeDao;
import br.com.santecorps.model.Unidade;

/**
 *
 * @author Wolverine
 */
public class UnidadeFacade {
    
    UnidadeDao unidadeDao;
    
    
    public Unidade getUnidade(int idUnidade){
        unidadeDao = new UnidadeDao();
        return unidadeDao.getUnidade(idUnidade);
    }
    
}
