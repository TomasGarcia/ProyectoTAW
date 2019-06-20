/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;


import javax.inject.Inject;
import redsocialjsf.dao.GrupoFacade;
import redsocialjsf.entity.Grupo;

/**
 *
 * @author Jose
 */
@Named(value = "editarGrupoBean")
@RequestScoped
public class editarGrupoBean {
@Inject GruposBean gruposBean;
private String nombre;
private String descripcion;
@EJB GrupoFacade grupoFacade;

    public GruposBean getGruposBean() {
        return gruposBean;
    }

    public void setGruposBean(GruposBean gruposBean) {
        this.gruposBean = gruposBean;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Creates a new instance of editarGrupoBean
     */
    public editarGrupoBean() {
    }
    
    @PostConstruct
    public void init(){
        
        this.nombre=gruposBean.getGruposeleccionado().getNombre();
        this.descripcion=gruposBean.getGruposeleccionado().getDescripcion();
        
    }
    
    public String doEditar(){
        Grupo grupo=gruposBean.getGruposeleccionado();
        grupo.setNombre(nombre);
        grupo.setDescripcion(descripcion);
        grupoFacade.edit(grupo);
        return "muro";
    }
    
    public String doVolver(){
        return "muro";
    }
    
    
}
