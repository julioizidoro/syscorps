/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.managerBean;

import br.com.santecorps.facade.AlunoFacade;
import br.com.santecorps.model.Aluno;
import br.com.santecorps.model.Avalista;
import br.com.santecorps.model.Conjuge;
import br.com.santecorps.model.Localtrabalho;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Wolverine
 */

@Named
@ViewScoped
public class CadastroAlunoMB implements Serializable{
    
    private List<Aluno> listaAlunos;
    private Aluno aluno;
    private Conjuge conjuge;
    private Avalista avalista;
    private Localtrabalho localTrabalho;
    private String nomeAluno;

    public CadastroAlunoMB() {
        this.listaAlunos = new ArrayList<Aluno>();
        this.aluno = new Aluno();
        this.conjuge = new Conjuge();
        this.avalista = new Avalista();
        this.localTrabalho = new Localtrabalho();
    }
    

    
    
    public List<Aluno> getListaAlunos() {
        CarregarLitaAluno();
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Conjuge getConjuge() {
        return conjuge;
    }

    public void setConjuge(Conjuge conjuge) {
        this.conjuge = conjuge;
    }

    public Avalista getAvalista() {
        return avalista;
    }

    public void setAvalista(Avalista avalista) {
        this.avalista = avalista;
    }

    public Localtrabalho getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(Localtrabalho localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
    
    
    public void CarregarLitaAluno(){
        AlunoFacade alunoFacade = new AlunoFacade();
        listaAlunos = alunoFacade.listar(nomeAluno);
        if (listaAlunos==null){
            listaAlunos = new ArrayList<Aluno>();
        }
    }
    
    public String novoAluno(){
        return "cadaluno";
    }
    
    public String salvarAluno(){
        return "consaluno";
    }
    
}
