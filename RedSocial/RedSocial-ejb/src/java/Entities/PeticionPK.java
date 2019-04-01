/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author oscar
 */
@Embeddable
public class PeticionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_id")
    private int usuarioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_id1")
    private int usuarioId1;

    public PeticionPK() {
    }

    public PeticionPK(int usuarioId, int usuarioId1) {
        this.usuarioId = usuarioId;
        this.usuarioId1 = usuarioId1;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getUsuarioId1() {
        return usuarioId1;
    }

    public void setUsuarioId1(int usuarioId1) {
        this.usuarioId1 = usuarioId1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuarioId;
        hash += (int) usuarioId1;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeticionPK)) {
            return false;
        }
        PeticionPK other = (PeticionPK) object;
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        if (this.usuarioId1 != other.usuarioId1) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.PeticionPK[ usuarioId=" + usuarioId + ", usuarioId1=" + usuarioId1 + " ]";
    }
    
}
