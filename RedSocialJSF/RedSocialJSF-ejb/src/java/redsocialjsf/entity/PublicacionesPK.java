/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author tmgrm
 */
@Embeddable
public class PublicacionesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "post_id")
    private int postId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grupo_id")
    private int grupoId;

    public PublicacionesPK() {
    }

    public PublicacionesPK(int postId, int grupoId) {
        this.postId = postId;
        this.grupoId = grupoId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(int grupoId) {
        this.grupoId = grupoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) postId;
        hash += (int) grupoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublicacionesPK)) {
            return false;
        }
        PublicacionesPK other = (PublicacionesPK) object;
        if (this.postId != other.postId) {
            return false;
        }
        if (this.grupoId != other.grupoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "redsocialjsf.entity.PublicacionesPK[ postId=" + postId + ", grupoId=" + grupoId + " ]";
    }
    
}
