/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.managerBean;

import br.com.santecorps.facade.CursoFacade;
import br.com.santecorps.facade.TurmaFacade;
import br.com.santecorps.facade.UnidadeFacade;
import br.com.santecorps.model.Curso;
import br.com.santecorps.model.Turma;
import br.com.santecorps.model.Unidade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Wolverine
 */

@Named
@RequestScoped
public class CadastroTurmasMB implements Serializable{
    
    private List<Turma> listaTurmas;
    private Turma turma;
    private String idCurso;
    private List<Curso> listaCursos;

    public CadastroTurmasMB() {
        this.listaTurmas = new ArrayList<Turma>();
        this.turma = new Turma();
        CursoFacade cursoFacade = new CursoFacade();
        listaCursos = cursoFacade.listar("");
        if (listaCursos==null){
            listaCursos = new ArrayList<Curso>();
        }
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public List<Turma> getListaTurmas() {
        listarTurmas();
        return listaTurmas;
    }

    public void setListaTurmas(List<Turma> listaTurmas) {
        this.listaTurmas = listaTurmas;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }


    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    public String novaTurma(){
        return "cadturmas";
    }
    
    public void listarTurmas(){
        TurmaFacade turmaFacade = new TurmaFacade();
        listaTurmas = turmaFacade.listar("");
        if (listaTurmas==null){
            listaTurmas = new ArrayList<Turma>();
        }
    }
    
    public String salvarTurma(){
        TurmaFacade turmaFacade = new TurmaFacade();
        CursoFacade cursoFacade = new CursoFacade();
        Curso curso = cursoFacade.getCurso(Integer.parseInt(idCurso));
        turma.setCurso(curso);
        UnidadeFacade unidadeFacade = new UnidadeFacade();
        Unidade unidade = unidadeFacade.getUnidade(1);
        turma.setUnidade(unidade);
        turmaFacade.salvar(turma);
        return "consturmas";
    }
    
    public String cancelar(){
        return "consturmas";
    }
    
}
