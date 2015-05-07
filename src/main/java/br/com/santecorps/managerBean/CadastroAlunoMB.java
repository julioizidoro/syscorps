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
import br.com.santecorps.model.Conjuge;
import br.com.santecorps.model.Localtrabalho;
import br.com.santecorps.model.Unidade;
import br.com.santecorps.util.Formatacao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Wolverine
 */

@Named
@SessionScoped
public class CadastroAlunoMB implements Serializable{
    
    private List<Aluno> listaAlunos;
    private Aluno aluno;
    private Conjuge conjuge;
    private Avalista avalista;
    private Localtrabalho localTrabalho;
    private String nomeAluno;
    private String rendaMensalAvalista;
    private String rendaMensalConjuge;
    private String paginaRetorno;
    
     

    public CadastroAlunoMB() {
        aluno = new Aluno();
        CarregarLitaAluno();
    }

    public String getRendaMensalAvalista() {
        return rendaMensalAvalista;
    }

    public void setRendaMensalAvalista(String rendaMensalAvalista) {
        this.rendaMensalAvalista = rendaMensalAvalista;
    }

    public String getRendaMensalConjuge() {
        return rendaMensalConjuge;
    }

    public void setRendaMensalConjuge(String rendaMensalConjuge) {
        this.rendaMensalConjuge = rendaMensalConjuge;
    }


    public String getPaginaRetorno() {
        return paginaRetorno;
    }

    public void setPaginaRetorno(String paginaRetorno) {
        this.paginaRetorno = paginaRetorno;
    }
    

    public List<Aluno> getListaAlunos() {
        if (listaAlunos.size()==0){
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
        if (nomeAluno==null){
            nomeAluno = "";
        }
        AlunoFacade alunoFacade = new AlunoFacade();
        listaAlunos = alunoFacade.listar(nomeAluno);
        if (listaAlunos==null){
            listaAlunos = new ArrayList<Aluno>();
        }
    }
    
    public String novoAluno(){
        aluno = new Aluno();
        avalista = new Avalista();
        conjuge = new Conjuge();
        localTrabalho = new Localtrabalho();
        return "cadaluno";
    }
    
    public String salvarAluno(){
        boolean cadAluno = false;
        if (aluno.getIdaluno()==null){
            cadAluno = true;
        }
        AlunoFacade alunoFacade = new AlunoFacade();
        UnidadeFacade unidadeFacade = new UnidadeFacade();
        Unidade unidade = unidadeFacade.getUnidade(1);
        aluno.setUnidade(unidade);
        aluno.setMes(Formatacao.retornoMesData(aluno.getDataNascimento()));
        aluno = alunoFacade.salvar(aluno);
        if (cadAluno) {
            avalista.setAluno(aluno);
            avalista = alunoFacade.salvarAvalista(avalista);
            conjuge.setAluno(aluno);
            conjuge = alunoFacade.salvarConjuge(conjuge);
            localTrabalho.setAluno(aluno);
            localTrabalho = alunoFacade.salvarLocalTrabalho(localTrabalho);
        }
        CarregarLitaAluno();
        return "consaluno";
    }
    
    public String cancelar(){
        return "consaluno";
    }
    public String cancelarDialog(){
        return "cadinfoaluno";
    }
    public String informacoesClientes(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        int idAluno =  Integer.parseInt(params.get("id_aluno"));
        if (idAluno>0){
            AlunoFacade alunoFacade = new AlunoFacade();
            aluno = alunoFacade.getAlunoId(idAluno);
            if (aluno!=null){
                localTrabalho = new Localtrabalho();
                conjuge = new Conjuge();
                avalista = new Avalista();
                if (aluno.getAvalistaList()!=null){
                    if (aluno.getAvalistaList().size()>0){
                        avalista = aluno.getAvalistaList().get(0);
                    }
                }
                if (aluno.getLocaltrabalhoList()!=null){
                    if (aluno.getLocaltrabalhoList().size()>0){
                        localTrabalho = aluno.getLocaltrabalhoList().get(0);
                    }
                }
                if (aluno.getConjugeList()!=null){
                    if (aluno.getConjugeList().size()>0){
                        conjuge = aluno.getConjugeList().get(0);
                    }
                }
                return "cadinfoaluno";
            }
        }
        return "";
    }
    
    public String consultarAluno(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        int idAluno =  Integer.parseInt(params.get("id_aluno"));
        if (idAluno>0){
            AlunoFacade alunoFacade = new AlunoFacade();
            aluno = alunoFacade.getAlunoId(idAluno);
             if (aluno!=null){
                return "cadaluno";
            }
        }
        return null;
    }
        
    public String pesquisarNome(){
        CarregarLitaAluno();
        return "consaluno";
    }
    
     public String pesquisarNomeSelecionado(){
        CarregarLitaAluno();
        return "selecionarAluno";
    }
     
    public String pesquisarNomeMatricula(){   
        CarregarLitaAluno();
        return "selecionarAluno";
    }
   
    
    public String salvarAvalista(){
        float rmAvalista = 0.0f;
        if (rendaMensalAvalista != null) {
            if (rendaMensalAvalista.length() > 0) {
                rmAvalista = Formatacao.ConvercaoMonetariaFloat(rendaMensalAvalista);
            }
        }
        AlunoFacade alunoFacade = new AlunoFacade();
        avalista.setRendaMensal(rmAvalista);
        avalista.setAluno(aluno);
        avalista = alunoFacade.salvarAvalista(avalista);
        return "cadinfoaluno";
    }
    public String salvarConjuge(){
        float rmConjuge = 0.0f;
        if (rendaMensalConjuge != null) {
            if (rendaMensalConjuge.length() > 0) {
                rmConjuge = Formatacao.ConvercaoMonetariaFloat(rendaMensalConjuge);
            }
        }
        AlunoFacade alunoFacade = new AlunoFacade();
        conjuge.setRendaMensal(rmConjuge);
        conjuge.setAluno(aluno);
        conjuge = alunoFacade.salvarConjuge(conjuge);
         return "cadinfoaluno";
    }
    
    public String salvarLocalTrabalho(){
        localTrabalho.setAluno(aluno);
        AlunoFacade alunoFacade = new AlunoFacade();
        localTrabalho = alunoFacade.salvarLocalTrabalho(localTrabalho);
        return "cadinfoaluno";
    }
    
    public String selecionarAluno(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        int idAluno =  Integer.parseInt(params.get("id_aluno"));
        if (idAluno>0){
            AlunoFacade alunoFacade = new AlunoFacade();
            aluno = alunoFacade.getAlunoId(idAluno);
             if (aluno!=null){
                return paginaRetorno;
            }
        }
        return null;
    }
    
    public String voltarSelecionarAluno(){
        return paginaRetorno;
    }
    
    

}
