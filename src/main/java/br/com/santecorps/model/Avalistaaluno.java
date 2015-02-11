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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "avalistaaluno")
public class Avalistaaluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idavalistaAluno")
    private Integer idavalistaAluno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avalistaaluno")
    private List<Aluno> alunoList;
    @JoinColumn(name = "avalista_idavalista", referencedColumnName = "idavalista")
    @ManyToOne(optional = false)
    private Avalista avalista;

    public Avalistaaluno() {
    }

    public Avalistaaluno(Integer idavalistaAluno) {
        this.idavalistaAluno = idavalistaAluno;
    }

    public Integer getIdavalistaAluno() {
        return idavalistaAluno;
    }

    public void setIdavalistaAluno(Integer idavalistaAluno) {
        this.idavalistaAluno = idavalistaAluno;
    }

    public List<Aluno> getAlunoList() {
        return alunoList;
    }

    public void setAlunoList(List<Aluno> alunoList) {
        this.alunoList = alunoList;
    }

    public Avalista getAvalista() {
        return avalista;
    }

    public void setAvalista(Avalista avalista) {
        this.avalista = avalista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idavalistaAluno != null ? idavalistaAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avalistaaluno)) {
            return false;
        }
        Avalistaaluno other = (Avalistaaluno) object;
        if ((this.idavalistaAluno == null && other.idavalistaAluno != null) || (this.idavalistaAluno != null && !this.idavalistaAluno.equals(other.idavalistaAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.santecorps.model.Avalistaaluno[ idavalistaAluno=" + idavalistaAluno + " ]";
    }
    
}
