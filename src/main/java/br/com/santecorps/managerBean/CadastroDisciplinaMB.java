/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.managerBean;

import br.com.santecorps.facade.DisciplinaFacade;
import br.com.santecorps.model.Disciplina;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Wolverine
 */

@Named
@SessionScoped
public class CadastroDisciplinaMB implements Serializable{
    
    private Disciplina disciplina;
    private List<Disciplina> listaDisciplina;

    public CadastroDisciplinaMB() {
        
            disciplina = new Disciplina();
            gerarListaDisciplina("");
        
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
    
    public String consultarDisciplina(){
         FacesContext fc = FacesContext.getCurrentInstance();
         Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        int idDisciplina =  Integer.parseInt(params.get("id_disciplina"));
        if (idDisciplina>0){
           DisciplinaFacade disciplinaFacade = new DisciplinaFacade();
            disciplina = disciplinaFacade.getDisciplinaId(idDisciplina);
            if (disciplina!=null){
                return "caddisciplina";
            }
        }
        return null;
    }
    
    
    
}
