/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.managerBean;

import br.com.santecorps.model.Turma;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Wolverine
 */

@Named
@ViewScoped
public class CadastroTurmasMB implements Serializable{
    
    private List<Turma> listaTurmas;
    private Turma turma;

    public CadastroTurmasMB() {
        this.listaTurmas = new ArrayList<Turma>();
        this.turma = new Turma();
    }
    
    
    
    public String novaTurma(){
        return "cadturmas";
    }
    
}
