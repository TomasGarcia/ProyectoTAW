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
import redsocialjsf.dao.UsuarioFacade;
import redsocialjsf.entity.Usuario;

/**
 *
 * @author Hp
 */
@Named(value = "loginBean")
@Dependent
public class loginBean {

    @EJB private UsuarioFacade usuarioFacade;
    
    protected List<Usuario> listaUsuarios;
    protected Usuario usuario;
    
    public loginBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioFacade getUserFacade() {
        return usuarioFacade;
    }

    public void setUserFacade(UsuarioFacade userFacade) {
        this.usuarioFacade = userFacade;
    }
    
    @PostConstruct
    public void init(){
        listaUsuarios = this.usuarioFacade.findAll();
    }
    
    
    
}
