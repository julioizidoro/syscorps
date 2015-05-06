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
    

    public MatriculaMB() {
        matricula = new Matricula();
        matricula.setAluno(new Aluno());
        gerarLitaCurso();
        carregarListaTurma();
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

    public List<Matricula> getListaMatricula() {
        return listaMatricula;
    }

    public void setListaMatricula(List<Matricula> listaMatricula) {
        this.listaMatricula = listaMatricula;
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
    
    public void carregarListaTurma() {
        TurmaFacade turmaFacade = new TurmaFacade();
        listaTurma = turmaFacade.listar("", 1);
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
     
     public void carregarListaMatricula() {
        if (idTurma != null) {
            MatriculaFacade matriculaFacade = new MatriculaFacade();
            listaMatricula = matriculaFacade.listar(Integer.parseInt(idTurma));
            if (listaMatricula == null) {
                listaMatricula = new ArrayList<Matricula>();
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
}
