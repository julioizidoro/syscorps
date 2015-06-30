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
import br.com.santecorps.util.GerarRelatorio;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Wolverine
 */

@Named
@SessionScoped
public class MatriculaMB implements Serializable{
    
    @Inject
    private CadastroAlunoMB cadastroAlunoMB;
    @Inject
    private UsuarioLogadoMB usuarioLogadoMB;
    private Matricula matricula;
    private List<Curso> listaCursos;
    private List<Turma> listaTurma;
    private List<Matricula> listaMatricula;
    private String idCurso;
    private String idTurma;
    private String valorTotal;
    private String valorEntrada;
    private String valorParcela;
    private String numeroParcelas;
    private Turma turma;
    private boolean ficha;
    private boolean contrato;
    private boolean termo;
    private boolean recibo;
    private boolean lista;
    private boolean requerimento;
    @Inject RematriculaMB rematriculaMB;
    

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

    public boolean isRequerimento() {
        return requerimento;
    }

    public void setRequerimento(boolean requerimento) {
        this.requerimento = requerimento;
    }

    public String getIdTurma() {
        return idTurma;
    }

    public boolean isFicha() {
        return ficha;
    }

    public void setFicha(boolean ficha) {
        this.ficha = ficha;
    }

    public boolean isContrato() {
        return contrato;
    }

    public void setContrato(boolean contrato) {
        this.contrato = contrato;
    }

    public boolean isTermo() {
        return termo;
    }

    public void setTermo(boolean termo) {
        this.termo = termo;
    }

    public boolean isRecibo() {
        return recibo;
    }

    public void setRecibo(boolean recibo) {
        this.recibo = recibo;
    }

    public boolean isLista() {
        return lista;
    }

