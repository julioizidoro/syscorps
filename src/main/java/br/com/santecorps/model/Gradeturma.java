/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santecorps.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "gradeturma")
public class Gradeturma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgradeturma")
    private Integer idgradeturma;
    @JoinColumn(name = "disciplina_iddisciplina", referencedColumnName = "iddisciplina")
    @ManyToOne(optional = false)
    private Disciplina disciplina;
    @JoinColumn(name = "professor_idprofessor", referencedColumnName = "idprofessor")
    @ManyToOne(optional = false)
    private Professor professor;
    @JoinColumn(name = "turma_idturma", referencedColumnName = "idturma")
    @ManyToOne(optional = false)
    private Turma turma;

    public Gradeturma() {
    }

    public Gradeturma(Integer idgradeturma) {
        this.idgradeturma = idgradeturma;
    }

    public Integer getIdgradeturma() {
        return idgradeturma;
    }

    public void setIdgradeturma(Integer idgradeturma) {
        this.idgradeturma = idgradeturma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
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
        hash += (idgradeturma != null ? idgradeturma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gradeturma)) {
            return false;
        }
        Gradeturma other = (Gradeturma) object;
        if ((this.idgradeturma == null && other.idgradeturma != null) || (this.idgradeturma != null && !this.idgradeturma.equals(other.idgradeturma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.santecorps.model.Gradeturma[ idgradeturma=" + idgradeturma + " ]";
    }
    
}
