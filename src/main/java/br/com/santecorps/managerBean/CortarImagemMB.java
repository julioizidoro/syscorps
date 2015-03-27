
package br.com.santecorps.managerBean;

import java.io.File;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import org.primefaces.model.CroppedImage;
 
@ManagedBean
@ViewScoped
public class CortarImagemMB {
        private CroppedImage croppedImage;
     
    private String novaImagem;
 
    public CroppedImage getCroppedImage() {
        return croppedImage;
    }
 
    public void setCroppedImage(CroppedImage croppedImage) {
        this.croppedImage = croppedImage;
    }
 
    public void crop() {
        if(croppedImage == null) {
            return;
        }
         
        setNovaImagem(getRandomImageName());
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
         String newFileName = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "img" +
                                    File.separator + novaImagem + ".jpeg";
        
      
        FileImageOutputStream imageOutput;
        try {
            imageOutput = new FileImageOutputStream(new File(newFileName));
            imageOutput.write(croppedImage.getBytes(), 0, croppedImage.getBytes().length);
            imageOutput.close();
        } catch (Exception e) {
        }
         
    }
     
    private String getRandomImageName() {
        int i = (int) (Math.random() * 100000);
         
        return String.valueOf(i);
    }
     
    public String getNovaImagem() {
        return novaImagem;
    }
 
    public void setNovaImagem(String novaImagem) {
        this.novaImagem = novaImagem;
    }
}

