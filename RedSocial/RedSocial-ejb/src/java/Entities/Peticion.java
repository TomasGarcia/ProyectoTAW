/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tmgrm
 */
@Entity
@Table(name = "peticion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peticion.findAll", query = "SELECT p FROM Peticion p")
    , @NamedQuery(name = "Peticion.findByFecha", query = "SELECT p FROM Peticion p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Peticion.findByConfirmada", query = "SELECT p FROM Peticion p WHERE p.confirmada = :confirmada")
    , @NamedQuery(name = "Peticion.findByUsuarioId", query = "SELECT p FROM Peticion p WHERE p.peticionPK.usuarioId = :usuarioId")
    , @NamedQuery(name = "Peticion.findByUsuarioId1", query = "SELECT p FROM Peticion p WHERE p.peticionPK.usuarioId1 = :usuarioId1")})
public class Peticion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PeticionPK peticionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "confirmada")
    private Character confirmada;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "usuario_id1", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario1;

    public Peticion() {
    }

    public Peticion(PeticionPK peticionPK) {
        this.peticionPK = peticionPK;
    }

    public Peticion(PeticionPK peticionPK, Date fecha, Character confirmada) {
        this.peticionPK = peticionPK;
        this.fecha = fecha;
        this.confirmada = confirmada;
    }

    public Peticion(int usuarioId, int usuarioId1) {
        this.peticionPK = new PeticionPK(usuarioId, usuarioId1);
    }

    public PeticionPK getPeticionPK() {
        return peticionPK;
    }

    public void setPeticionPK(PeticionPK peticionPK) {
        this.peticionPK = peticionPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Character getConfirmada() {
        return confirmada;
    }

    public void setConfirmada(Character confirmada) {
        this.confirmada = confirmada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peticionPK != null ? peticionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peticion)) {
            return false;
        }
        Peticion other = (Peticion) object;
        if ((this.peticionPK == null && other.peticionPK != null) || (this.peticionPK != null && !this.peticionPK.equals(other.peticionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Peticion[ peticionPK=" + peticionPK + " ]";
    }
    
}
