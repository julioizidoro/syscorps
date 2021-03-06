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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "conjuge")
public class Conjuge implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconjuge")
    private Integer idconjuge;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Size(max = 50)
    @Column(name = "rg")
    private String rg;
    @Size(max = 14)
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "dataNascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Size(max = 50)
    @Column(name = "profissao")
    private String profissao;
    @Size(max = 30)
    @Column(name = "tipoLogradouro")
    private String tipoLogradouro;
    @Size(max = 100)
    @Column(name = "logradouro")
    private String logradouro;
    @Size(max = 30)
    @Column(name = "numero")
    private String numero;
    @Size(max = 100)
    @Column(name = "complemento")
    private String complemento;
    @Size(max = 50)
    @Column(name = "bairro")
    private String bairro;
    @Size(max = 50)
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 2)
    @Column(name = "estado")
    private String estado;
    @Size(max = 9)
    @Column(name = "cep")
    private String cep;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rendaMensal")
    private Float rendaMensal;
    @Size(max = 14)
    @Column(name = "foneFixo")
    private String foneFixo;
    @Size(max = 14)
    @Column(name = "foneCelular")
    private String foneCelular;
    @JoinColumn(name = "aluno_idaluno", referencedColumnName = "idaluno")
    @ManyToOne(optional = false)
    private Aluno aluno;

    public Conjuge() {
    }

    public Conjuge(Integer idconjuge) {
        this.idconjuge = idconjuge;
    }

    public Integer getIdconjuge() {
        return idconjuge;
    }

    public void setIdconjuge(Integer idconjuge) {
        this.idconjuge = idconjuge;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Float getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(Float rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public String getFoneFixo() {
        return foneFixo;
    }

    public void setFoneFixo(String foneFixo) {
        this.foneFixo = foneFixo;
    }

    public String getFoneCelular() {
        return foneCelular;
    }

    public void setFoneCelular(String foneCelular) {
        this.foneCelular = foneCelular;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconjuge != null ? idconjuge.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conjuge)) {
            return false;
        }
        Conjuge other = (Conjuge) object;
        if ((this.idconjuge == null && other.idconjuge != null) || (this.idconjuge != null && !this.idconjuge.equals(other.idconjuge))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.santecorps.model.Conjuge[ idconjuge=" + idconjuge + " ]";
    }
    
}
