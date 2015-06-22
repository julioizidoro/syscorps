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
@Table(name = "transferencia")
public class Transferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtransferencia")
    private Integer idtransferencia;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Size(max = 200)
    @Column(name = "motivo")
    private String motivo;
    @Size(max = 45)
    @Column(name = "tranferenciacol")
    private String tranferenciacol;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "turmanova", referencedColumnName = "idturma")
    @ManyToOne(optional = false)
    private Turma turma;
    @JoinColumn(name = "tumaatual", referencedColumnName = "idturma")
    @ManyToOne(optional = false)
    private Turma turma1;
    @JoinColumn(name = "matricula_idmatricula", referencedColumnName = "idmatricula")
    @ManyToOne(optional = false)
    private Matricula matricula;

    public Transferencia() {
    }

    public Transferencia(Integer idtransferencia) {
        this.idtransferencia = idtransferencia;
    }

    public Integer getIdtransferencia() {
        return idtransferencia;
    }

    public void setIdtransferencia(Integer idtransferencia) {
        this.idtransferencia = idtransferencia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getTranferenciacol() {
        return tranferenciacol;
    }

    public void setTranferenciacol(String tranferenciacol) {
        this.tranferenciacol = tranferenciacol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Turma getTurma1() {
        return turma1;
    }

    public void setTurma1(Turma turma1) {
        this.turma1 = turma1;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtransferencia != null ? idtransferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transferencia)) {
            return false;
        }
        Transferencia other = (Transferencia) object;
        if ((this.idtransferencia == null && other.idtransferencia != null) || (this.idtransferencia != null && !this.idtransferencia.equals(other.idtransferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.santecorps.model.Transferencia[ idtransferencia=" + idtransferencia + " ]";
    }
    
}
