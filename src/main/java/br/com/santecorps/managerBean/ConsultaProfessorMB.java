/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.managerBean;

import br.com.santecorps.facade.ProfessorFacade;
import br.com.santecorps.model.Professor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Wolverine
 */
@Named
@RequestScoped
public class ConsultaProfessorMB implements Serializable{
    
    private List<Professor> listaProfessor;

    public ConsultaProfessorMB() {
        if (listaProfessor==null){
            gerarListaProfessor();
        }
    }

    public List<Professor> getListaProfessor() {
        if (listaProfessor==null){
            gerarListaProfessor();
        }
        return listaProfessor;
    }

    public void setListaProfessor(List<Professor> listaProfessor) {
        this.listaProfessor = listaProfessor;
    }
    
    public void gerarListaProfessor(){
        ProfessorFacade professorFacade = new ProfessorFacade();
        listaProfessor = professorFacade.listar("");
        if (listaProfessor==null){
            listaProfessor = new ArrayList<Professor>();
        }
    }
    
    public String novoProfessor(){
        return "cadprofessor";
    }
    
    
    
}
