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

    @EJB protected GrupoFacade grupoFacade;
    @EJB protected UsuarioFacade usuarioFacade;
    @Inject LoginBean loginBean;
    protected Usuario usuario;
    protected List<Grupo> listaGrupos;
    protected String nombreIntroducido;
    protected List<Integer> listaCodigoCreadores;
    protected List<Usuario> listaCreadores;

    public List<Integer> getListaCodigoCreadores() {
        return listaCodigoCreadores;
    }

    public void setListaCodigoCreadores(List<Integer> listaCodigoCreadores) {
        this.listaCodigoCreadores = listaCodigoCreadores;
    }

    public List<Usuario> getListaCreadores() {
        return listaCreadores;
    }

    public void setListaCreadores(List<Usuario> listaCreadores) {
        this.listaCreadores = listaCreadores;
    }
    
    
    
    public GruposBean() {
    }
    
    public String doFiltrarPorNombre(){
        if(!nombreIntroducido.equals(""))
            listaGrupos=grupoFacade.buscarPorNombre(nombreIntroducido);
        else
            listaGrupos =this.grupoFacade.buscarPorCreadorYMiembro(this.usuario.getId());
        return null;
    }
    
    public String doFiltrarPorCreador(){
        listaGrupos=grupoFacade.doFiltrarPorCreador(listaCodigoCreadores);
        return null;
        
    }
    
    public String doCrearGrupo(){
        return "crearGrupo";
    }
    
    @PostConstruct
    public void init(){
        this.nombreIntroducido = "";
        this.usuario=loginBean.getUsuario();
        this.listaGrupos=grupoFacade.buscarPorCreadorYMiembro(usuario.getId());
        this.listaCreadores=usuarioFacade.findAll();
        
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
    
    
    
}
