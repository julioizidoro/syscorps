/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.managerBean;

import br.com.santecorps.facade.DisciplinaFacade;
import br.com.santecorps.model.Disciplina;
/*import com.sun.javafx.scene.control.skin.VirtualFlow;*/
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Wolverine
 */

@Named
@RequestScoped
public class CadastroDisciplinaMB implements Serializable{
    
    private Disciplina disciplina;
    private List<Disciplina> listaDisciplina;

    public CadastroDisciplinaMB() {
        if (disciplina==null){
            disciplina = new Disciplina();
        }
        if (listaDisciplina==null){
            gerarListaDisciplina("");
        }
        
    }
    
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Disciplina> getListaDisciplina() {
        return listaDisciplina;
    }

    public void setListaDisciplina(List<Disciplina> listaDisciplina) {
        this.listaDisciplina = listaDisciplina;
    }
    
    public void gerarListaDisciplina(String nome){
        DisciplinaFacade disciplinaFacade = new DisciplinaFacade();
        listaDisciplina = disciplinaFacade.listar(nome);
        if (listaDisciplina==null){
            listaDisciplina = new ArrayList<Disciplina>();
        }
    }
    
    public String nova(){
        return "caddisciplina";
    }
    
    public String cancelar(){
        return "consdisciplina";
    }
    
    public String salvar(){
        DisciplinaFacade disciplinaFacade = new DisciplinaFacade();
        disciplinaFacade.salvar(disciplina);
        gerarListaDisciplina("");
        return "consdisciplina";
    }
    
    
    
    
    
}
