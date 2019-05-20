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
@Table(name = "publicaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publicaciones.findAll", query = "SELECT p FROM Publicaciones p")
    , @NamedQuery(name = "Publicaciones.findByPostId", query = "SELECT p FROM Publicaciones p WHERE p.publicacionesPK.postId = :postId")
    , @NamedQuery(name = "Publicaciones.findByGrupoId", query = "SELECT p FROM Publicaciones p WHERE p.publicacionesPK.grupoId = :grupoId")})
public class Publicaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PublicacionesPK publicacionesPK;
    @JoinColumns({
        @JoinColumn(name = "grupo_id", referencedColumnName = "id", insertable = false, updatable = false)
        , @JoinColumn(name = "grupo_id", referencedColumnName = "id", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Grupo grupo;
    @JoinColumns({
        @JoinColumn(name = "post_id", referencedColumnName = "id", insertable = false, updatable = false)
        , @JoinColumn(name = "post_id", referencedColumnName = "id", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Post post;

    public Publicaciones() {
    }

    public Publicaciones(PublicacionesPK publicacionesPK) {
        this.publicacionesPK = publicacionesPK;
    }

    public Publicaciones(int postId, int grupoId) {
        this.publicacionesPK = new PublicacionesPK(postId, grupoId);
    }

    public PublicacionesPK getPublicacionesPK() {
        return publicacionesPK;
    }

    public void setPublicacionesPK(PublicacionesPK publicacionesPK) {
        this.publicacionesPK = publicacionesPK;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (publicacionesPK != null ? publicacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publicaciones)) {
            return false;
        }
        Publicaciones other = (Publicaciones) object;
        if ((this.publicacionesPK == null && other.publicacionesPK != null) || (this.publicacionesPK != null && !this.publicacionesPK.equals(other.publicacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "redsocialjsf.entity.Publicaciones[ publicacionesPK=" + publicacionesPK + " ]";
    }
    
}
