/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.converter;

import br.com.santecorps.facade.CursoFacade;
import br.com.santecorps.model.Curso;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Kamila
 */
@FacesConverter(forClass=Curso.class)
public class CursoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        CursoFacade cursoFacade = new CursoFacade();
        int idCurso = Integer.parseInt(value);
        Curso curso = cursoFacade.getCurso(idCurso);
        return curso;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(value);
    }
    
}
