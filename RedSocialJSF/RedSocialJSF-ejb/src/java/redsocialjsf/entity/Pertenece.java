/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tmgrm
 */
@Entity
@Table(name = "pertenece")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pertenece.findAll", query = "SELECT p FROM Pertenece p")
    , @NamedQuery(name = "Pertenece.findByUsuarioId", query = "SELECT p FROM Pertenece p WHERE p.pertenecePK.usuarioId = :usuarioId")
    , @NamedQuery(name = "Pertenece.findByGrupoId", query = "SELECT p FROM Pertenece p WHERE p.pertenecePK.grupoId = :grupoId")})
public class Pertenece implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PertenecePK pertenecePK;
    @JoinColumns({
        @JoinColumn(name = "grupo_id", referencedColumnName = "id", insertable = false, updatable = false)
        , @JoinColumn(name = "grupo_id", referencedColumnName = "id", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Grupo grupo;
    @JoinColumns({
        @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
        , @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Usuario usuario;

    public Pertenece() {
    }

    public Pertenece(PertenecePK pertenecePK) {
        this.pertenecePK = pertenecePK;
    }

    public Pertenece(int usuarioId, int grupoId) {
        this.pertenecePK = new PertenecePK(usuarioId, grupoId);
    }

    public PertenecePK getPertenecePK() {
        return pertenecePK;
    }

    public void setPertenecePK(PertenecePK pertenecePK) {
        this.pertenecePK = pertenecePK;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pertenecePK != null ? pertenecePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pertenece)) {
            return false;
        }
        Pertenece other = (Pertenece) object;
        if ((this.pertenecePK == null && other.pertenecePK != null) || (this.pertenecePK != null && !this.pertenecePK.equals(other.pertenecePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "redsocialjsf.entity.Pertenece[ pertenecePK=" + pertenecePK + " ]";
    }
    
}
