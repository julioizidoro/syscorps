/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "turma")
public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idturma")
    private Integer idturma;
    @Size(max = 30)
    @Column(name = "numero")
    private String numero;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Size(max = 50)
    @Column(name = "turno")
    private String turno;
    @Column(name = "datainicio")
    @Temporal(TemporalType.DATE)
    private Date datainicio;
    @Column(name = "datatermino")
    @Temporal(TemporalType.DATE)
    private Date datatermino;
    @Column(name = "segunda")
    private Boolean segunda;
    @Column(name = "terca")
    private Boolean terca;
    @Column(name = "quarta")
    private Boolean quarta;
    @Column(name = "quita")
    private Boolean quita;
    @Column(name = "sexta")
    private Boolean sexta;
    @Column(name = "sabado")
    private Boolean sabado;
    @Size(max = 5)
    @Column(name = "horarioinicio")
    private String horarioinicio;
    @Size(max = 5)
    @Column(name = "horaioiniciointervalo")
    private String horaioiniciointervalo;
    @Size(max = 5)
    @Column(name = "horarioterminointervalo")
    private String horarioterminointervalo;
    @Size(max = 5)
    @Column(name = "horariotermino")
    private String horariotermino;
    @Size(max = 100)
    @Column(name = "responsavel")
    private String responsavel;
    @Size(max = 1)
    @Column(name = "formada")
    private String formada;
    @Column(name = "dataformatura")
    @Temporal(TemporalType.DATE)
    private Date dataformatura;
    @Size(max = 100)
    @Column(name = "liderclasse")
    private String liderclasse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turma")
    private List<Gradeturma> gradeturmaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turma")
    private List<Matricula> matriculaList;
    @JoinColumn(name = "curso_idcurso", referencedColumnName = "idcurso")
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "unidade_idunidade", referencedColumnName = "idunidade")
    @ManyToOne(optional = false)
    private Unidade unidade;

    public Turma() {
    }

    public Turma(Integer idturma) {
        this.idturma = idturma;
    }

    public Integer getIdturma() {
        return idturma;
    }

    public void setIdturma(Integer idturma) {
        this.idturma = idturma;
    }

    public String getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatatermino() {
        return datatermino;
    }

    public String getFormada() {
        return formada;
    }

    public void setFormada(String formada) {
        this.formada = formada;
    }

    public Date getDataformatura() {
        return dataformatura;
    }

    public void setDataformatura(Date dataformatura) {
        this.dataformatura = dataformatura;
    }

    public void setDatatermino(Date datatermino) {
        this.datatermino = datatermino;
    }

    public Boolean getSegunda() {
        return segunda;
    }

    public void setSegunda(Boolean segunda) {
        this.segunda = segunda;
    }

    public Boolean getTerca() {
        return terca;
    }

    public void setTerca(Boolean terca) {
        this.terca = terca;
    }

    public Boolean getQuarta() {
        return quarta;
    }

    public void setQuarta(Boolean quarta) {
        this.quarta = quarta;
    }

    public Boolean getQuita() {
        return quita;
    }

    public void setQuita(Boolean quita) {
        this.quita = quita;
    }

    public Boolean getSexta() {
        return sexta;
    }

    public void setSexta(Boolean sexta) {
        this.sexta = sexta;
    }

    public Boolean getSabado() {
        return sabado;
    }

    public void setSabado(Boolean sabado) {
        this.sabado = sabado;
    }

    public String getHorarioinicio() {
        return horarioinicio;
    }

    public void setHorarioinicio(String horarioinicio) {
        this.horarioinicio = horarioinicio;
    }

    public String getHoraioiniciointervalo() {
        return horaioiniciointervalo;
    }

    public void setHoraioiniciointervalo(String horaioiniciointervalo) {
        this.horaioiniciointervalo = horaioiniciointervalo;
    }

    public String getHorarioterminointervalo() {
        return horarioterminointervalo;
    }

    public void setHorarioterminointervalo(String horarioterminointervalo) {
        this.horarioterminointervalo = horarioterminointervalo;
    }

    public String getHorariotermino() {
        return horariotermino;
    }

    public void setHorariotermino(String horariotermino) {
        this.horariotermino = horariotermino;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getLiderclasse() {
        return liderclasse;
    }

    public void setLiderclasse(String liderclasse) {
        this.liderclasse = liderclasse;
    }

    public List<Gradeturma> getGradeturmaList() {
        return gradeturmaList;
    }

    public void setGradeturmaList(List<Gradeturma> gradeturmaList) {
        this.gradeturmaList = gradeturmaList;
    }

    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idturma != null ? idturma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turma)) {
            return false;
        }
        Turma other = (Turma) object;
        if ((this.idturma == null && other.idturma != null) || (this.idturma != null && !this.idturma.equals(other.idturma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNumero() + " - " + getNome();
    }
}
