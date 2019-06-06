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
import javax.inject.Inject;
import redsocialjsf.dao.GrupoFacade;
import redsocialjsf.entity.Grupo;
import redsocialjsf.entity.Usuario;

/**
 *
 * @author Jose
 */
@Named(value = "gruposBean")
@Dependent
public class GruposBean {

    @EJB protected GrupoFacade grupoFacade;
    @Inject LoginBean loginBean;
    protected Usuario usuario;
    protected List<Grupo> listaGrupos;

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
    
    public GruposBean() {
    }
    
    @PostConstruct
    public void init(){
        
        this.usuario=loginBean.getUsuario();
        this.listaGrupos=grupoFacade.buscarPorCreador(usuario.getId());
        
    }
    
}
