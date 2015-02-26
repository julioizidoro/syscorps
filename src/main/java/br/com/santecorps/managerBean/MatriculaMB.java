/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.managerBean;

import br.com.santecorps.facade.AlunoFacade;
import br.com.santecorps.facade.CursoFacade;
import br.com.santecorps.facade.TurmaFacade;
import br.com.santecorps.model.Aluno;
import br.com.santecorps.model.Curso;
import br.com.santecorps.model.Matricula;
import br.com.santecorps.model.Turma;
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
public class MatriculaMB implements Serializable{
    
    private Matricula matricula;
    private List<Curso> listaCursos;
    private List<Aluno> listaAlunos;
    private List<Turma> listaTurma;
    private String idCurso;

    public MatriculaMB() {
    }
    
    
    public String nova(){
        return "matricula";
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public List<Turma> getListaTurma() {
        return listaTurma;
    }

    public void setListaTurma(List<Turma> listaTurma) {
        this.listaTurma = listaTurma;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }
    
    public void gerarLitaCurso(){
        CursoFacade cursoFacade = new CursoFacade();
        listaCursos = cursoFacade.listar("");
        if (listaCursos==null){
            listaCursos = new ArrayList<Curso>();
        }
    }
    
    public void gerarListaAlunos(){
        AlunoFacade alunoFacade = new AlunoFacade();
        listaAlunos = alunoFacade.listar("");
        if (listaAlunos==null){
            listaAlunos = new ArrayList<Aluno>();
        }
    }
    
    public void gerarListaTurma(){
        TurmaFacade turmaFacade = new TurmaFacade();
        listaTurma = turmaFacade.listar(Integer.parseInt(idCurso), 1);
        if (listaTurma==null){
            listaTurma = new ArrayList<Turma>();
        }
    }
}
