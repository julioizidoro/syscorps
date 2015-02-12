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
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Wolverine
 */

@Named
@RequestScoped
public class CadastroCursosMB implements Serializable{
    
    private Curso curso;
    private List<Curso> listaCursos;

    public CadastroCursosMB() {
        this.listaCursos = new ArrayList<Curso>();
        this.curso = new Curso();
                ;
    }

    public Curso getCurso() {
        return curso;
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
        return "cadcursos";
    }
    
    public String salvarCurso(){
        CursoFacade cursoFacade = new CursoFacade();
        cursoFacade.salvar(curso);
        return "conscursos";
    }
    
    public String cancelar(){
        return "conscursos";
    }
    
    public void listarCursos(){
        CursoFacade cursoFacade = new CursoFacade();
        listaCursos = cursoFacade.listar("");
        if (listaCursos==null){
            listaCursos = new ArrayList<Curso>();
        }
    }
    
}
