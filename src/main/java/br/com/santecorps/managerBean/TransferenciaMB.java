/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.managerBean;

import br.com.santecorps.facade.MatriculaFacade;
import br.com.santecorps.facade.TransferenciaFacade;
import br.com.santecorps.facade.TurmaFacade;
import br.com.santecorps.model.Matricula;
import br.com.santecorps.model.Transferencia;
import br.com.santecorps.model.Turma;
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
public class TransferenciaMB implements Serializable{
    
    @Inject 
    private UsuarioLogadoMB usuarioLogadoMB;
    @Inject MatriculaMB matriculaMB;
    private Transferencia transferencia;
    private String idTurma;
    private Matricula matricula;
    

    public TransferenciaMB() {
        transferencia = new Transferencia();
    }
    
    

    public Transferencia getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public String getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(String idTurma) {
        this.idTurma = idTurma;
    }

    public MatriculaMB getMatriculaMB() {
        return matriculaMB;
    }

    public void setMatriculaMB(MatriculaMB matriculaMB) {
        this.matriculaMB = matriculaMB;
    }
    
    
    
    public String iniciarTransferecia(){
        transferencia = new Transferencia();
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        int idMatricula =  Integer.parseInt(params.get("id_matricula"));
        if (idMatricula>0){
            MatriculaFacade matriculaFacade = new MatriculaFacade();
            matricula = matriculaFacade.getMatricula(idMatricula);
            transferencia = new Transferencia();
            transferencia.setMatricula(matricula);
            transferencia.setTurmaatual(matricula.getTurma());
        }
        return "transferir";
    }
    
    public String salvarTransferencia(){
        transferencia.setData(new Date());
        transferencia.setUsuario(usuarioLogadoMB.getUsuario());
        TurmaFacade  turmaFacade = new TurmaFacade();
        Turma turma = turmaFacade.getTurmaId(Integer.parseInt(idTurma));
        transferencia.setTurmanova(turma);
        TransferenciaFacade transferenciaFacade = new TransferenciaFacade();
        transferencia = transferenciaFacade.salvar(transferencia);
        MatriculaFacade matriculaFacade = new MatriculaFacade();
        matricula.setTurma(transferencia.getTurmanova());
        matriculaFacade.salvar(matricula);
        matriculaMB.carregarListaMatricula();
        return "listarAlunos";
    }
    
    public String voltar(){
        return "listarAlunos";
    }
}
