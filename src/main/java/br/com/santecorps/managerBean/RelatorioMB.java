package br.com.santecorps.managerBean;

import br.com.santecorps.Relatorio.ExecutorRelatorio;
import java.awt.Image;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

@Named("RelatorioMB")
@SessionScoped
public class RelatorioMB implements Serializable{
    public void gerarRelatorioAluno(HttpServletRequest request, HttpServletResponse response){
       
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String relatorio = servletContext.getRealPath("relatorios/relatorioAluno.jasper");
        String localLogo = "/resources" + File.separator + "img" + File.separator + "logo_corps.jng";
        
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition","inline; filename=\"arquivo.pdf\"");
       
        Map parameters = new HashMap();
        Image logo = new ImageIcon(localLogo).getImage();
        parameters.put("logo", logo);
        
        ExecutorRelatorio executor = new ExecutorRelatorio("/relatorios/relatorioAluno.jasper",
        response, parameters, "Aluno.pdf");
        
         FacesContext facesContext = FacesContext.getCurrentInstance();
        if (executor.isRelatorioGerado()) {
            facesContext.responseComplete();
        } else {
            System.out.println("Erro");
        }
    }
    
}

