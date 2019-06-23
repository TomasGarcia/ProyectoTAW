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
import redsocialjsf.entity.Grupo;
import redsocialjsf.entity.Post;

/**
 *
 * @author Jose
 */
@Named(value = "mensajesBean")
@RequestScoped
public class MensajesBean {
    
    @Inject GruposBean gruposBean;
    private Grupo grupo;
    private List<Post> listaMensajes;

    /**
     * Creates a new instance of MensajesBean
     */
    public MensajesBean() {
    }
    
    @PostConstruct
    public void init(){
        grupo=gruposBean.getGruposeleccionado();
        listaMensajes=grupo.getPostList();
    }

    public GruposBean getGruposBean() {
        return gruposBean;
    }

    public void setGruposBean(GruposBean gruposBean) {
        this.gruposBean = gruposBean;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Post> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(List<Post> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }
    
}
