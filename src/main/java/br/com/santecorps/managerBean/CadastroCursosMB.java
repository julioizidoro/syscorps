/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.managerBean;

import br.com.santecorps.model.Curso;
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
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }
    
    
    
    public String novoCurso(){
        return "cadcursos";
    }
    
}
