/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.managerBean;

import br.com.santecorps.facade.CursoFacade;

import br.com.santecorps.facade.TurmaFacade;
import br.com.santecorps.facade.UnidadeFacade;
import br.com.santecorps.model.Curso;
import br.com.santecorps.model.Turma;
import br.com.santecorps.model.Unidade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Wolverine
 */

@Named
@SessionScoped
public class CadastroTurmasMB implements Serializable{
    
    @Inject
    private UsuarioLogadoMB usuarioLogadoMB;
    private List<Turma> listaTurmas;
    private Turma turma;
    private String idCurso="0";
    private List<Curso> listaCursos;
    private String nomeTurma;

    public CadastroTurmasMB() {
        turma = new Turma();
    }
    public List<Turma> getListaTurmas() {
        if (listaTurmas==null){
            listarTurmas("");
        }
        return listaTurmas;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }
    
    public void setListaTurmas(List<Turma> listaTurmas) {
        this.listaTurmas = listaTurmas;
    }
    public Turma getTurma() {
        return turma;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    public String pesquisarNome(){
        listarTurmas(nomeTurma);
        return "";
    }  
    
    public String novaTurma(){
        turma = new Turma();
        listarCursos();
        return "cadturmas";
    }
    
    public void listarTurmas(String nome){
        TurmaFacade turmaFacade = new TurmaFacade();
        listaTurmas = turmaFacade.listar(nome, usuarioLogadoMB.getUsuario().getUnidade().getIdunidade());
        if (listaTurmas == null) {
            listaTurmas = new ArrayList<Turma>();
        }
    }
    
    /**
     *
     * @return
     */
    public String salvarTurma(){
        TurmaFacade turmaFacade = new TurmaFacade();
        CursoFacade cursoFacade = new CursoFacade();
        if (turma.getIdturma()==null){
            turma.setFormada("N");
            UnidadeFacade unidadeFacade = new UnidadeFacade();
            Unidade unidade = unidadeFacade.getUnidade(1);
            turma.setUnidade(unidade);
        }
        Curso curso = cursoFacade.getCurso(Integer.parseInt(idCurso));
        turma.setCurso(curso);
        turmaFacade.salvar(turma);
        listarTurmas("");
        return "consturmas";
    }
    
    public String cancelar(){
        return "consturmas";
    }
    public String consultarTurma(){
        listarCursos();
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        int idTurma=  Integer.parseInt(params.get("id_turma"));
        if (idTurma>0){
            TurmaFacade turmaFacade = new TurmaFacade();
            turma = turmaFacade.getTurmaId(idTurma);
            if (turma!=null){
                idCurso = String.valueOf(turma.getCurso().getIdcurso());
                return "cadturmas";
            }
        }
        return null;
    }
    
    public void listarCursos(){
        CursoFacade cursoFacade = new CursoFacade();
        if (nomeTurma==null){
            nomeTurma="";
        }
        listaCursos = cursoFacade.listar(nomeTurma);
        if (listaCursos==null){
            listaCursos = new ArrayList<Curso>();
        }
    }
    
    public String formaTurma(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        int idturma =  Integer.parseInt(params.get("id_turma"));
        if (idturma>0){
            TurmaFacade turmaFacade = new TurmaFacade();
            turma = turmaFacade.getTurmaId(idturma);
             if (turma!=null){
                 return "formarturmas";
            }
        }
        return null;
    }
    
    public String salvarTurmaFormada(){
        TurmaFacade turmaFacade = new TurmaFacade();
        CursoFacade cursoFacade = new CursoFacade();
        turma.setFormada("S");
        turmaFacade.salvar(turma);
        listarTurmas("");
        return "consturmas";
    }
}
