package br.com.santecorps.managerBean;

import br.com.santecorps.facade.AlunoFacade;
import br.com.santecorps.model.Aluno;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class RematriculaMB  implements Serializable{
      
      private String nomeAluno;
      private List<Aluno> listaAlunos;
      
       public RematriculaMB() {
        CarregarLitaAluno();
      }
      
        public List<Aluno> getListaAlunos() {
        if (listaAlunos.size()==0){
            CarregarLitaAluno();
        }
        return listaAlunos;
        }

        public void setListaAlunos(List<Aluno> listaAlunos) {
            this.listaAlunos = listaAlunos;
        }
       public String getNomeAluno() {
        return nomeAluno;
        }

        public void setNomeAluno(String nomeAluno) {
            this.nomeAluno = nomeAluno;
        }

      
      public void CarregarLitaAluno(){
        if (nomeAluno==null){
            nomeAluno = "";
        }
        AlunoFacade alunoFacade = new AlunoFacade();
        listaAlunos = alunoFacade.listar(nomeAluno);
        if (listaAlunos==null){
            listaAlunos = new ArrayList<Aluno>();
        }
    }
    
}
