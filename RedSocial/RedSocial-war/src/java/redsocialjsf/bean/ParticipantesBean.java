/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import redsocialjsf.dao.GrupoFacade;
import redsocialjsf.entity.Grupo;
import redsocialjsf.entity.Usuario;

/**
 *
 * @author Jose
 */
@Named(value = "participantesBean")
@RequestScoped
public class ParticipantesBean {
    @EJB GrupoFacade grupoFacade;
    @Inject GruposBean gruposBean;
    @Inject PostBean postBean;
    private List<Usuario> participantes;
    private Usuario usuario;
    private Grupo grupo;

    public GruposBean getGruposBean() {
        return gruposBean;
    }

    public void setGruposBean(GruposBean gruposBean) {
        this.gruposBean = gruposBean;
    }

    public List<Usuario> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Usuario> participantes) {
        this.participantes = participantes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    /**
     * Creates a new instance of participantesBean
     */
    public ParticipantesBean() {
    }
    
    @PostConstruct
    public void init(){
        this.usuario = postBean.getUsuario();
        this.grupo = this.postBean.getGrupoSeleccionado();
        this.participantes = this.grupo.getUsuarioList();
    }
    
    public String volver(){
        return "muro";
    }
    
    public String doEliminar(Usuario u){
        this.participantes.remove(u);
        this.grupo.setUsuarioList(participantes);
        this.grupoFacade.edit(grupo);
        return null;
    }
    
    public Boolean puedeEliminar(Usuario u){
        return (this.grupo.getUsuarioId().getId().equals(this.usuario.getId()) && !this.usuario.getId().equals(u.getId()))
                || (this.usuario.getId().equals(u.getId()) && !this.grupo.getUsuarioId().getId().equals(u.getId()));
    }
}
