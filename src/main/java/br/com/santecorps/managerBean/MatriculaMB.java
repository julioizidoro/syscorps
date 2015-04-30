/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.managerBean;

import br.com.santecorps.facade.CursoFacade;
import br.com.santecorps.facade.MatriculaFacade;
import br.com.santecorps.facade.TurmaFacade;
import br.com.santecorps.model.Aluno;
import br.com.santecorps.model.Curso;
import br.com.santecorps.model.Matricula;
import br.com.santecorps.model.Turma;
import br.com.santecorps.util.Formatacao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Wolverine
 */

@Named
@SessionScoped
public class MatriculaMB implements Serializable{
    
    @Inject
    private CadastroAlunoMB cadastroAlunoMB;
    private Matricula matricula;
    private List<Curso> listaCursos;
    private List<Turma> listaTurma;
    private String idCurso;
    private String idTurma;
    private String valorTotal;
    private String valorEntrada;
    private String valorParcela;
    private String numeroParcelas;
    private Turma turma;
    

    public MatriculaMB() {
        matricula = new Matricula();
        matricula.setAluno(new Aluno());
        gerarLitaCurso();
    }
    
    
    public String nova(){
        return "matricula";
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public CadastroAlunoMB getCadastroAlunoMB() {
        return cadastroAlunoMB;
    }

    public void setCadastroAlunoMB(CadastroAlunoMB cadastroAlunoMB) {
        this.cadastroAlunoMB = cadastroAlunoMB;
    }

    public String getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(String idTurma) {
        this.idTurma = idTurma;
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

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
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
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
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
    
    
    
    public void gerarListaTurma() {
        if (idCurso != null) {
            TurmaFacade turmaFacade = new TurmaFacade();
            listaTurma = turmaFacade.listar(Integer.parseInt(idCurso), 1);
            if (listaTurma == null) {
                listaTurma = new ArrayList<Turma>();
            }
        }
    }
    
    public String voltar(){
        return "matricula";
    }
     
     public String selecionarAluno(){
         cadastroAlunoMB.setPaginaRetorno("matricula");
         return "selecionarAluno";
    }
     
     public String salvar(){
         MatriculaFacade matriculaFacade = new MatriculaFacade();
         TurmaFacade turmaFacade = new TurmaFacade();
         CursoFacade cursoFacade = new CursoFacade();
         matricula.setAluno(cadastroAlunoMB.getAluno());
         matricula.setNumeroparcelas(Integer.parseInt(numeroParcelas));
         matricula.setTurma(turmaFacade.getTurmaId(Integer.parseInt(idTurma)));
         matricula.setValorentrada(Formatacao.formatarStringfloat(valorEntrada));
         matricula.setValorparcela(Formatacao.formatarStringfloat(valorParcela));
         matricula.setValortotal(Formatacao.formatarStringfloat(valorTotal));
         matriculaFacade.salvar(matricula);
         return "inicial";
     }
     
     public String cancelar(){
         return "inicial";
     }
     
     public void selecoinarTurma(){
         if (idTurma!=null){
             TurmaFacade turmaFacade = new TurmaFacade();
             turma = turmaFacade.getTurmaId(Integer.parseInt(idTurma));
         }
     }
}