    public void setLista(boolean lista) {
        this.lista = lista;
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
        if(listaCursos==null){
            gerarLitaCurso();
        }
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public List<Turma> getListaTurma() {
        if (listaTurma==null){
            carregarListaTurma();
        }
        return listaTurma;
    }

    public void setListaTurma(List<Turma> listaTurma) {
        this.listaTurma = listaTurma;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public List<Matricula> getListaMatricula() {
        return listaMatricula;
    }

    public void setListaMatricula(List<Matricula> listaMatricula) {
        this.listaMatricula = listaMatricula;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public RematriculaMB getRematriculaMB() {
        return rematriculaMB;
    }

    public void setRematriculaMB(RematriculaMB rematriculaMB) {
        this.rematriculaMB = rematriculaMB;
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
            listaTurma = turmaFacade.listar(Integer.parseInt(idCurso), usuarioLogadoMB.getUsuario().getUnidade().getIdunidade());
            if (listaTurma == null) {
                listaTurma = new ArrayList<Turma>();
            }
        }
    }
    
    public void carregarListaTurma() {
        TurmaFacade turmaFacade = new TurmaFacade();
        listaTurma = turmaFacade.listar("", usuarioLogadoMB.getUsuario().getUnidade().getIdunidade());
        if (listaTurma == null) {
            listaTurma = new ArrayList<Turma>();
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
         matricula.setSituacao("Ativa");
         matricula.setRematricula(false);
         matriculaFacade.salvar(matricula);
         cadastroAlunoMB.setAluno(new Aluno());
         matricula = new Matricula();
         idTurma="0";
         listaCursos = null;
         listaTurma=null;
         valorEntrada="";
         valorParcela="";
         valorTotal="";
         idCurso="0";
         numeroParcelas="";
         turma = new Turma();
         return "inicial";
     }
     
     public String cancelar(){
         cadastroAlunoMB.setAluno(new Aluno());
         matricula = new Matricula();
         idTurma="0";
         listaCursos = null;
         listaTurma=null;
         valorEntrada="";
         valorParcela="";
         valorTotal="";
         idCurso="0";
         numeroParcelas="";
         turma = new Turma();
         return "inicial";
     }
     
     public void selecoinarTurma(){
         if (idTurma!=null){
             TurmaFacade turmaFacade = new TurmaFacade();
             turma = turmaFacade.getTurmaId(Integer.parseInt(idTurma));
         }
     }
     
     public void carregarListaMatricula() {
        if (idTurma != null) {
            MatriculaFacade matriculaFacade = new MatriculaFacade();
            listaMatricula = matriculaFacade.listar(Integer.parseInt(idTurma));
            if (listaMatricula == null) {
                listaMatricula = new ArrayList<Matricula>();
                rematriculaMB.retornaSituacao(matricula);
            }
        }
    }
     
    public String selecionarMatriculaImprimir(){
        for(int i=0; i<listaMatricula.size();i++){
            if (listaMatricula.get(i).isSelecionado()){
                matricula = listaMatricula.get(i);
                return "";
            }
        }
        return "";
    }
    
    public void imprimir(){
        if (recibo){
            imprimirRecibo();
        }
        if (ficha){
            imprimirFichaMatricula();
        }
        if (lista){
            imprimirListaMatriculados();
        }
        if (contrato){
            imprimirContratoEscolar();
        }
        if (requerimento){
            imprimirRequerimento();
        }
        if (termo){
            imprimirTermo();
        }
    }
    
    public void finalizarImpressao(){
        recibo=false;
        ficha=false;
        contrato=false;
        termo=false;
        lista=false;
    }
    
    public void imprimirRecibo(){
        if (matricula.getValorentrada() > 0) {
            String caminhoRelatorio = "/resources/relatorios/recibo.jasper";
            Map parameters = new HashMap();
            parameters.put("nomealuno", matricula.getAluno().getNome());
            parameters.put("turma", matricula.getAluno().getUnidade().getCidade() + "/" + matricula.getAluno().getUnidade().getEstado());
            parameters.put("usuario", usuarioLogadoMB.getUsuario().getNome());
            parameters.put("curso", matricula.getTurma().getCurso().getNome());
            parameters.put("valor", matricula.getValorentrada());
            parameters.put("valorextenso", Formatacao.valorPorExtenso(matricula.getValorentrada().doubleValue()));
            String nomeArquivo = "recibo";
            //parameters.put("REPORT_LOCALE", new Locale("pt", "BR"));
            GerarRelatorio gerarRelatorio = new GerarRelatorio();
            try {
                gerarRelatorio.gerarRelatorioSqlPDF(caminhoRelatorio, parameters, nomeArquivo, null);
            } catch (JRException ex) {
                Logger.getLogger(MatriculaMB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MatriculaMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void imprimirFichaMatricula(){
        if (matricula!=null) {
            String caminhoRelatorio = "/resources/relatorios/matricula/fichainscricao.jasper";
            Map parameters = new HashMap();
            parameters.put("usuario", usuarioLogadoMB.getUsuario().getNome());
            parameters.put("idmatricula", matricula.getIdmatricula());
            String nomeArquivo = "fichamatricula";
            //parameters.put("REPORT_LOCALE", new Locale("pt", "BR"));
            GerarRelatorio gerarRelatorio = new GerarRelatorio();
            try {
                gerarRelatorio.gerarRelatorioSqlPDF(caminhoRelatorio, parameters, nomeArquivo, null);
            } catch (JRException ex) {
                Logger.getLogger(MatriculaMB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MatriculaMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    public void imprimirListaMatriculados(){
        if (!idTurma.equalsIgnoreCase("0")) {
            String caminhoRelatorio = "/resources/relatorios/matricula/listamatricula.jasper";
            Map parameters = new HashMap();
            parameters.put("usuario", usuarioLogadoMB.getUsuario().getNome());
            parameters.put("idturma", Integer.valueOf(idTurma));
            String nomeArquivo = "listamatriculados";
            //parameters.put("REPORT_LOCALE", new Locale("pt", "BR"));
            GerarRelatorio gerarRelatorio = new GerarRelatorio();
            try {
                gerarRelatorio.gerarRelatorioSqlPDF(caminhoRelatorio, parameters, nomeArquivo, null);
            } catch (JRException ex) {
                Logger.getLogger(MatriculaMB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MatriculaMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void imprimirContratoEscolar(){
        if (matricula!=null) {
            String caminhoRelatorio = "/resources/relatorios/matricula/contratoescolarpagina01.jasper";
            Map parameters = new HashMap();
            parameters.put("idmatricula", matricula.getIdmatricula());
            String nomeArquivo = "contratoescolar";
            //parameters.put("REPORT_LOCALE", new Locale("pt", "BR"));
            GerarRelatorio gerarRelatorio = new GerarRelatorio();
            try {
                gerarRelatorio.gerarRelatorioSqlPDF(caminhoRelatorio, parameters, nomeArquivo, "/resources/relatorios/matricula/");
            } catch (JRException ex) {
                Logger.getLogger(MatriculaMB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MatriculaMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void imprimirRequerimento(){
        if (matricula!=null) {
            String caminhoRelatorio = "/resources/relatorios/matricula/requerimento.jasper";
            Map parameters = new HashMap();
            parameters.put("idmatricula", matricula.getIdmatricula());
            String texto = "Declaro que as informações contidas estão corretas e verdadeiras, ficando o " + usuarioLogadoMB.getUsuario().getUnidade().getRazaosocial() +" , desde já autorizado a verificá-las. Autorizo o "+ usuarioLogadoMB.getUsuario().getUnidade().getRazaosocial()  + ", em caráter irrevogável e irretratável a transmitir e consultar informações de crédito do Banco Central do Brasil, listas impeditivas e SERASA/SPC da forma de regulamentação aplicável, e encaminhar sem qualquer ônus mensagem de texto e voz, através de telefone celular de minha titularidade acima mencionado, a respeito de promoções eventuais e pendências junto o "  + usuarioLogadoMB.getUsuario().getUnidade().getRazaosocial();
            parameters.put("texto", texto);
            String nomeArquivo = "requerimentomatriculados";
            //parameters.put("REPORT_LOCALE", new Locale("pt", "BR"));
            GerarRelatorio gerarRelatorio = new GerarRelatorio();
            try {
                gerarRelatorio.gerarRelatorioSqlPDF(caminhoRelatorio, parameters, nomeArquivo, null);
            } catch (JRException ex) {
                Logger.getLogger(MatriculaMB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MatriculaMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void imprimirTermo(){
        if (matricula!=null) {
            String caminhoRelatorio = "/resources/relatorios/matricula/termo.jasper";
            Map parameters = new HashMap();
            parameters.put("idmatricula", matricula.getIdmatricula());
             String nomeArquivo = "termo";
            //parameters.put("REPORT_LOCALE", new Locale("pt", "BR"));
            GerarRelatorio gerarRelatorio = new GerarRelatorio();
            try {
                gerarRelatorio.gerarRelatorioSqlPDF(caminhoRelatorio, parameters, nomeArquivo, null);
            } catch (JRException ex) {
                Logger.getLogger(MatriculaMB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MatriculaMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
