/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "unidade")
public class Unidade implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidade")
    private List<Usuario> usuarioList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idunidade")
    private Integer idunidade;
    @Size(max = 100)
    @Column(name = "razaosocial")
    private String razaosocial;
    @Size(max = 100)
    @Column(name = "nomefantasia")
    private String nomefantasia;
    @Size(max = 50)
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 2)
    @Column(name = "estado")
    private String estado;
    @Column(name = "numeromatriculainicial")
    private int numeromatriculainicial;
    @Column(name = "numeromatriculafinal")
    private int numeromatriculafinal;

    public Unidade() {
    }

    public Unidade(Integer idunidade) {
        this.idunidade = idunidade;
    }

    public Integer getIdunidade() {
        return idunidade;
    }

    public void setIdunidade(Integer idunidade) {
        this.idunidade = idunidade;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
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

    public int getNumeromatriculainicial() {
        return numeromatriculainicial;
    }

    public void setNumeromatriculainicial(int numeromatriculainicial) {
        this.numeromatriculainicial = numeromatriculainicial;
    }

    public int getNumeromatriculafinal() {
        return numeromatriculafinal;
    }

    public void setNumeromatriculafinal(int numeromatriculafinal) {
        this.numeromatriculafinal = numeromatriculafinal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idunidade != null ? idunidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidade)) {
            return false;
        }
        Unidade other = (Unidade) object;
        if ((this.idunidade == null && other.idunidade != null) || (this.idunidade != null && !this.idunidade.equals(other.idunidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.santecorps.model.Unidade[ idunidade=" + idunidade + " ]";
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
    
}
