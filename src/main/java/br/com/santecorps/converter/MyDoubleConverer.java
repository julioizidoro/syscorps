/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.converter;

import java.lang.annotation.Annotation;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;


/**
 *
 * @author Wolverine
 */
public class MyDoubleConverer  implements Converter{
    
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String valorTela) throws ConverterException {  
  
        if(valorTela == null || valorTela.toString().trim().equals("")){  
            return 0.0d;  
  
        } else {  
            valorTela = valorTela.replaceAll(Pattern.quote("."), "");  
  
            try{  
                NumberFormat nf = NumberFormat.getInstance();  
                nf.setMaximumFractionDigits(2);  
  
                return nf.parse(valorTela.replace(",", ".")).doubleValue();  
  
            }catch (Exception e) {  
                return 0.0d;  
            }  
        }  
    }  
  
    public String getAsString(FacesContext arg0, UIComponent arg1, Object valorTela) throws ConverterException {  
  
        if(valorTela == null || valorTela.toString().trim().equals("")){  
            return "0,00";  
  
        } else {  
            NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));  
            nf.setMaximumFractionDigits(2);  
  
            return nf.format(Double.valueOf(valorTela.toString()));  
        }  
    }
    
}
