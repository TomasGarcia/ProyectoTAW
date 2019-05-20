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
@Table(name = "amistad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amistad.findAll", query = "SELECT a FROM Amistad a")
    , @NamedQuery(name = "Amistad.findByUsuarioId", query = "SELECT a FROM Amistad a WHERE a.amistadPK.usuarioId = :usuarioId")
    , @NamedQuery(name = "Amistad.findByUsuarioId1", query = "SELECT a FROM Amistad a WHERE a.amistadPK.usuarioId1 = :usuarioId1")})
public class Amistad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AmistadPK amistadPK;
    @JoinColumns({
        @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
        , @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Usuario usuario;
    @JoinColumns({
        @JoinColumn(name = "usuario_id1", referencedColumnName = "id", insertable = false, updatable = false)
        , @JoinColumn(name = "usuario_id1", referencedColumnName = "id", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Usuario usuario1;

    public Amistad() {
    }

    public Amistad(AmistadPK amistadPK) {
        this.amistadPK = amistadPK;
    }

    public Amistad(int usuarioId, int usuarioId1) {
        this.amistadPK = new AmistadPK(usuarioId, usuarioId1);
    }

    public AmistadPK getAmistadPK() {
        return amistadPK;
    }

    public void setAmistadPK(AmistadPK amistadPK) {
        this.amistadPK = amistadPK;
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
        hash += (amistadPK != null ? amistadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amistad)) {
            return false;
        }
        Amistad other = (Amistad) object;
        if ((this.amistadPK == null && other.amistadPK != null) || (this.amistadPK != null && !this.amistadPK.equals(other.amistadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "redsocialjsf.entity.Amistad[ amistadPK=" + amistadPK + " ]";
    }
    
}
