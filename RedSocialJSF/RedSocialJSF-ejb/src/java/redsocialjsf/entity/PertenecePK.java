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
public class PertenecePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_id")
    private int usuarioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grupo_id")
    private int grupoId;

    public PertenecePK() {
    }

    public PertenecePK(int usuarioId, int grupoId) {
        this.usuarioId = usuarioId;
        this.grupoId = grupoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
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
        hash += (int) usuarioId;
        hash += (int) grupoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PertenecePK)) {
            return false;
        }
        PertenecePK other = (PertenecePK) object;
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        if (this.grupoId != other.grupoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "redsocialjsf.entity.PertenecePK[ usuarioId=" + usuarioId + ", grupoId=" + grupoId + " ]";
    }
    
}
