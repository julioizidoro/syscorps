
package br.com.santecorps.managerBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import org.primefaces.model.CroppedImage;
 
@ManagedBean
@RequestScoped
public class testeMB implements Serializable{
   private CroppedImage cortarImagem;
     
    private String novaImagem;
 
    public CroppedImage getCroppedImage() {
        return cortarImagem;
    }
 
    public void setCroppedImage(CroppedImage cortarImagem) {
        this.cortarImagem = cortarImagem;
    }
 
    public void cortar() {
        if(cortarImagem == null) {
            return;
        }
        
        setNovaImagemNome(getRandomImageName());

        //direcionando local para salvar   
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String novoNome = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "img" +
                                    File.separator + getNovaImagemNome()+ ".jpg";
      
        FileImageOutputStream imageOutput;
        try {
            imageOutput = new FileImageOutputStream(new File(novoNome));
            imageOutput.write(cortarImagem.getBytes(), 0, cortarImagem.getBytes().length);
            imageOutput.close();
       } catch (FileNotFoundException e) {
        } catch (IOException e) {
         
        }
    }
    private String getRandomImageName() {
        int i = (int) (Math.random() * 100000);
         
        return String.valueOf(i);
    }
     
    public String getNovaImagemNome() {
        return novaImagem;
    }
 
    public void setNovaImagemNome(String novaImagem) {
        this.novaImagem = novaImagem;
    }
}
