/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.managerBean;

import br.com.santecorps.facade.CursoFacade;
import br.com.santecorps.model.Curso;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Wolverine
 */

@Named
@SessionScoped
public class CadastroCursosMB implements Serializable{
    
    
    private Curso curso;
    private List<Curso> listaCursos;
    private String mensagem;
    
    

    public CadastroCursosMB() {
        this.listaCursos = new ArrayList<Curso>();
        this.curso = new Curso();
    }

    public Curso getCurso() {
        return curso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

   

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getListaCursos() {
        listarCursos();
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }
    
    public String novoCurso(){
        this.curso = new Curso();
        return "cadcursos";
    }
    
    public String salvarCurso(){
        if (curso==null){
            new Curso();
        }
        CursoFacade cursoFacade = new CursoFacade();
        cursoFacade.salvar(curso);
        this.mensagem = "Curso Salvo com Sucesso";
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso",  mensagem) );
        listarCursos();
        return "conscursos";
    }
    
    public String cancelar(){
        this.mensagem = "Cadastro Cancelado";
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cancelado",  mensagem) );
        return "conscursos";
    }
    
    public void listarCursos(){
        CursoFacade cursoFacade = new CursoFacade();
        listaCursos = cursoFacade.listar("");
        if (listaCursos==null){
            listaCursos = new ArrayList<Curso>();
        }
    }
    
    public String consultarCurso(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        int idCurso =  Integer.parseInt(params.get("id_curso"));
        if (idCurso>0){
            CursoFacade cursoFacade = new CursoFacade();
            curso = cursoFacade.getCurso(idCurso);
            if (curso!=null){
                return "cadcursos";
            }
        }
        return null;
    }
    
    
}
