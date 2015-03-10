/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.managerBean;

import br.com.santecorps.facade.ProfessorFacade;
import br.com.santecorps.facade.UnidadeFacade;
import br.com.santecorps.model.Professor;
import br.com.santecorps.model.Unidade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Wolverine
 */

@Named
@SessionScoped
public class CadastroProfessorMB implements Serializable{
    
    
    private Professor professor;
    private List<Professor> listaProfessor;

    public CadastroProfessorMB() {
            professor = new Professor();
            listaProfessor();
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Professor> getListaProfessor() {
        return listaProfessor;
    }

    public void setListaProfessor(List<Professor> listaProfessor) {
        this.listaProfessor = listaProfessor;
    }
    
    public void listaProfessor(){
        ProfessorFacade professorFacade = new ProfessorFacade();
        listaProfessor = professorFacade.listar("");
        if (listaProfessor==null){
            listaProfessor = new ArrayList<Professor>();
        }
    }
    
    public String novoProfessor(){
        professor = new Professor();
        return "cadprofessor";
    }
    
    public String cancelar(){
        return "consprofessor";
    }
    
    public String salvar(){
        UnidadeFacade unidadeFacade = new UnidadeFacade();
        Unidade unidade = unidadeFacade.getUnidade(1);
        professor.setUnidade(unidade);
        ProfessorFacade professorFacade = new ProfessorFacade();
        professorFacade.salvar(professor);
        listaProfessor();
        return "consprofessor";
    }
    
      public String consultarProfessor(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        int idProfessor=  Integer.parseInt(params.get("id_professor"));
        if (idProfessor>0){
            ProfessorFacade professorFacade = new ProfessorFacade();
            professor = professorFacade.getProfessorId(idProfessor);
            if (professor!=null){
                return "cadprofessor";
            }
        }
        return null;
    }
    
}
