package br.com.santecorps.managerBean;

import br.com.santecorps.facade.MatriculaFacade;
import br.com.santecorps.facade.TurmaFacade;
import br.com.santecorps.model.Matricula;
import br.com.santecorps.model.Turma;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class RematriculaMB  implements Serializable{
      
      @Inject
      private UsuarioLogadoMB usuarioLogadoMB;
      private List<Matricula> listaMatricula;
      private Matricula matricula;
      private List<Turma> listaTurma;
      private String idTurma;
      
    public RematriculaMB() {
        gerarListaTurma();
    }

    public List<Turma> getListaTurma() {
        return listaTurma;
    }

    public String getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(String idTurma) {
        this.idTurma = idTurma;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public void setListaTurma(List<Turma> listaTurma) {
        this.listaTurma = listaTurma;
    }

    public List<Matricula> getListaMatricula() {
        return listaMatricula;
    }

    public void setListaMatricula(List<Matricula> listaMatricula) {
        this.listaMatricula = listaMatricula;
    }

    

    public void carregarListaMatricula() {
        if (idTurma != null) {
            MatriculaFacade matriculaFacade = new MatriculaFacade();
            listaMatricula = matriculaFacade.listar(Integer.parseInt(idTurma));
            if (listaMatricula == null) {
                listaMatricula = new ArrayList<Matricula>();
            }
        }
    }
    
    public void gerarListaTurma() {
        TurmaFacade turmaFacade = new TurmaFacade();
        listaTurma = turmaFacade.listar("", usuarioLogadoMB.getUsuario().getUnidade().getIdunidade());
        if (listaTurma == null) {
            listaTurma = new ArrayList<Turma>();
        }
    }
    
    public String efetivar(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        int idMatricula =  Integer.parseInt(params.get("id_matricula"));
        MatriculaFacade matriculaFacade = new MatriculaFacade();
        matricula = matriculaFacade.getMatricula(idMatricula);
        if (matricula!=null){
            if (matricula.getDatarematricula01()==null){
                matricula.setDatarematricula01(new Date());
            }else if (matricula.getDatarematricula02()==null){
                matricula.setDatarematricula02(new Date());
            }
            
            return "cadrematricula";
        }
        return "";
    }
    
    public String salvar(){
        MatriculaFacade matriculaFacade = new MatriculaFacade();
        matriculaFacade.salvar(matricula);
        carregarListaMatricula();
        return "rematricula";
    }
    
    public String cancelar(){
        return "rematricula";
    }
}
