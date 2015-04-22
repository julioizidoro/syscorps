package br.com.santecorps.managerBean;

import br.com.santecorps.model.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("UsuarioLogadoMB")
@SessionScoped
public class UsuarioLogadoMB implements Serializable{
    
    private Usuario usuario;

    public UsuarioLogadoMB() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    
    
}
