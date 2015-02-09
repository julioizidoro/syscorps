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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "localtrabalho")
@NamedQueries({
    @NamedQuery(name = "Localtrabalho.findAll", query = "SELECT l FROM Localtrabalho l")})
public class Localtrabalho implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlocalTrabalho")
    private Integer idlocalTrabalho;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Size(max = 14)
    @Column(name = "foneComercial")
    private String foneComercial;
    @Size(max = 50)
    @Column(name = "cargo")
    private String cargo;
    @Size(max = 50)
    @Column(name = "ComprovanteRenda")
    private String comprovanteRenda;
    @Size(max = 50)
    @Column(name = "outrasRendas")
    private String outrasRendas;
    @JoinColumn(name = "aluno_idaluno", referencedColumnName = "idaluno")
    @ManyToOne(optional = false)
    private Aluno aluno;

    public Localtrabalho() {
    }

    public Localtrabalho(Integer idlocalTrabalho) {
        this.idlocalTrabalho = idlocalTrabalho;
    }

    public Integer getIdlocalTrabalho() {
        return idlocalTrabalho;
    }

    public void setIdlocalTrabalho(Integer idlocalTrabalho) {
        this.idlocalTrabalho = idlocalTrabalho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoneComercial() {
        return foneComercial;
    }

    public void setFoneComercial(String foneComercial) {
        this.foneComercial = foneComercial;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getComprovanteRenda() {
        return comprovanteRenda;
    }

    public void setComprovanteRenda(String comprovanteRenda) {
        this.comprovanteRenda = comprovanteRenda;
    }

    public String getOutrasRendas() {
        return outrasRendas;
    }

    public void setOutrasRendas(String outrasRendas) {
        this.outrasRendas = outrasRendas;
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
        hash += (idlocalTrabalho != null ? idlocalTrabalho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localtrabalho)) {
            return false;
        }
        Localtrabalho other = (Localtrabalho) object;
        if ((this.idlocalTrabalho == null && other.idlocalTrabalho != null) || (this.idlocalTrabalho != null && !this.idlocalTrabalho.equals(other.idlocalTrabalho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.santecorps.model.Localtrabalho[ idlocalTrabalho=" + idlocalTrabalho + " ]";
    }
    
}
