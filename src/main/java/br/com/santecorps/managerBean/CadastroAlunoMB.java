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
    
     

    public CadastroAlunoMB() {
        CarregarLitaAluno();
      carregarObjetos();
        
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
        
        
        return "cadaluno";
    }
    
    public String salvarAluno(){
        float rmAvalista = 0.0f;
        float rmConjuge = 0.0f;
        if (rendaMensalAvalista != null) {
            if (rendaMensalAvalista.length() > 0) {
                rmAvalista = Formatacao.ConvercaoMonetariaFloat(rendaMensalAvalista);
            }
        }
        if (rendaMensalConjuge != null) {
            if (rendaMensalConjuge.length() > 0) {
                rmConjuge = Formatacao.ConvercaoMonetariaFloat(rendaMensalConjuge);
            }
        }
        AlunoFacade alunoFacade = new AlunoFacade();
        UnidadeFacade unidadeFacade = new UnidadeFacade();
        Unidade unidade = unidadeFacade.getUnidade(1);
        Avalistaaluno avalistaaluno = new Avalistaaluno();
        avalista.setRendaMensal(rmAvalista);
        avalistaaluno.setAvalista(avalista);
        aluno.setAvalistaaluno(avalistaaluno);       
        aluno.setUnidade(unidade);
        aluno = alunoFacade.salvar(aluno);
        if (aluno.getTrabalha().equalsIgnoreCase("Sim")){
            localTrabalho.setAluno(aluno);
            alunoFacade.salvarLocalTrabalho(localTrabalho);
        }
        if (!aluno.getEstadoCivil().equalsIgnoreCase("Solteiro")){
            conjuge.setRendaMensal(rmConjuge);
            conjuge.setAluno(aluno);
            alunoFacade.salvarConjuge(conjuge);
        }
        CarregarLitaAluno();
        return "consaluno";
    }
    
    public String cancelar(){
        return "consaluno";
    }
    
    public String consultarAluno(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        int idAluno =  Integer.parseInt(params.get("id_aluno"));
        if (idAluno>0){
            AlunoFacade alunoFacade = new AlunoFacade();
            aluno = alunoFacade.getAlunoId(idAluno);
            if (aluno!=null){
                avalista = aluno.getAvalistaaluno().getAvalista();
                if (avalista!=null){
                    rendaMensalAvalista = Formatacao.foramtarFloatString(avalista.getRendaMensal());
                }
                if (!aluno.getEstadoCivil().equalsIgnoreCase("Solteiro")){
                    if (aluno.getConjugeList()!=null){
                        conjuge = aluno.getConjugeList().get(0);
                        rendaMensalConjuge = Formatacao.foramtarFloatString(conjuge.getRendaMensal());
                    }
                    
                }
                if (aluno.getTrabalha().equalsIgnoreCase("Sim")){
                    localTrabalho = aluno.getLocaltrabalhoList().get(0);
                }
            }
            return "cadaluno";
        }
        return "consaluno";
        
    }
    
    public String pesquisarNome(){
        
        CarregarLitaAluno();
        return "consaluno";
    }
    
    public void carregarObjetos(){
        
        aluno = new Aluno();
        conjuge = new Conjuge();
        avalista = new Avalista();
        localTrabalho = new Localtrabalho();
        aluno.setBairro("monte verde");
        aluno.setCep("88032-600");
        aluno.setCidade("Florianopolis");
        aluno.setCidadeNascimento("Florianopolis");
        aluno.setComplemento("casa");
        aluno.setCpf("104.682.109-11");
        aluno.setDataNascimento(Formatacao.ConvercaoStringData("30/10/1997"));
        aluno.setEmail("kamila@gmail.com");
        aluno.setEstado("SC");
        aluno.setEstadoCivil("Solteiro");
        aluno.setEstadoNascimento("SC");
        aluno.setFoneCelular("(48)8472-2287");
        aluno.setFoneFixo("(48)3238-0360");
        aluno.setFoneReferenciaPessoal("(48)8472-2222");
        aluno.setNome("kamila");
        aluno.setNomeMae("Fabiana");
        aluno.setNomePai("Paulo");
        aluno.setNumero("318");
        aluno.setProfissao("Programador");
        aluno.setReferenciaPessoal("Fabiola");
        aluno.setNascionalidade("Brasileira");
        aluno.setRg("1112566");
        aluno.setTipoLogradouro("Rua");
        aluno.setTrabalha("Sim");
        
       
        
        localTrabalho.setCargo("Programador Junior");
        localTrabalho.setComprovanteRenda("renda");
        localTrabalho.setFoneComercial("(48)3233-2320");
        localTrabalho.setNome("TravelMate");
        localTrabalho.setOutrasRendas("renda");
        
        avalista.setBairro("Capoeiras");
        avalista.setCep("88032-680");
        avalista.setCidade("Florianpolis");
        avalista.setComplemento("apto 10");
        avalista.setCpf("104.104.104-22");
        avalista.setDataNascimento(Formatacao.ConvercaoStringData("10/05/1987"));
        avalista.setEstado("SC");
        avalista.setFoneCelular("(48)8484-8484");
        avalista.setFoneFixo("(48)3238-0311");
        avalista.setLogradouro("Jose martins");
        avalista.setNome("joao");
        avalista.setNumero("150");
        avalista.setProfissao("Engenheiro");
        avalista.setRendaMensal(3500.00f);
        avalista.setRg("2545555");
        avalista.setTipoLogradouro("BR");
        
        conjuge.setBairro("Monte verde");
        conjuge.setCep("88032-600");
        conjuge.setCidade("Florianopolis");
        conjuge.setComplemento("casa");
        conjuge.setCpf("104.682.101-22");
        conjuge.setDataNascimento(Formatacao.ConvercaoStringData("30/10/1990"));
        conjuge.setEstado("SC");
        conjuge.setFoneCelular("(48)8472-2211");
        conjuge.setFoneFixo("(48)3232-0560");
        conjuge.setLogradouro("Mane vicente");
        conjuge.setNome("Luiz");
        conjuge.setNumero("318");
        conjuge.setProfissao("Arquiteto");
        conjuge.setRendaMensal(2500.00f);
        conjuge.setRg("15555158");
        conjuge.setTipoLogradouro("Rua");
        rendaMensalAvalista = Formatacao.foramtarFloatString(avalista.getRendaMensal());
        rendaMensalConjuge = Formatacao.foramtarFloatString(conjuge.getRendaMensal());
    }
    
}
