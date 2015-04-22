package br.com.santecorps.managerBean;

import br.com.santecorps.controller.UsuarioController;
import br.com.santecorps.model.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("UsuarioLogadoMB")
@SessionScoped
public class UsuarioLogadoMB implements Serializable{
    
    private Usuario usuario;

    public UsuarioLogadoMB() {
    }

    public Usuario getUsuario() {
        if (usuario==null){
          usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String validarUsuario(){
        if ((usuario.getLogin()!=null) && (usuario.getSenha()==null)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Login Invalido."));
        }else{
            UsuarioController  usuarioController = new UsuarioController();
            usuario = usuarioController.consultar(usuario.getLogin(), usuario.getSenha());
            if (usuario==null){
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Acesso Negado."));
            }else {
                return "inicial";
            }
        }
        usuario = new Usuario();
        return "";
    }
     public void erroLogin(String mensagem) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(mensagem, ""));
    }
    
    
    
}
