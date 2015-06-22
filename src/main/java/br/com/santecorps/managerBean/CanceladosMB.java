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

    public Cancelados getCancelados() {
        return cancelados;
    }

    public void setCancelados(Cancelados cancelados) {
        this.cancelados = cancelados;
    }
    
    
    public String cancelar(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        int idMatricula =  Integer.parseInt(params.get("id_matricula"));
        if (idMatricula>0){
            MatriculaFacade matriculaFacade = new MatriculaFacade();
            Matricula matricula = matriculaFacade.getMatricula(idMatricula);
            cancelados.setMatricula(matricula);
            cancelados.setUsuario(usuarioLogadoMB.getUsuario());
            cancelados.setData(new Date());
            CanceladosFacade canceladosFacade = new CanceladosFacade();
            cancelados = canceladosFacade.salvar(cancelados);
            matricula.setSituacao("Cancelada");
            matriculaFacade.salvar(matricula);
            return "listarAlunos";
        }
        return "";
    }
    
    
}
