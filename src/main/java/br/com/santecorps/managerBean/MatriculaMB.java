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
public class MatriculaMB implements Serializable{
    
    private Matricula matricula;
    private List<Curso> listaCursos;
    private List<Aluno> listaAlunos;
    private List<Turma> listaTurma;
    private String idCurso;
    
    private String valorTotal;
    private String valorEntrada;
    private String valorParcela;
    private String numeroParcelas;
    

    public MatriculaMB() {
        matricula = new Matricula();
        matricula.setAluno(new Aluno());
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

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(String valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public String getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(String valorParcela) {
        this.valorParcela = valorParcela;
    }

    public String getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(String numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public List<Curso> getListaCursos() {
        if (listaCursos==null){
            gerarLitaCurso();
        }
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public List<Aluno> getListaAlunos() {
        if (listaAlunos==null){
            gerarListaAlunos();
        }
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public List<Turma> getListaTurma() {
        if (listaTurma==null){
            gerarListaTurma();
        }
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
    
    public void selecionarAluno(){
        if (listaAlunos!=null){
            for(int i=0;i<listaAlunos.size();i++){
                if (listaAlunos.get(i).isSelecionado()){
                    matricula.setAluno(listaAlunos.get(i));
                    i=500000;
                }
            }
        }
    }
}
