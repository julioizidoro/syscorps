package br.com.santecorps.managerBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
@ManagedBean
public class MensagemMB {
     
    private String messagem;
 
    public String getMessagem() {
        return messagem;
    }
 
    public void setMessagem(String messagem) {
        this.messagem = messagem;
    }
     
    public void saveMessagem() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado com Sucesso", ""));
    }
     public void excluiMessagem() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Excluido com Sucesso", ""));
    }
     public void matriculaMessagem() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Matriculado com Sucesso", ""));
    }
}