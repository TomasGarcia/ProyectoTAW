/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import redsocialjsf.entity.Usuario;

/**
 *
 * @author Jose
 */
@Named(value = "participantesBean")
@RequestScoped
public class participantesBean {
@Inject GruposBean gruposBean;
private List<Usuario> participantes;

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
    /**
     * Creates a new instance of participantesBean
     */
    public participantesBean() {
    }
    
    @PostConstruct
    public void init(){
        participantes=gruposBean.getGruposeleccionado().getUsuarioList();
    }
    
}
