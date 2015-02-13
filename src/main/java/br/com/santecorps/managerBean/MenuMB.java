/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.managerBean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Wolverine
 */
@Named
@SessionScoped
public class MenuMB implements Serializable{
    
    public String cadastroCursos(){
        return "conscursos";
    }
    
    public String cadastroTurmas(){
        return "consturmas";
    }
    
    public String cadastroAlunos(){
        return "consaluno";
    }
    
    public String cadastroProfessor(){
        return "consprofessor";
    }
    
    public String cadastroDisciplina(){
        return "consdisciplina";
    }
     
     public String inicio(){
         return "index";
     }
     public String matricula(){
         return "matricula";
     }
}
