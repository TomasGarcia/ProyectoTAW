/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import redsocialjsf.dao.GrupoFacade;
import redsocialjsf.dao.UsuarioFacade;
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
    @Inject PostBean postBean;
    @EJB GrupoFacade grupoFacade;
    @EJB UsuarioFacade usuarioFacade;
    private Grupo grupo;
    private List<Usuario> listaAmigos;
    private List<Usuario> miembros;
    private Integer amigoSeleccionado;
    private Usuario usuario;
    
    public AddMiembrosBean() {
    }
    
    @PostConstruct
    public void init(){
        this.grupo = this.postBean.getGrupoSeleccionado();
        this.usuario = this.postBean.getUsuario();
        this.listaAmigos = new ArrayList(this.usuario.getUsuarioList());
        this.miembros = this.grupo.getUsuarioList();
        this.listaAmigos.removeAll(miembros);
    }

    public String doAdd(){
        
        this.miembros.add(this.usuarioFacade.find(amigoSeleccionado));
        this.grupo.setUsuarioList(miembros);
        this.grupoFacade.edit(grupo);
        
        return "muro";
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

    public List<Usuario> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<Usuario> miembros) {
        this.miembros = miembros;
    }

    public Integer getAmigoSeleccionado() {
        return amigoSeleccionado;
    }

    public void setAmigoSeleccionado(Integer amigoSeleccionado) {
        this.amigoSeleccionado = amigoSeleccionado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
