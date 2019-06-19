/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.bean;

import java.util.Date;
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
@Named(value = "crearGrupoBean")
@RequestScoped
public class CrearGrupoBean {
    protected Grupo nuevoGrupo;
    protected String nombre;
    protected String descripcion;
    @Inject LoginBean loginBean;
    protected Usuario creador;
    @EJB protected GrupoFacade grupoFacade;

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }
    

    public Grupo getNuevoGrupo() {
        return nuevoGrupo;
    }

    public void setNuevoGrupo(Grupo nuevoGrupo) {
        this.nuevoGrupo = nuevoGrupo;
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
    
    @PostConstruct
    public void init(){
        this.creador=loginBean.getUsuario();
    }
    
    public String  doCrear(){
        this.nuevoGrupo=new Grupo();
        this.nuevoGrupo.setId(0);
        this.nuevoGrupo.setNombre(nombre);
        this.nuevoGrupo.setDescripcion(descripcion);
        this.nuevoGrupo.setFechaCreacion(new Date());
//        this.nuevoGrupo.setUsuario(creador);
//        this.nuevoGrupo.setPertenece(new Pertenece(nuevoGrupo.getId(),creador.getId()));
        this.grupoFacade.create(nuevoGrupo);
        return "muro";
    }
    
    public String doVolver(){
        return "muro";
    }

    /**
     * Creates a new instance of CrearGrupoBean
     */
    public CrearGrupoBean() {
    }
    
}
