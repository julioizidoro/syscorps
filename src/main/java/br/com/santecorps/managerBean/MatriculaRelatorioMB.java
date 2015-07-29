/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.managerBean;

import br.com.santecorps.model.Matricula;
import br.com.santecorps.util.Formatacao;
import br.com.santecorps.util.GerarRelatorio;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Wolverine
 */
@Named
@ViewScoped
public class MatriculaRelatorioMB implements Serializable{
    
    private boolean ficha;
    private boolean contrato;
    private boolean termo;
    private boolean recibo;
    private boolean lista;
    private boolean listaAtivos;
    private boolean requerimento;
    private Matricula matricula;
    @Inject
    private UsuarioLogadoMB usuarioLogadoMB;
    private int idTurma;

    public MatriculaRelatorioMB() {
        FacesContext fc = FacesContext.getCurrentInstance();  
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);  
        matricula = (Matricula) session.getAttribute("matricula");
        idTurma = (int) session.getAttribute("idturma");
        session.removeAttribute("matricula");
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

    public boolean isListaAtivos() {
        return listaAtivos;
    }

    public void setListaAtivos(boolean listaAtivos) {
        this.listaAtivos = listaAtivos;
    }

    public boolean isRequerimento() {
        return requerimento;
    }

    public void setRequerimento(boolean requerimento) {
        this.requerimento = requerimento;
    }
    
    public void imprimir(){
        if (recibo){
            imprimirRecibo();
        }
        if (ficha){
            imprimirFichaMatricula();
        }
        if (lista){
            imprimirListaTodosMatriculados();
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
        if (listaAtivos){
            imprimirListaMatriculados();
        }
        finalizarImpressao();
    }
    
    public void finalizarImpressao(){
        recibo=false;
        ficha=false;
        contrato=false;
        termo=false;
        lista=false;
        listaAtivos=false;
        matricula = new Matricula();
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
        if (idTurma>0) {
            String caminhoRelatorio = "/resources/relatorios/matricula/listamatricula.jasper";
            Map parameters = new HashMap();
            parameters.put("usuario", usuarioLogadoMB.getUsuario().getNome());
            parameters.put("idturma", Integer.valueOf(idTurma));
            parameters.put("situacao", "Ativa");
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
    
    public void imprimirListaTodosMatriculados(){
        if (idTurma>0) {
            String caminhoRelatorio = "/resources/relatorios/matricula/listamatricula.jasper";
            Map parameters = new HashMap();
            parameters.put("usuario", usuarioLogadoMB.getUsuario().getNome());
            parameters.put("idturma", Integer.valueOf(idTurma));
            parameters.put("situacao", "Cancelada");
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
