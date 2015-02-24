/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.model;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "disciplina")
public class Disciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddisciplina")
    private Integer iddisciplina;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Size(max = 10)
    @Column(name = "cargahoraria")
    private String cargahoraria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private Collection<Gradeturma> gradeturmaCollection;

    public Disciplina() {
    }

    public Disciplina(Integer iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    public Integer getIddisciplina() {
        return iddisciplina;
    }

    public void setIddisciplina(Integer iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(String cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    public Collection<Gradeturma> getGradeturmaCollection() {
        return gradeturmaCollection;
    }

    public void setGradeturmaCollection(Collection<Gradeturma> gradeturmaCollection) {
        this.gradeturmaCollection = gradeturmaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddisciplina != null ? iddisciplina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.iddisciplina == null && other.iddisciplina != null) || (this.iddisciplina != null && !this.iddisciplina.equals(other.iddisciplina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.santecorps.model.Disciplina[ iddisciplina=" + iddisciplina + " ]";
    }
    
}
