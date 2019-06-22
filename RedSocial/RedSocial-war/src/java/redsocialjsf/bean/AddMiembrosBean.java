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
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import redsocialjsf.dao.GrupoFacade;
import redsocialjsf.entity.Grupo;
import redsocialjsf.entity.Usuario;

/**
 *
 * @author Jose
 */
@Named(value = "addMiembrosBean")
@RequestScoped
public class AddMiembrosBean {

    @Inject GruposBean gruposBean;
    private Grupo grupo;
    private List<Usuario> listaAmigos;
    
    
    public AddMiembrosBean() {
    }
    
    @PostConstruct
    private void init(){
      grupo=gruposBean.getGruposeleccionado();
      listaAmigos=gruposBean.usuario.getUsuarioList();
      
      
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

    public List<Usuario> getListaAmigos() {
        return listaAmigos;
    }

    public void setListaAmigos(List<Usuario> listaAmigos) {
        this.listaAmigos = listaAmigos;
    }
    
    
    
}
