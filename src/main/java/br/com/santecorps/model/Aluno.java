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
@Table(name = "aluno")
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaluno")
    private Integer idaluno;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "rg")
    private String rg;
    @Size(max = 14)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 100)
    @Column(name = "nomeMae")
    private String nomeMae;
    @Size(max = 100)
    @Column(name = "nomePai")
    private String nomePai;
    @Column(name = "dataNascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Size(max = 50)
    @Column(name = "cidadeNascimento")
    private String cidadeNascimento;
    @Size(max = 2)
    @Column(name = "estadoNascimento")
    private String estadoNascimento;
    @Size(max = 50)
    @Column(name = "profissao")
    private String profissao;
    @Size(max = 50)
    @Column(name = "nascionalidade")
    private String nascionalidade;
    @Size(max = 50)
    @Column(name = "estadoCivil")
    private String estadoCivil;
    @Size(max = 20)
    @Column(name = "tipoLogradouro")
    private String tipoLogradouro;
    @Size(max = 100)
    @Column(name = "logradouro")
    private String logradouro;
    @Size(max = 20)
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
    @Size(max = 14)
    @Column(name = "foneFixo")
    private String foneFixo;
    @Size(max = 14)
    @Column(name = "foneCelular")
    private String foneCelular;
    @Size(max = 100)
    @Column(name = "referenciaPessoal")
    private String referenciaPessoal;
    @Size(max = 14)
    @Column(name = "foneReferenciaPessoal")
    private String foneReferenciaPessoal;
    @Size(max = 3)
    @Column(name = "trabalha")
    private String trabalha;
    @JoinColumn(name = "unidade_idunidade", referencedColumnName = "idunidade")
    @ManyToOne(optional = false)
    private Unidade unidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private List<Localtrabalho> localtrabalhoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private List<Matricula> matriculaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private List<Conjuge> conjugeList;
    @Column(name = "selecionado")
    private boolean selecionado;
    @Column(name = "mes")
    private int mes;

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public Aluno() {
    }

    public Aluno(Integer idaluno) {
        this.idaluno = idaluno;
    }

    public Integer getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(Integer idaluno) {
        this.idaluno = idaluno;
    }

    public String getNome() {
        return nome;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    public String getTrabalha() {
        return trabalha;
    }

    public void setTrabalha(String trabalha) {
        this.trabalha = trabalha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    public void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }

    public String getEstadoNascimento() {
        return estadoNascimento;
    }

    public void setEstadoNascimento(String estadoNascimento) {
        this.estadoNascimento = estadoNascimento;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getNascionalidade() {
        return nascionalidade;
    }

    public void setNascionalidade(String nascionalidade) {
        this.nascionalidade = nascionalidade;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
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

    public String getReferenciaPessoal() {
        return referenciaPessoal;
    }

    public void setReferenciaPessoal(String referenciaPessoal) {
        this.referenciaPessoal = referenciaPessoal;
    }

    public String getFoneReferenciaPessoal() {
        return foneReferenciaPessoal;
    }

    public void setFoneReferenciaPessoal(String foneReferenciaPessoal) {
        this.foneReferenciaPessoal = foneReferenciaPessoal;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public List<Localtrabalho> getLocaltrabalhoList() {
        return localtrabalhoList;
    }

    public void setLocaltrabalhoList(List<Localtrabalho> localtrabalhoList) {
        this.localtrabalhoList = localtrabalhoList;
    }

    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }

    public List<Conjuge> getConjugeList() {
        return conjugeList;
    }

    public void setConjugeList(List<Conjuge> conjugeList) {
        this.conjugeList = conjugeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaluno != null ? idaluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.idaluno == null && other.idaluno != null) || (this.idaluno != null && !this.idaluno.equals(other.idaluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.santecorps.model.Aluno[ idaluno=" + idaluno + " ]";
    }
    
}
