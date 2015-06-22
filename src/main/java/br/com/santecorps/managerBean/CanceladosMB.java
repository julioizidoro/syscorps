/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.managerBean;

import br.com.santecorps.facade.CanceladosFacade;
import br.com.santecorps.facade.MatriculaFacade;
import br.com.santecorps.model.Cancelados;
import br.com.santecorps.model.Matricula;
import java.io.Serializable;
import java.util.Date;
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
public class CanceladosMB implements Serializable{
    
    @Inject
    private UsuarioLogadoMB usuarioLogadoMB;
    private Cancelados cancelados;
    private Matricula matricula;

    public Cancelados getCancelados() {
        return cancelados;
    }

    public void setCancelados(Cancelados cancelados) {
        this.cancelados = cancelados;
    }

    public UsuarioLogadoMB getUsuarioLogadoMB() {
        return usuarioLogadoMB;
    }

    public void setUsuarioLogadoMB(UsuarioLogadoMB usuarioLogadoMB) {
        this.usuarioLogadoMB = usuarioLogadoMB;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
    
    public String salvarCancelamento() {
        cancelados.setUsuario(usuarioLogadoMB.getUsuario());
        cancelados.setData(new Date());
        CanceladosFacade canceladosFacade = new CanceladosFacade();
        cancelados = canceladosFacade.salvar(cancelados);
        matricula.setSituacao("Cancelada");
        MatriculaFacade matriculaFacade = new MatriculaFacade();
        matriculaFacade.salvar(matricula);
        return "listarAlunos";
    }
    
    
    public String cancelar(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        int idMatricula =  Integer.parseInt(params.get("id_matricula"));
        if (idMatricula>0){
            MatriculaFacade matriculaFacade = new MatriculaFacade();
            matricula = matriculaFacade.getMatricula(idMatricula);
            cancelados.setMatricula(matricula);
        }
        return "";
    }
    
    
}
