/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import redsocialjsf.dao.GrupoFacade;
import redsocialjsf.dao.UsuarioFacade;
import redsocialjsf.entity.Grupo;
import redsocialjsf.entity.Usuario;

/**
 *
 * @author Jose
 */
@Named(value = "gruposBean")
@RequestScoped
public class GruposBean {

    @EJB
    protected GrupoFacade grupoFacade;
    @EJB
    protected UsuarioFacade usuarioFacade;
    @Inject
    LoginBean loginBean;
    @Inject PostBean postBean;
    protected Usuario usuario;
    protected List<Grupo> listaGrupos;
    protected String nombreIntroducido;
    protected Grupo gruposeleccionado;
    

    public Grupo getGruposeleccionado() {
        return gruposeleccionado;
    }

    public void setGruposeleccionado(Grupo gruposeleccionado) {
        this.gruposeleccionado = gruposeleccionado;
    }

    public GrupoFacade getGrupoFacade() {
        return grupoFacade;
    }

    public void setGrupoFacade(GrupoFacade grupoFacade) {
        this.grupoFacade = grupoFacade;
    }

    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }
    

    public GruposBean() {
    }

    public String doFiltrarPorNombre() {
        if (!nombreIntroducido.equals("")) {
            listaGrupos = grupoFacade.buscarPorNombre(nombreIntroducido);
        } else {
            listaGrupos = this.grupoFacade.buscarPorCreadorYMiembro(this.usuario.getId());
        }
        return null;
    }

    

    public String doCrearGrupo() {
        return "crearGrupo";
    }
    
    public String doEliminarGrupo(Grupo g){
        this.listaGrupos.remove(g);
        this.grupoFacade.remove(g);
        return null;
    }
    
    public Boolean puedeEliminar(int id){
        return this.getUsuario().getId().equals(id);
    }

    @PostConstruct
    public void init() {
        this.nombreIntroducido = "";
        this.usuario = loginBean.getUsuario();
        this.listaGrupos = grupoFacade.buscarPorCreadorYMiembro(usuario.getId());
        this.gruposeleccionado = this.postBean.getGrupoSeleccionado();
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Grupo> getListaGrupos() {
        return listaGrupos;
    }

    public void setListaGrupos(List<Grupo> listaGrupos) {
        this.listaGrupos = listaGrupos;
    }

    public String getNombreIntroducido() {
        return nombreIntroducido;
    }

    public void setNombreIntroducido(String nombreIntroducido) {
        this.nombreIntroducido = nombreIntroducido;
    }
    
    public String doEditarGrupo(){
        this.grupoFacade.edit(this.gruposeleccionado);
        this.init();
        return "muro";
    }
    
    public String doVolver(){
        return "muro";
    }
    
    public String verMiembros(Grupo g){
        this.gruposeleccionado=g;
        return "verMiembros";
    }

}
