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
import javax.persistence.Transient;
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "matricula")
public class Matricula implements Serializable {
    @Column(name = "rematricula")
    private Boolean rematricula;
    @Size(max = 15)
    @Column(name = "situacao")
    private String situacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matricula")
    private List<Transferencia> transferenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matricula")
    private List<Cancelados> canceladosList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmatricula")
    private Integer idmatricula;
    @Size(max = 20)
    @Column(name = "tipopagamento")
    private String tipopagamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valortotal")
    private Float valortotal;
    @Column(name = "valorentrada")
    private Float valorentrada;
    @Column(name = "dataentrada")
    @Temporal(TemporalType.DATE)
    private Date dataentrada;
    @Column(name = "numeroparcelas")
    private Integer numeroparcelas;
    @Column(name = "valorparcela")
    private Float valorparcela;
    @Column(name = "datavencimentoparcela")
    @Temporal(TemporalType.DATE)
    private Date datavencimentoparcela;
    @JoinColumn(name = "aluno_idaluno", referencedColumnName = "idaluno")
    @ManyToOne(optional = false)
    private Aluno aluno;
    @JoinColumn(name = "turma_idturma", referencedColumnName = "idturma")
    @ManyToOne(optional = false)
    private Turma turma;    
    @Column(name = "datamatricula")
    @Temporal(TemporalType.DATE)
    private Date datamatricula;
    @Column(name = "datarematricula01")
    @Temporal(TemporalType.DATE)
    private Date datarematricula01;
    @Column(name = "datarematricula02")
    @Temporal(TemporalType.DATE)
    private Date datarematricula02;
    @Transient
    private boolean selecionado;

    
    public Matricula() {
    }

    public Matricula(Integer idmatricula) {
        this.idmatricula = idmatricula;
    }

    public Integer getIdmatricula() {
        return idmatricula;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    public void setIdmatricula(Integer idmatricula) {
        this.idmatricula = idmatricula;
    }

    public Date getDatamatricula() {
        return datamatricula;
    }

    public void setDatamatricula(Date datamatricula) {
        this.datamatricula = datamatricula;
    }

    public Date getDatarematricula01() {
        return datarematricula01;
    }

    public void setDatarematricula01(Date datarematricula01) {
        this.datarematricula01 = datarematricula01;
    }

    public Date getDatarematricula02() {
        return datarematricula02;
    }

    public void setDatarematricula02(Date datarematricula02) {
        this.datarematricula02 = datarematricula02;
    }

    public Float getValortotal() {
        return valortotal;
    }

    public void setValortotal(Float valortotal) {
        this.valortotal = valortotal;
    }

    public Float getValorentrada() {
        return valorentrada;
    }

    public String getTipopagamento() {
        return tipopagamento;
    }

    public void setTipopagamento(String tipopagamento) {
        this.tipopagamento = tipopagamento;
    }

    public void setValorentrada(Float valorentrada) {
        this.valorentrada = valorentrada;
    }

    public Date getDataentrada() {
        return dataentrada;
    }

    public void setDataentrada(Date dataentrada) {
        this.dataentrada = dataentrada;
    }

    public Integer getNumeroparcelas() {
        return numeroparcelas;
    }

    public void setNumeroparcelas(Integer numeroparcelas) {
        this.numeroparcelas = numeroparcelas;
    }

    public Float getValorparcela() {
        return valorparcela;
    }

    public void setValorparcela(Float valorparcela) {
        this.valorparcela = valorparcela;
    }

    public Date getDatavencimentoparcela() {
        return datavencimentoparcela;
    }

    public void setDatavencimentoparcela(Date datavencimentoparcela) {
        this.datavencimentoparcela = datavencimentoparcela;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }




    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmatricula != null ? idmatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.idmatricula == null && other.idmatricula != null) || (this.idmatricula != null && !this.idmatricula.equals(other.idmatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.santecorps.model.Matricula[ idmatricula=" + idmatricula + " ]";
    }

    public Boolean getRematricula() {
        return rematricula;
    }

    public void setRematricula(Boolean rematricula) {
        this.rematricula = rematricula;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public List<Transferencia> getTransferenciaList() {
        return transferenciaList;
    }

    public void setTransferenciaList(List<Transferencia> transferenciaList) {
        this.transferenciaList = transferenciaList;
    }

    public List<Cancelados> getCanceladosList() {
        return canceladosList;
    }

    public void setCanceladosList(List<Cancelados> canceladosList) {
        this.canceladosList = canceladosList;
    }
    
}
