/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "matricula")
public class Matricula implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
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

    public Matricula() {
    }

    public Matricula(Float valortotal) {
        this.valortotal = valortotal;
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
        hash += (valortotal != null ? valortotal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.valortotal == null && other.valortotal != null) || (this.valortotal != null && !this.valortotal.equals(other.valortotal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.santecorps.model.Matricula[ valortotal=" + valortotal + " ]";
    }
    
}
