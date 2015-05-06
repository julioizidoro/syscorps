/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.managerBean;


import br.com.santecorps.facade.MatriculaFacade;
import br.com.santecorps.facade.TurmaFacade;
import br.com.santecorps.model.Matricula;
import br.com.santecorps.model.Turma;
import br.com.santecorps.relatorios.aniversariantes.AniversarianteFactory;
import br.com.santecorps.relatorios.aniversariantes.AniversariantesBean;
import br.com.santecorps.util.Formatacao;
import br.com.santecorps.util.GerarRelatorio;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Wolverine
 */
@Named
@SessionScoped
public class AniversariantesMB implements Serializable{
    
    private List<AniversariantesBean> listaAniversariantes;
    private String mes;
    private String idTurma;
    private List<Turma> listaTurma;
    private String nomeTurma;

    public AniversariantesMB() {
        gerarListaTurma();
    }

    public List<AniversariantesBean> getListaAniversariantes() {
        return listaAniversariantes;
    }

    public void setListaAniversariantes(List<AniversariantesBean> listaAniversariantes) {
        this.listaAniversariantes = listaAniversariantes;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(String idTurma) {
        this.idTurma = idTurma;
    }

    public List<Turma> getListaTurma() {
        return listaTurma;
    }

    public void setListaTurma(List<Turma> listaTurma) {
        this.listaTurma = listaTurma;
    }
    
    public void gerarListaTurma() {
        TurmaFacade turmaFacade = new TurmaFacade();
        listaTurma = turmaFacade.listar("", 1);
        if (listaTurma == null) {
            listaTurma = new ArrayList<Turma>();
        }
    }
    
    public void gerarLista() {
        listaAniversariantes = new ArrayList<AniversariantesBean>();
        if (idTurma != null) {
            MatriculaFacade matriculaFacade = new MatriculaFacade();
            List<Matricula> listaMatricula = matriculaFacade.listar(Integer.parseInt(idTurma), Integer.valueOf(mes));
            if (listaMatricula == null) {
                listaMatricula = new ArrayList<Matricula>();
            }
            if (listaMatricula.size()>0){
                nomeTurma = listaMatricula.get(0).getTurma().getNumero() + " - " + listaMatricula.get(0).getTurma().getNome();
            }
            for (int i = 0; i < listaMatricula.size(); i++) {
                AniversariantesBean aniversariantesBean = new AniversariantesBean();
                aniversariantesBean.setCategoria("Participante");
                aniversariantesBean.setDataAniversario(Formatacao.dataAniversario(listaMatricula.get(i).getAluno().getDataNascimento()));
                aniversariantesBean.setEmail(listaMatricula.get(i).getAluno().getEmail());
                aniversariantesBean.setNome(listaMatricula.get(i).getAluno().getNome());
                listaAniversariantes.add(aniversariantesBean);
            }
        }
    }
    public String voltar(){
        return "inicial";
    }
    
    public void imprimirRelacaoAniversariantes() throws JRException, IOException{
        String caminhoRelatorio = "/resources/relatorios/relaniversario.jasper";  
        Map parameters = new HashMap();
         String localLogo = "/resources" + File.separator + "img" +
                                    File.separator + "logo.jpg";
        Image logo = new ImageIcon(localLogo).getImage();
        //parameters.put("logo", logo);
        String titulo = "Relação de Aniversariantes";
        parameters.put("titulo", titulo);
        parameters.put("turma",nomeTurma);
        String nomeArquivo = "relAniversariantes.pdf";
        //parameters.put("REPORT_LOCALE", new Locale("pt", "BR"));
        AniversarianteFactory.setListaAniversariante(listaAniversariantes);
        JRDataSource jrds = new JRBeanCollectionDataSource(AniversarianteFactory.getListaAniversariante());
        GerarRelatorio gerarRelatorio = new GerarRelatorio();
        gerarRelatorio.gerarRelatorioDSPDF(caminhoRelatorio, parameters, jrds, nomeArquivo);
    }
}
