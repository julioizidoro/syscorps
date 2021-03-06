/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.managerBean;

import br.com.santecorps.model.Aluno;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Wolverine
 */
@Named
@SessionScoped
public class MenuMB implements Serializable{
    
    @Inject
    private CadastroAlunoMB cadastroAlunoMB;
    
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
     
    public String cadastroGrade(){
        return "consgrade";
    }
     public String inicio(){
         return "inicial";
     }
     public String matricula(){
         cadastroAlunoMB.setAluno(new Aluno());
         return "matricula";
     }
     public String rematricula(){
         return "rematricula";
     }
      public String aniversariantes(){
        return "aniversariantes";
    }
      public String formar(){
        return "formarturmas";
    }
      public String listarAlunos(){
          return "listarAlunos";
      }
}
