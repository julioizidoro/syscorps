/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.managerBean;

import br.com.santecorps.facade.AlunoFacade;
import br.com.santecorps.facade.UnidadeFacade;
import br.com.santecorps.model.Aluno;
import br.com.santecorps.model.Avalista;
import br.com.santecorps.model.Avalistaaluno;
import br.com.santecorps.model.Conjuge;
import br.com.santecorps.model.Localtrabalho;
import br.com.santecorps.model.Unidade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Wolverine
 */

@Named
@RequestScoped
public class CadastroAlunoMB implements Serializable{
    
    private List<Aluno> listaAlunos;
    private Aluno aluno;
    private Conjuge conjuge;
    private Avalista avalista;
    private Localtrabalho localTrabalho;
    private String nomeAluno;

    public CadastroAlunoMB() {
        this.listaAlunos = new ArrayList<Aluno>();
        aluno = new Aluno();
        conjuge = new Conjuge();
        avalista = new Avalista();
        localTrabalho = new Localtrabalho();
    }
    

    
    
    public List<Aluno> getListaAlunos() {
        if (listaAlunos==null){
            CarregarLitaAluno();
        }
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
        AlunoFacade alunoFacade = new AlunoFacade();
        UnidadeFacade unidadeFacade = new UnidadeFacade();
        Unidade unidade = unidadeFacade.getUnidade(1);
        Avalistaaluno avalistaaluno = new Avalistaaluno();
        avalistaaluno.setAvalista(avalista);
        aluno.setAvalistaaluno(avalistaaluno);       
        aluno.setUnidade(unidade);
        aluno = alunoFacade.salvar(aluno);
        if (aluno.getTrabalha().equalsIgnoreCase("Sim")){
            localTrabalho.setAluno(aluno);
            alunoFacade.salvarLocalTrabalho(localTrabalho);
        }
        if (!aluno.getEstadoCivil().equalsIgnoreCase("Solteiro")){
            conjuge.setAluno(aluno);
            alunoFacade.salvarConjuge(conjuge);
        }
        return "consaluno";
    }
    
    public String cancelar(){
        return "consaluno";
    }
    
}
